package com.infotrends.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Group_logicdelete")
public class group_Logic_delete_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(

			@FormParam("name") 	String name,
			@FormParam("state") 	int state
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();

		cfg_group.setName(name);
		cfg_group.setState(state);
	
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.Logic_Delete(cfg_group);
			jsonObject.put("updatecount", updatecount);
			
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
