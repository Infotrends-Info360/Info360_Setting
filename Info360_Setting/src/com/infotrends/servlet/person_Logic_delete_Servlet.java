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

import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Person_logicdelete")
public class person_Logic_delete_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(

			@FormParam("account") 	String account,
			@FormParam("state") 	int state
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();

		cfg_person.setAccount(account);
		cfg_person.setState(state);
	
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.Logic_Delete(cfg_person);
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
