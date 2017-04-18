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
        String info360_DB_URL = context.getInitParameter("info360_DB_URL");
        String info360_DB_USER = context.getInitParameter("info360_DB_USER");
        String info360_DB_PASS = context.getInitParameter("info360_DB_PASS");
        
        Util.setInfoacd_URL_ALL(infoacd_URL_ALL);
        Util.setServiceNameCache_URL_ALL(ServiceNameCache_URL_ALL);
        Util.setinfo360_DB_URL(info360_DB_URL);
        Util.setinfo360_DB_USER(info360_DB_USER);
        Util.setinfo360_DB_PASS(info360_DB_PASS);
		
		System.out.println("Util.getInfoacd_URL_ALL(): " + Util.getInfoacd_URL_ALL());
		System.out.println("Util.getServiceNameCache_URL_ALL(): " + Util.getServiceNameCache_URL_ALL());
		System.out.println("Util.info360_DB_URL(): " + Util.getinfo360_DB_URL());
		System.out.println("Util.info360_DB_USER(): " + Util.getinfo360_DB_USER());
		System.out.println("Util.info360_DB_PASS(): " + Util.getinfo360_DB_PASS());
		
	}


}
