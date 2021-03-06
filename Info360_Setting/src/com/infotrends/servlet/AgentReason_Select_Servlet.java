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
import com.infotrends.util.Util;



@Path("/Select_agentreason")
public class AgentReason_Select_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("flag") int flag
			) throws IOException {
		Util.getConsoleLogger().debug("AgentReason_Select_Servlet REST called");
		JSONObject jsonObject = new JSONObject();
		Cfg_AgentReason agentreason = new Cfg_AgentReason();
		
		agentreason.setFlag(flag);
			 
		MaintainService maintainservice = new MaintainService();		
		List<Cfg_AgentReason> agentreasonlist = maintainservice.Select_agentreason(agentreason);
	    
  	  JSONArray agentreasonJsonArray = new JSONArray();
  	  	
  	  	//Util.getConsoleLogger().debug("agentstatuslist: "+agentstatuslist.size());

  	 if(flag==0 ){
  		 for(int a = 0; a < agentreasonlist.size(); a++){
    		
	    	JSONObject agentreasonObject = new JSONObject();
	    	String ss = agentreasonlist.get(a).getAlarmduration();
	    	
	    	int i=ss.indexOf(".");
	    	ss= ss.substring(0, i);
	    	
	    	agentreasonObject.put("dbid", agentreasonlist.get(a).getDbid());
	    	agentreasonObject.put("statusname", agentreasonlist.get(a).getStatusname());
	    	agentreasonObject.put("statusname_cn", agentreasonlist.get(a).getStatusname_cn());
	    	agentreasonObject.put("statusname_en", agentreasonlist.get(a).getStatusname_en());
	    	agentreasonObject.put("statusname_tw", agentreasonlist.get(a).getStatusname_tw());
	    	agentreasonObject.put("description", agentreasonlist.get(a).getDescription());
	    	agentreasonObject.put("alarmduration", ss);
	    	agentreasonObject.put("alarmcolor", agentreasonlist.get(a).getAlarmcolor());
	    	agentreasonObject.put("createdatetime", agentreasonlist.get(a).getCreatedatetime());
	    	agentreasonObject.put("createuserid", agentreasonlist.get(a).getCreateuserid());
	    	
	    	
	    	
	    	
	    	if(agentreasonlist.get(a).getFlag()==2){
		    	agentreasonObject.put("flag", "鎖定");
		    	agentreasonJsonArray.put(agentreasonObject);

	    	}else {
		    	agentreasonObject.put("flag", "");
		    	agentreasonJsonArray.put(agentreasonObject);
	    	}
  		 }
  	 }
  	  if(flag==1){
    	for(int a = 0; a < agentreasonlist.size(); a++){
    		
	    	JSONObject agentreasonObject = new JSONObject();
	    
	    	agentreasonObject.put("dbid", agentreasonlist.get(a).getDbid());
	    	agentreasonObject.put("statusname", agentreasonlist.get(a).getStatusname());
	    	agentreasonObject.put("statusname_cn", agentreasonlist.get(a).getStatusname_cn());
	    	agentreasonObject.put("statusname_en", agentreasonlist.get(a).getStatusname_en());
	    	agentreasonObject.put("statusname_tw", agentreasonlist.get(a).getStatusname_tw());
	    	agentreasonObject.put("description", agentreasonlist.get(a).getDescription());
	    	agentreasonObject.put("alarmduration", agentreasonlist.get(a).getAlarmduration());
	    	agentreasonObject.put("alarmcolor", agentreasonlist.get(a).getAlarmcolor());
	    	agentreasonObject.put("flag", "");
	    	agentreasonObject.put("createdatetime", agentreasonlist.get(a).getCreatedatetime());
	    	agentreasonObject.put("createuserid", agentreasonlist.get(a).getCreateuserid());

	    	agentreasonJsonArray.put(agentreasonObject);
  	}
  	  }
    jsonObject.put("agentreason", agentreasonJsonArray);
    Util.getConsoleLogger().debug("jsonObject.toString(): " + jsonObject.toString());
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
