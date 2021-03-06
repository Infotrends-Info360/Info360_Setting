package com.infotrends.servlet;

import java.io.IOException;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Update_ActivityMenu")
public class Update_ActivityMenu_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("dbid") 	int dbid,
			@FormParam("menuname") 	String menuname
		
		
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitymenu activitymenu = new Activitymenu();
		
		
		activitymenu.setDbid(dbid);
		activitymenu.setMenuname(menuname);

	
		
		MaintainService maintainservice = new MaintainService();		
		int Update = maintainservice.Update_activitymenu(activitymenu);
	    
    		jsonObject.put("activitymenu", Update);
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
