package com.axelor.gst.service.invoiceLine;

import java.math.BigDecimal;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceMain;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceLineImple implements InvoiceLineInterface {

			
	/**
	 * 
	 * InvoiceLine Data Calculation
	 * Method
	 * 
	 */
		
	@Override
    public void invoiceLineData(ActionRequest request,ActionResponse response) {
					
		BigDecimal netIgst = new BigDecimal("0");
		BigDecimal netSgst = new BigDecimal("0");
		BigDecimal grossAmount = new BigDecimal("0");
		BigDecimal netAmount = new BigDecimal("0");
		
		String companyStateName = "";
		String invoiceAddressStateName = "";
			
		Invoice invoiceLine = request.getContext().asType(Invoice.class);
		
		InvoiceMain invoice = request.getContext().getParent().asType(InvoiceMain.class);
		try {
			if(invoiceLine.getQuantity() != 0) {
					
				netAmount = invoiceLine.getPrice().multiply(
						      new BigDecimal(invoiceLine.getQuantity()));
				response.setValue("netAmount", netAmount);
				System.err.println(netAmount);
			
		
			companyStateName = invoice.getCompany().getAddress().getState().getName();
			
			invoiceAddressStateName = invoice.getInvoiceAddress().getState().getName();
			
			if(companyStateName.equals(invoiceAddressStateName)) {
				netSgst = netAmount.multiply(invoiceLine.getGstRate()).
				         divide(new BigDecimal("200"));
			
			    response.setValue("sgst",netSgst);
			    response.setValue("cgst",netSgst);
			    
			    response.setValue("igst",netIgst);     //to set it zero
				
				
			} else {
				
				netIgst = netAmount.multiply(invoiceLine.getGstRate()).
			 		     divide(new BigDecimal("100"));
			    response.setValue("igst",netIgst);
			    
			    response.setValue("sgst",netSgst);        //to set it zero
			    response.setValue("cgst",netSgst);        //to set it zero
				
			}
			
			grossAmount = netAmount.add(netIgst).add(netSgst).add(netSgst);
			
			response.setValue("grossAmount", grossAmount);
				
			} else {
					
					response.setValue("price",netIgst);
					response.setError("Quantity And Price can't remain Zero");
					
					
				} 
			
		}catch(Exception e) {
			if(invoice.getCompany() == null
					&& invoice.getInvoiceAddress() == null) {
				
				response.setValue("price",netIgst);
				response.setError("Plesea select Party OR Company in Invoice First with valid address");
				
				
			} else {
				response.setError("Gst Rate,Quantity And Price can't remain Empty. \n To select Rate Please Select Product");
				response.setValue("price", new BigDecimal("0"));
			}
		}
		
	}
	
	
}
