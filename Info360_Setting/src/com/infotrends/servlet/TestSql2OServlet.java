package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainSql2O;

/**
 * RESTful Test
 * @author Lin
 */

@Path("/testsql2o")
public class TestSql2OServlet {
	
	@GET
	@Path("JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetFromPathJson(@QueryParam("value")
	String value) throws IOException {
		
		CFG_person cfg_person = new CFG_person();
//		cfg_person.setAccount(account);
		
		MaintainSql2O maintainsql2o = new MaintainSql2O();
		
		List<CFG_person> tasks = maintainsql2o.query_Person_Json(cfg_person);
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tasks", tasks);

		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
	@GET
	@Path("GSON")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetFromPathGson(@QueryParam("value")
	String value) throws IOException {
		
		CFG_person cfg_person = new CFG_person();
//		cfg_person.setAccount(account);
		
		MaintainSql2O maintainsql2o = new MaintainSql2O();
		
		JsonArray tasks = maintainsql2o.query_Person_Gson(cfg_person);
		
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.add("Gson", tasks);

		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
