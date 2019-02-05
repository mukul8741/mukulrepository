package com.axelor.binding;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.axelor.RestServ;

@ApplicationPath("app")
public class MyApplication extends Application{
	public Set<Object> singletons = new HashSet<Object>();
	
	public MyApplication() {
		singletons.add(new RestServ());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}

