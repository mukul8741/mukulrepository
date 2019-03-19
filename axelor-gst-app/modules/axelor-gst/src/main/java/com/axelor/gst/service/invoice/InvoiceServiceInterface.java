package com.axelor.gst.service.invoice;



import java.util.Date;
import java.util.List;
import java.util.Map;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceMain;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.repo.InvoiceMainRepository;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.db.repo.ProductRepository;
import com.axelor.gst.service.invoiceLine.InvoiceLineInterface;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public interface InvoiceServiceInterface {
	
	public void invoiceDataCalculate(ActionRequest request,ActionResponse response);
	public void invoiceSequence(ActionRequest request,ActionResponse response);
	public void partyOnChange(ActionRequest request, ActionResponse response);
	public List<Invoice> createInvoiceFromProduct(List<Product> productList);
	public String sequenceUpdate(Sequence sequence) ;

}
