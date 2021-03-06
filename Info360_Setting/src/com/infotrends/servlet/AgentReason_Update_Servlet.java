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

import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Update_agentreason")
public class AgentReason_Update_Servlet {
	

	/**
	 * @param statusname
	 * @param statusname_cn
	 * @param statusname_en
	 * @param statusname_tw
	 * @param description
	 * @param alarmduration
	 * @param alarmcolor
	 * @param flag
	 * @param dbid
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("statusname") 	String statusname,
			@FormParam("statusname_cn") String statusname_cn,
			@FormParam("statusname_en") String statusname_en,
			@FormParam("statusname_tw") String statusname_tw,
			@FormParam("description") 	String description,
			@FormParam("alarmduration") String alarmduration,
			@FormParam("alarmcolor") 	String alarmcolor,
			@FormParam("flag") int flag,
			@FormParam("dbid") int dbid
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Cfg_AgentReason agentreason = new Cfg_AgentReason();
		
		agentreason.setFlag(flag);
		agentreason.setDbid(dbid);
		
		agentreason.setAlarmcolor(alarmcolor);
		agentreason.setAlarmduration(alarmduration);
		agentreason.setDescription(description);
		agentreason.setStatusname(statusname);
		agentreason.setStatusname_cn(statusname_cn);
		agentreason.setStatusname_en(statusname_en);
		agentreason.setStatusname_tw(statusname_tw);
		 
		 
		MaintainService maintainservice = new MaintainService();		
		int update = maintainservice.Update_agentreason(agentreason);
	    
  	  JSONArray agentreasonJsonArray = new JSONArray();
  	 
	    	JSONObject agentreasonObject = new JSONObject();
	    
	    	agentreasonJsonArray.put(agentreasonObject);
  		 
  	
    		jsonObject.put("agentreason", update);
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
