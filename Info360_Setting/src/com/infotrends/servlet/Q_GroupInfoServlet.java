package com.infotrends.servlet;

/**
 * @author Lin
 */

import java.io.IOException;
import java.lang.reflect.Array;
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

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;

@Path("/about_GroupInfo")
public class Q_GroupInfoServlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("state") int state

		
			) throws IOException {
		
	
		JSONObject jsonObject = new JSONObject();

		CFG_function cfg_function =new CFG_function();

		CFG_person cfg_person = new CFG_person();


		JSONArray FunctionJsonArray = new JSONArray();
		JSONArray PersonionJsonArray = new JSONArray();
		cfg_function.setState(state);
		cfg_person.setState(state);
		
		try{
			MaintainService maintainService = new MaintainService();

				  //查尋sort=0的 方法
				    		cfg_function.setState(state);
			    			List<CFG_function> cfg_functionlist = maintainService.select_function_state(cfg_function);
				        	for(int a=0;a<cfg_functionlist.size();a++){
					        	JSONObject functionJsonObject = new JSONObject();
				        		functionJsonObject.put("dbid", cfg_functionlist.get(a).getDbid());
					        	functionJsonObject.put("name", cfg_functionlist.get(a).getName());
					        	
					        	FunctionJsonArray.put(functionJsonObject);
				        	}

					        jsonObject.put("Function", FunctionJsonArray);
					        
				
							
							cfg_person.setState(state);
			    			List<CFG_person> cfg_personlist = maintainService.Query_PersonInfo_STATE(cfg_person);
			    			for(int a=0;a<cfg_personlist.size();a++){
					        	JSONObject personlistJsonObject = new JSONObject();
					        	personlistJsonObject.put("dbid", cfg_personlist.get(a).getDbid());
					        	personlistJsonObject.put("name", cfg_personlist.get(a).getUser_name());
					        	PersonionJsonArray.put(personlistJsonObject);
				        	}

					        jsonObject.put("Person", PersonionJsonArray);

							
	
				
			
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