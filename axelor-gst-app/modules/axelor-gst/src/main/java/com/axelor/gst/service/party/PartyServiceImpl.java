package com.axelor.gst.service.party;

import java.util.List;

import com.axelor.gst.db.Sequence;
import com.axelor.gst.db.repo.SequenceRepository;
import com.axelor.gst.service.invoice.InvoiceServiceImpl;
import com.axelor.meta.db.MetaModel;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class PartyServiceImpl implements PartyServiceInterface{

	@Inject
	private InvoiceServiceImpl invoice;
	
	@Inject
	private SequenceRepository seqRepo;
	
	/**
	 *  Method to Set 
	 *  Sequence for Party
	 */
	
	@Override
	public void partySequence(ActionRequest request, ActionResponse response) {
			
	        int i,flag = 0;
			
			String temp1 = "";
			
			MetaModel metaModel = new MetaModel();
			Sequence sequence = new Sequence();
			
			List<Sequence> list = (List<Sequence>) seqRepo.all().fetch();
			
			for(i=0; i < list.size(); i++) {
				sequence = list.get(i);
				
				if(sequence.getModel() == null) {
					continue;
				}
				
				metaModel = sequence.getModel();
				
				if(metaModel.getFullName().equals("com.axelor.party.db.Party")) {
					
					String temp2 = sequence.getNextNumber();
					
					invoice.sequenceUpdate(sequence);
					
					response.setValue("reference", sequence.getNextNumber());
					
		            
					
					flag++;
					break;
				}
			}
			
			if(flag == 1) {
				response.setFlash("Success" + " " + temp1);
			} else {
				response.setFlash("No Sequence Avaliable");
			}
			
	}

}
