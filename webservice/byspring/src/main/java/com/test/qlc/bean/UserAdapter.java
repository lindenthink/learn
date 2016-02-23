package com.test.qlc.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserAdapter extends XmlAdapter<UserImpl, User>{

	/**
	 * ½â×é
	 */
	@Override
	public User unmarshal(UserImpl v) throws Exception {
		return v;
	}

	/**
	 * ±à×é
	 */
	@Override
	public UserImpl marshal(User v) throws Exception {
		if(v instanceof UserImpl){
			return (UserImpl) v;
		}
		return new UserImpl(v.getName());
	}
	
}
