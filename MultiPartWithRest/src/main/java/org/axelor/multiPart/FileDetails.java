package org.axelor.multiPart;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileDetails {
	
	@FormParam("name")
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	byte[] data;

	public byte[] getData() {
		return data;
	}

	@FormParam("file")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
