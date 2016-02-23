package com.test.qlc.bean;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="User")
public class UserImpl implements User {
	String name;
	public UserImpl() {
	}
	public UserImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
