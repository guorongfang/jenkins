package com.mentor.jenkins.demo;

import javax.ejb.Stateless; 

/** 
 * Session Bean implementation class FirstDemo 
*/ 

@Stateless (mappedName = "FirstDemoEJB/Remote") 
public class FirstDemo implements FirstDemoRemote { 
	
	/** 
	 * Default constructor. 
	 */ 
	public FirstDemo() { 
		// TODO Auto-generated constructor stub 
	}
	
	@Override public String testDemo() { 
		// TODO Auto-generated method stub 
		return "Test Jenkins Demo"; 
	} 
}

