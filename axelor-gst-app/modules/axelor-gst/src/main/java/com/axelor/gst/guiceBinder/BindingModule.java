package com.axelor.gst.guiceBinder;

import com.axelor.app.AxelorModule;
import com.axelor.gst.service.invoice.InvoiceServiceImpl;
import com.axelor.gst.service.invoice.InvoiceServiceInterface;
import com.axelor.gst.service.invoiceLine.InvoiceLineImple;
import com.axelor.gst.service.invoiceLine.InvoiceLineInterface;
import com.axelor.gst.service.party.PartyServiceImpl;
import com.axelor.gst.service.party.PartyServiceInterface;

public class BindingModule extends AxelorModule{

	@Override
	protected void configure() {
		
		bind(InvoiceServiceInterface.class).to(InvoiceServiceImpl.class);
		bind(PartyServiceInterface.class).to(PartyServiceImpl.class);
		bind(InvoiceLineInterface.class).to(InvoiceLineImple.class);
		
	}

}
