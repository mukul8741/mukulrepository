package com.axelor.gst.service.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.Contact;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceMain;
import com.axelor.gst.db.Party;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.repo.InvoiceMainRepository;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.ProductRepository;
import com.axelor.gst.db.repo.SequenceRepository;
import com.axelor.gst.service.invoiceLine.InvoiceLineInterface;
import com.axelor.meta.db.MetaModel;
import com.axelor.meta.db.repo.MetaModelRepository;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class InvoiceServiceImpl implements InvoiceServiceInterface{
	
	@Inject 
	private SequenceRepository seqRepo;
	
	@Inject 
	MetaModelRepository metaRepo;
	
	
	/**
	 * 
	 * Invoice Sequence Finding
	 * Method
	 * 
	 */
	
	@Override
	public void invoiceSequence(ActionRequest request, ActionResponse response) {
		
		if(request.getContext().get("reference") == null) {
			
			int i,flag = 0;
			
			String temp1 = "";
			
			MetaModel metaModel = metaRepo.all().filter("self.fullName = ?","com.axelor.gst.db.InvoiceMain").fetchOne();
			Sequence sequence = new Sequence();
			
			sequence = (Sequence) seqRepo.all().filter("self.model=?",metaModel).fetchOne();
			
				if(sequence != null) {
				
					response.setValue("reference", sequence.getNextNumber());
					
		            temp1 = sequenceUpdate(sequence);
					response.setFlash("Success" + " " + temp1);
					
				}
			  
				else {
				response.setFlash("No Sequence Avaliable");
			}
			
		}
		
	}
		
	/**
	 * 
	 * Method for changes to be 
	 * done when Party is Selected
	 * 
	 */

	@Override
	public void partyOnChange(ActionRequest request, ActionResponse response) {
		
		   int defaultFlag = 0;
		   int i = 0;
		   int invoiceSetFlag = 0;
		   int shippingSetFlag = 0;
	
		   InvoiceMain invoice = request.getContext().asType(InvoiceMain.class);
	       
	       Party party = invoice.getParty();
	       
	       List<Contact> listContact = party.getContact();
	       List<Address> listAddress = party.getAddress();
	       
	       for(Contact contact:listContact) {
	         if(contact.getType().equals("primary")) {
	           response.setValue("partyContact",contact);
	           break;
	         }
	       }
	       
	       for(Address address:listAddress) {
	         if(address.getType().equals("default")) {
	           defaultFlag = i;
	         } else if(address.getType().equals("invoice")) {
	        	 response.setValue("invoiceAddress",address);
	        	 invoiceSetFlag++;
	        	 if(shippingSetFlag == 1)
	        		 break;
	         } else if(address.getType().equals("shipping")) {
	        	 response.setValue("shippingAddress", address);
	        	 shippingSetFlag++;
	        	 if(invoiceSetFlag == 1)
	        		 break;
	         }
	         
	         if(i == listAddress.size() - 1) {
	        	 if(invoiceSetFlag == 1)
	        	 {
	        		 response.setValue("shippingAddress",listAddress.get(defaultFlag));
	        		 break;
	        	 } else if(shippingSetFlag == 1) {
	        		 response.setValue("invoiceAddress",listAddress.get(defaultFlag));
	        		 break;
	        	 } else {
	        		 response.setValue("shippingAddress",listAddress.get(defaultFlag));
	        		 response.setValue("invoiceAddress",listAddress.get(defaultFlag));
                     break;
	        	 }
	        	 
	         }
	         
	         i++;
	       }
	       
	}
	
	 /**
		 * 
		 * Invoice Data Calculation
		 * Method After Adding InvoiceItems
		 * 
		 */
	
	    @Override
		public void invoiceDataCalculate(ActionRequest request,ActionResponse response) {
				
	   	    BigDecimal netAmount = new BigDecimal("0");
			BigDecimal netIgst = new BigDecimal("0");
			BigDecimal netCgst = new BigDecimal("0");
			BigDecimal netSgst = new BigDecimal("0");
			BigDecimal grossAmount = new BigDecimal("0");
				
			InvoiceMain invoice = request.getContext().asType(InvoiceMain.class);
				
			if(invoice.getUseInvoiceAddress() == true) {
				response.setValue("shippingAddress", invoice.getInvoiceAddress());
			}
			List<Invoice> invoiceLine = (List<Invoice>) invoice.getInvoiceItems();
			
		    for(Invoice invoiceLine1:invoiceLine) {
		     	netAmount = netAmount.add(invoiceLine1.getNetAmount());
		       	netIgst = netIgst.add(invoiceLine1.getIgst());
		       	netCgst = netCgst.add(invoiceLine1.getCgst());
		        netSgst = netSgst.add(invoiceLine1.getSgst());
		    }
		        
		    grossAmount = grossAmount.add(netAmount).add(netIgst).
		       		        add(netCgst).add(netSgst);
		        
		    response.setValue("netAmount", netAmount);
		    response.setValue("netIgst", netIgst);
		    response.setValue("netCgst", netCgst);
		    response.setValue("netSgst", netSgst);
		    response.setValue("grossAmount", grossAmount);
		    response.setAttr("useInvoiceAddress", "readonly", true);
		      
		}
	    
	    /**
		 * 
		 * Method to Update 
		 * Sequence
		 * 
		 */
		
		 @Override
		 @Transactional
		 public String sequenceUpdate(Sequence sequence) {
				
			int i,j,k;
				
			String temp1 = "";
				
			int prefixlength = sequence.getPrefix().length();
			int pading = sequence.getPadding();
			String tempNextNumber = (String) sequence.getNextNumber();
				
			String number = tempNextNumber.substring(prefixlength,(prefixlength + pading));
			
			int numberLength = number.length();
				
			for(k = (numberLength - 1); k >= 0; k--) {
				int tempNumb;
				if(number.charAt(k) == '9') {
					if(number.charAt(k-1) == '9') {
						continue;
					} else {
						tempNumb = Integer.parseInt(number.substring(k-1, numberLength));
						tempNumb ++;
							
						number = number.substring(0,k-1) + tempNumb;
						break;
					}
				} else {
					tempNumb = Integer.parseInt("" + number.charAt(k));
					tempNumb ++;
						
					number = number.substring(0,k) + tempNumb + number.substring(k+1,numberLength);
					break;
				}
			}
				
			temp1 = sequence.getPrefix() + number + sequence.getSuffix();
			sequence.setNextNumber(temp1);
				
				
			seqRepo.save(sequence);
				
			return temp1;
				
		}
		 
		/**
		 * 
		 * create Invoice from
		 * Product
		 *  
		 */
		public List<Invoice> createInvoiceFromProduct(List<Product> productList) {
			
			if(productList.isEmpty()) {
				System.err.println("empty");
			} else {
				Invoice invoiceLineObj = new Invoice();
				List<Invoice> invoiceLineList = new ArrayList();
				
				for(Product product:productList) {
					invoiceLineObj.setItem(product.getCode());
					invoiceLineObj.setGstRate(product.getGstRate());
					invoiceLineObj.setHsbn(product.getHsbn());
					invoiceLineObj.setProduct(product);
					
					invoiceLineList.add(invoiceLineObj);
					System.err.println(" not empty");
				}
				
				return invoiceLineList;
			}
			return null;
														
		}


}
