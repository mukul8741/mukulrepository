package com.axelor.report;
import java.util.ArrayList;
import java.util.List;

public class InitializePojo {

	public  List<POJO> getData() {
		
		List<POJO> list = new ArrayList<>();
		
		POJO obj = new POJO();
		
		obj.setName("Mukul");
		obj.setCity("Pilani");
		obj.setState("Rajasthan");
		obj.setCountry("India");
		obj.setPin(333031);
		
		list.add(obj);
		
		obj.setName("Piyush");
		obj.setCity("Surat");
		obj.setState("Gujarat");
		obj.setCountry("India");
		obj.setPin(333031);
		
		list.add(obj);
		
		return list;
		
	}

}
