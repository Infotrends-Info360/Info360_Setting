package com.infotrends.servlet;

import java.io.IOException;



import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infotrends.bean.Activitygroups;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.SystemCfg;
import com.infotrends.dao.SystemCfgDao;
import com.infotrends.service.MaintainService;
import com.infotrends.util.Util;



/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Select_SystemCfg")
public class Select_SystemCfg_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
			
			) throws IOException {
		
		Gson gson = new Gson();
		MaintainService maintainservice = new MaintainService();	
		List<SystemCfg> SystemCfgs = maintainservice.selectAll_SystemCfg();
		String SystemCfgs_str = null;
		
		// 放入List中
		java.lang.reflect.Type listType = new TypeToken<List<SystemCfg>>() {}.getType();
		SystemCfgs_str = gson.toJson(SystemCfgs, listType);
		Util.getConsoleLogger().debug("SystemCfgs_str: " + SystemCfgs_str );

		return Response.status(200).entity(SystemCfgs_str)
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
