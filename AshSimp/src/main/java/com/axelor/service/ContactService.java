package com.axelor.service;

import java.util.List;

//import javax.persistence.Query;

import com.axelor.pojo.Contact;

public interface ContactService {
		public void addcontact(Contact c);
		public List<Contact> viewcontact();
		public void deletecontact(int id);
}