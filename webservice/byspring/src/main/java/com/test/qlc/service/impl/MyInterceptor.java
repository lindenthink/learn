package com.test.qlc.service.impl;


import java.util.Collection;
import java.util.Set;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptor;
public class MyInterceptor implements PhaseInterceptor<Message>{

	public void handleMessage(Message message) throws Fault {
		System.out.println("==========MyInterceptor called===========");
		return;
		
	}

	public void handleFault(Message message) {
		// TODO Auto-generated method stub
		System.out.println("==========handleFault called===========");
		
	}

	public Set<String> getAfter() {
		// TODO Auto-generated method stub
		System.out.println("==========getAfter called===========");
		return null;
	}

	public Set<String> getBefore() {
		// TODO Auto-generated method stub
		System.out.println("==========getBefore called===========");
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		System.out.println("==========getId called===========");
		return null;
	}

	public String getPhase() {
		// TODO Auto-generated method stub
		System.out.println("==========getPhase called===========");
		return null;
	}

	public Collection<PhaseInterceptor<? extends Message>> getAdditionalInterceptors() {
		// TODO Auto-generated method stub
		System.out.println("==========getAdditionalInterceptors called===========");
		return null;
	}

}
