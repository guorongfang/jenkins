package com.mentor.jenkins.demo;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.Properties; 
import javax.naming.InitialContext; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import com.mentor.jenkins.demo.FirstDemoRemote;
	

/** 
 * Servlet implementation class TestServlet 
 */ 
@WebServlet("/TestServlet") 
public class TestServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	
	/** 
	 * @see HttpServlet#HttpServlet() 
	 */ 
	public TestServlet() { 
		super(); 
		// TODO Auto-generated constructor stub 
	} 
	
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO Auto-generated method stub 
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		Properties p = new Properties(); 
		p.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory"); 
		p.setProperty("java.naming.provider.url", "t3://localhost:7001"); 
		p.setProperty("java.naming.security.principal", "system"); 
		p.setProperty("java.naming.security.credentials", "mgcweb12"); 
		try { 
			InitialContext ctx = new InitialContext(p); 
			Object obj = ctx.lookup("FirstDemoEJB/Remote#com.mentor.jenkins.demo.FirstDemoRemote"); 
//			out.print(obj); 
			
			
			/* 
			 * Export it as a war file and deploye it on the same server. 
			 */ 
			FirstDemoRemote remote = (FirstDemoRemote)obj; 
			String result = remote.testDemo(); 
			
			System.out.println(result);
			
			out.print(result);
			
			out.flush();
		} 
		catch(Exception e) { 
			out.print(e.getStackTrace()); 
			out.print("Error"); 
		} 
	} 
	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO Auto-generated method stub 
	} 
}
