package com.infotrends.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainSql2O;
import com.infotrends.util.Util;

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
		
		MaintainSql2O maintainsql2o = new MaintainSql2O();
		
		List<CFG_person> tasks = maintainsql2o.query_Person_Json(cfg_person);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("JSON", tasks);

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
		
//		CFG_person cfg_person = new CFG_person();
////		cfg_person.setAccount(account);
//		
//		MaintainSql2O maintainsql2o = new MaintainSql2O();
//		
////		JsonArray tasks = maintainsql2o.query_Person_Gson(cfg_person);
//		maintainsql2o.query_Person_Gson(cfg_person);
		JsonObject jsonObject = new JsonObject();
		
//		jsonObject.addProperty("Gson", cfg_person.getAccount());
		
//		Gson gson = new Gson();
//		
//		//CFG_person.class
//		CFG_person cfg_person2 = gson.fromJson(cfg_personList.toString(), CFG_person.class);
//		cfg_person2.getAccount();

		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS") //參數化
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
	public static void main(String[] args) {
		StringBuilder responseSB = null;
		try {
		URL url = new URL( "http://localhost:8080/Info360_Setting/RESTful/testsql2o/JSON");
		Util.getConsoleLogger().debug("url: " + url.toString() );
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
//		connection.setRequestProperty("Content-Length",
//				String.valueOf(postData.length()));

		// Write data
//		OutputStream os = connection.getOutputStream();
//		os.write(postData.getBytes());

		// Read response
		responseSB = new StringBuilder();
		BufferedReader br;
			br = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
		String line;
		while ((line = br.readLine()) != null)
			responseSB.append(line.trim());

		// Close streams
		br.close();
//		os.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("responseSB:"+ responseSB);
		
		//利用Gson與Bean
		Gson gson = new Gson();
		JSONObject jsonobject = new JSONObject(responseSB.toString()); 
		System.out.println("jsonobject:"+ jsonobject);
		JSONArray jsonarray = jsonobject.getJSONArray("JSON");
		
		CFG_person cfg_person2 = gson.fromJson(jsonarray.getJSONObject(0).toString(), CFG_person.class);
		
		System.out.println("cfg_person2.getAccount():"+ cfg_person2.getAccount());
	}
	
	
}
