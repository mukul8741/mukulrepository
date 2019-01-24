package book;

import javax.persistence.*;

@Embeddable
public class Location implements Interfc {
	String city;
	
	String country;
	
	public Location(String city,String country) {
		this.city = city;
		
		this.country = country;
		
	}
	
	public Location() {
		
	}

	@Override
	public String city() {
		// TODO Auto-generated method stub
		return city;
	}

	@Override
	public String country() {
		// TODO Auto-generated method stub
		return country;
	}
	
	
}
