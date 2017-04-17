package com.infotrends.filter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.infotrends.util.*;

@WebListener("application context listener")
public class SystemListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized() called");
        ServletContext context = event.getServletContext();
        String infoacd_URL_ALL = context.getInitParameter("infoacd_URL_ALL");
        String ServiceNameCache_URL_ALL = context.getInitParameter("ServiceNameCache_URL_ALL");
        
        Util.setInfoacd_URL_ALL(infoacd_URL_ALL);
        Util.setServiceNameCache_URL_ALL(ServiceNameCache_URL_ALL);
		
		System.out.println("Util.getInfoacd_URL_ALL(): " + Util.getInfoacd_URL_ALL());
		System.out.println("Util.getServiceNameCache_URL_ALL(): " + Util.getServiceNameCache_URL_ALL());
		
	}


}
