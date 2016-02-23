package com.test.qlc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "IntegerUserMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerUserMap {
	@XmlElement(required = true,nillable = false)
	List<IntegerUserEntry> entries = new ArrayList<IntegerUserEntry>();
	
	public List<IntegerUserEntry> getEntries() {
        return entries;
    }
	
	
	
	@XmlType(name="IdentifiedUser")
	@XmlAccessorType(XmlAccessType.FIELD)
	static class IntegerUserEntry{
		@XmlElement(required = true,nillable = false)
		Integer Id;
		
		User user;
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
	}
}
