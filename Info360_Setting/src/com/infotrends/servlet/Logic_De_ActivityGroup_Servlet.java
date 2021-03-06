package com.infotrends.servlet;

import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@Path("/LogicDelete_ActivityGroup")
public class Logic_De_ActivityGroup_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
	
			@FormParam("groupname") String groupname,
			@FormParam("deleteflag") String deleteflag,
			@FormParam("deletedatetime") String deletedatetime,
    		@FormParam("ActivityGroup_DBID_list") String ActivityGroup_DBID_list

			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitygroups activitygroups = new Activitygroups();
		List<Integer> ActivityGroup_DBID_list2 = new ArrayList<Integer>();

		
		if(ActivityGroup_DBID_list.length()>0){
			String [] dd = ActivityGroup_DBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				ActivityGroup_DBID_list2.add(Integer.valueOf(dd[i]));
			}
			activitygroups.setActivityGroup_DBID_list(ActivityGroup_DBID_list2);
		}
		
		deleteflag.trim();
		activitygroups.setGroupname(groupname);
		activitygroups.setDeleteflag(deleteflag);
		
		
		if(activitygroups.getDeleteflag().equals("1")){
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		activitygroups.setDeletedatetime(strDate);
		
		}else{
		
			activitygroups.setDeletedatetime(null);
		}
		
		MaintainService maintainservice = new MaintainService();		
		int update = maintainservice.LogicDelete_activitygroups(activitygroups);
	    
  	  JSONArray activitygroupsJsonArray = new JSONArray();
  	 
	    	JSONObject activitygroupsObject = new JSONObject();
	    
	    	activitygroupsJsonArray.put(activitygroupsObject);
	    	jsonObject.put("activitygroups", update);
		
  		
    		
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
