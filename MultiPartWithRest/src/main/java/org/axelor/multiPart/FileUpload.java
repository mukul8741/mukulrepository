package org.axelor.multiPart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("upload")
public class FileUpload {
	
	@POST
	@Path("file") 
	@Consumes("multipart/form-data")
	
	public Response uploadFile(@MultipartForm FileDetails file) {
		
		String path = "/home/axelor/File-Upload/";
		
		File fileNew = new File(path + file.getName());
		
		if(!fileNew.exists()) {
			try {
				
				fileNew.createNewFile();
				
				FileOutputStream out = new FileOutputStream(fileNew);
				out.write(file.getData());
				out.flush();
				out.close();
				
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		
		
		return Response.status(200)
			    .entity("uploadFile is called, Uploaded file name : " + file.getName()).build(); 
	}

}