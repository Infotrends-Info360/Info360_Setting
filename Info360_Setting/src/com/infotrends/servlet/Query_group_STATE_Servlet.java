package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/QQuery_Group_STATE")
public class Query_group_STATE_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("state")
								int state) throws IOException {

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		cfg_group.setState(state);
		jsonObject.put("status", Variable.POST_STATUS);
		
		try{
			 MaintainService maintainService = new MaintainService();
			 List<CFG_group> cfg_grouplist = maintainService.Query_Group_state(cfg_group);
	    
	        JSONArray GroupJsonArray = new JSONArray();
	        for (int i = 0; i < cfg_grouplist.size(); i++) {
	        	JSONObject GroupJsonObject = new JSONObject();
	        	GroupJsonObject.accumulate("dbid", cfg_grouplist.get(i).getDbid());
			    GroupJsonObject.accumulate("name", cfg_grouplist.get(i).getName()); 
			    GroupJsonObject.accumulate("state", cfg_grouplist.get(i).getState());
	        	 
			    GroupJsonArray.put(GroupJsonObject);
	        }		
	        jsonObject.put("group", GroupJsonArray);
	       
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
				jsonObject.put("error", IsError.GET_EXCEPTION);
			else
				jsonObject.put("error", e.getMessage());
		}
		
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

}