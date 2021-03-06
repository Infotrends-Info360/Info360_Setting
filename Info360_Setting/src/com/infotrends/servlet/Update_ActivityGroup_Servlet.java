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


@Path("/Update_ActivityGroup")
public class Update_ActivityGroup_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("activitymenuid") int activitymenuid,
			@FormParam("groupname") 	 String groupname,
			@FormParam("dbid") 			 int dbid,
			@FormParam("sort") 			 String sort
		
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitygroups activitygroups = new Activitygroups();
		
		activitygroups.setDbid(dbid);
		activitygroups.setActivitymenuid(activitymenuid);
		activitygroups.setGroupname(groupname);
		activitygroups.setSort(sort);
		
	
		MaintainService maintainservice = new MaintainService();		
		int Update = maintainservice.Update_activitygroups(activitygroups);
	    
    		jsonObject.put("activitygroups", Update);
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
