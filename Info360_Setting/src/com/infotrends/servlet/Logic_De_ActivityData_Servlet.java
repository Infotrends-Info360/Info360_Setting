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
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/LogicDelete_ActivityData")
public class Logic_De_ActivityData_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
	
			@FormParam("codename") String codename,
			@FormParam("deleteflag") String deleteflag,
			@FormParam("deletedatetime") String deletedatetime,
    		@FormParam("ActivityData_DBID_list") String ActivityData_DBID_list

			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitydata activitydata = new Activitydata();
		
		List<Integer> ActivityData_DBID_list2 = new ArrayList<Integer>();
		
		if(ActivityData_DBID_list.length()>0){
			String [] dd = ActivityData_DBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				ActivityData_DBID_list2.add(Integer.valueOf(dd[i]));
			}
			activitydata.setActivityData_DBID_list(ActivityData_DBID_list2);
		}
		
		deleteflag.trim();
		activitydata.setCodename(codename);
		activitydata.setDeleteflag(deleteflag);
		
		
		if(activitydata.getDeleteflag().equals("1")){
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		activitydata.setDeletedatetime(strDate);
		
		}else{
		
			activitydata.setDeletedatetime(null);
		}
		
		MaintainService maintainservice = new MaintainService();		
		int update = maintainservice.LogicDelete_ActivityData(activitydata);
	    
  	  JSONArray activitydataJsonArray = new JSONArray();
  	 
	    	JSONObject activitydataObject = new JSONObject();
	    
	    	activitydataJsonArray.put(activitydataObject);
	    	jsonObject.put("activitydata", update);
		
  		
    		
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
