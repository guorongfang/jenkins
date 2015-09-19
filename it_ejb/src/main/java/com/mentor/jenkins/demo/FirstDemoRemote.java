package com.mentor.jenkins.demo;

import javax.ejb.Remote;

@Remote
public interface FirstDemoRemote {

	public String testDemo();
}
