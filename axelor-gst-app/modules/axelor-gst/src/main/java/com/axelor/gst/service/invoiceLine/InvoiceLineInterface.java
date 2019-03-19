package com.axelor.gst.service.invoiceLine;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.Company;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public interface InvoiceLineInterface {

	public void invoiceLineData(ActionRequest request,ActionResponse response);
	
}
