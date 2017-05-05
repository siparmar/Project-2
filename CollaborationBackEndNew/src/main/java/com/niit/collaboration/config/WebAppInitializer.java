package com.niit.collaboration.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	//web.xml
	
	protected Class<?>[] getRootConfigClasses(){
		return new Class[] { WebAppConfig.class };
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return null;
		
	}
	
	protected String[] getServletMappings(){
		return new String[] {"/"};
	}
}
