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

import com.infotrends.bean.Activitygroups;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Insert_ActivityGroup")
public class Insert_ActivityGroup_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("activitymenuid") int activitymenuid,
			@FormParam("groupname") 	 String groupname,
			@FormParam("createdatetime") String createdatetime,
			@FormParam("sort") 			 String sort
		
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitygroups activitygroups = new Activitygroups();
		
		activitygroups.setActivitymenuid(activitymenuid);
		activitygroups.setGroupname(groupname);
		activitygroups.setSort(sort);
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		//Util.getConsoleLogger().debug(strDate);
		activitygroups.setCreatedatetime(strDate);
		
		MaintainService maintainservice = new MaintainService();		
		int insert = maintainservice.Insert_activitygroups(activitygroups);
	    
    		jsonObject.put("activitygroups", insert);
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
