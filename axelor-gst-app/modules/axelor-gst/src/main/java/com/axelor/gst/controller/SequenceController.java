package com.axelor.gst.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import org.apache.poi.hslf.record.Sound;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.mozilla.javascript.tools.shell.Global;
import org.yaml.snakeyaml.introspector.BeanAccess;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Contact;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceMain;
import com.axelor.gst.db.Party;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.repo.InvoiceMainRepository;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.PartyRepository;
import com.axelor.gst.db.repo.ProductRepository;
import com.axelor.gst.service.invoice.InvoiceServiceImpl;
import com.axelor.gst.service.invoiceLine.InvoiceLineInterface;
import com.axelor.gst.service.party.PartyServiceInterface;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class SequenceController {
	
	@Inject
	private InvoiceServiceImpl invoice;
	
	@Inject
	private PartyServiceInterface party;
	
	@Inject
	private PartyRepository partyRepo;
	
	@Inject
	private InvoiceLineInterface invoiceLine;
	
	@Inject
	public ProductRepository productRepo;
	
	@Inject
	public InvoiceMainRepository invoiceRepo;
	
	@Inject
	public InvoiceRepository invoiceLineRepo;
	
	public void invoiceCreateSequence(ActionRequest request,ActionResponse response) {
		invoice.invoiceSequence(request, response);
	}
	
	public void invoiceDataCalculate(ActionRequest request,ActionResponse response) {
		invoice.invoiceDataCalculate(request, response);
	}
	
	public void partyOnChangeEvent(ActionRequest request,ActionResponse response) {
		invoice.partyOnChange(request, response);
	}
	
	public void partyCreateSequence(ActionRequest request,ActionResponse response) {
		party.partySequence(request, response);
	}
	
	public void invoiceLineDataCalculate(ActionRequest request,ActionResponse response) {
		invoiceLine.invoiceLineData(request, response);
		
	}
	

    public void mainCreateInvoiceFromProduct(ActionRequest request, ActionResponse response) {
		
    	try {
    		List<Integer> idsList = new ArrayList<>();
		    idsList = (List<Integer>) request.getContext().get("_ids");
		    
		    System.err.println(idsList);
			
		    List<Product> productList = new ArrayList<>();
		    
		    productList = (List<Product>) productRepo.all().filter("id in ?",idsList).fetch();
			
    		List<Invoice> invoiceLineObj = invoice.createInvoiceFromProduct(productList);
    		response.setValue("invoiceItems", invoiceLineObj);
    		
 
    	}catch(Exception e) {
    		
    	}
    		
    }
    
    public void setContext(ActionRequest request, ActionResponse response) {
    	
    	Party party = partyRepo.all().filter("self.id = ?", ((Party)request.getContext().get("party")).getId()).fetchOne();
    	
    	List<Contact> listContact = party.getContact();
    	
    	List<Long> listId = new ArrayList();
    	
    	for(Contact contact:listContact) {
    		listId.add(contact.getId());
    	}
    	
    	request.getContext().put("partyId",listId);
    	
        List<Address> listAddress = party.getAddress();
        
        List<Long> listIdInvoice = new ArrayList();
        List<Long> listIdShipping = new ArrayList();
        
        for(Address address:listAddress) {
        	if(address.getType().equals("invoice") ) 
    		  listIdInvoice.add(address.getId());
        	else if(address.getType().equals("shipping"))
        		listIdShipping.add(address.getId());
            if(address.getType().equals("default") ) {
            	listIdInvoice.add(address.getId());
                listIdShipping.add(address.getId());
            }
        	
    	}
        
        request.getContext().put("iAddress", listIdInvoice);
        request.getContext().put("sAddress", listIdShipping);
    	
    	
        response.setValues(request.getContext());
    	
    }
    
    public void productReportSetContext(ActionRequest request, ActionResponse response) {
    	
    	Set<String> list1 = request.getContext().keySet();
    	System.out.println(list1);
    	System.out.println(request.getContext());
    	
    	List<Integer> list = (List<Integer>) request.getContext().get("_ids");
    
    	System.out.println(request.getContext().asType(Product.class));
    	System.out.println(request.getContext().get("_ids").toString() + " " + list);
    	
    	String sId = "";
    	
    	for(int id:list)
    		sId = sId + id;
    	
    	request.getContext().put("setId", sId);
    	
    	System.out.println(request.getContext().get("setId"));
    	response.setValues(request.getContext());
    	
    	System.out.println(request.getContext());
    }
    	
    
}
	



