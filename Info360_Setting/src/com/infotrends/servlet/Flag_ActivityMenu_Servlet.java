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

import com.infotrends.bean.Activitydata;
import com.infotrends.bean.Activitygroups;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Flag_ActivityMenu")
public class Flag_ActivityMenu_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("deleteflag") String deleteflag
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitymenu activitymenu = new Activitymenu();
		
		activitymenu.setDeleteflag(deleteflag);

		MaintainService maintainservice = new MaintainService();	
		
		JSONArray ActivitymenuJsonArray = new JSONArray();
  	 
	
		List<Activitymenu> activitymenulist = maintainservice.Flag_activitymenu(activitymenu);
		
		if(deleteflag.equals("0")){
			  for (int a = 0; a < activitymenulist.size(); a++) {
		  		  	JSONObject activitymenuObject = new JSONObject();
		  	  		activitymenuObject.put("dbid", activitymenulist.get(a).getDbid());
		  	  		activitymenuObject.put("deleteflag", activitymenulist.get(a).getDeleteflag());
		  	  		activitymenuObject.put("menuname", activitymenulist.get(a).getMenuname());
		  	  		activitymenuObject.put("sort", activitymenulist.get(a).getSort());
		  	  	
        			if(activitymenulist.get(a).getCreatedatetime()!=null && activitymenulist.get(a).getCreatedatetime()!=""){
        				
        				activitymenuObject.put("createdatetime", activitymenulist.get(a).getCreatedatetime().substring(0, 19));
        				ActivitymenuJsonArray.put(activitymenuObject);
        					
        			}else {
        						activitymenuObject.put("createdatetime", "");
        						ActivitymenuJsonArray.put(activitymenuObject);
        					}
		  	  }
			
		}
		
		
		if(deleteflag.equals("1")){
			
			  for (int i = 0; i < activitymenulist.size(); i++) {
		  		  	JSONObject activitymenuObject = new JSONObject();
		  	  		activitymenuObject.put("dbid", activitymenulist.get(i).getDbid());
		  	  		activitymenuObject.put("deleteflag", activitymenulist.get(i).getDeleteflag());
		  	  		activitymenuObject.put("menuname", activitymenulist.get(i).getMenuname());
		  	  		activitymenuObject.put("sort", activitymenulist.get(i).getSort());
		  	  	
		  	  	if(activitymenulist.get(i).getDeletedatetime()!=null && activitymenulist.get(i).getDeletedatetime()!=""){
    				activitymenuObject.put("deletedatetime", activitymenulist.get(i).getDeletedatetime().substring(0, 19));
    				ActivitymenuJsonArray.put(activitymenuObject);
    					
    			}else {
    						activitymenuObject.put("deletedatetime", "");
    						ActivitymenuJsonArray.put(activitymenuObject);
    					}
		  	  		
		  	  		
		  	  }
			
			
		}
	    
  	
  	  	
		jsonObject.put("activitymenu", ActivitymenuJsonArray);


		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
