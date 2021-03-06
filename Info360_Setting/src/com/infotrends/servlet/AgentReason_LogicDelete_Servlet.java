package com.infotrends.servlet;

import java.io.IOException;



import java.math.BigDecimal;
import java.util.ArrayList;
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

@Path("/LogicDelete_agentreason")
public class AgentReason_LogicDelete_Servlet {
	

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
	
			@FormParam("flag") int flag,
			@FormParam("dbid") int dbid,
    		@FormParam("Agentreason_DBID_list") String Agentreason_DBID_list

			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Cfg_AgentReason agentreason = new Cfg_AgentReason();
		
		List<Integer> Agentreason_DBID_list2 = new ArrayList<Integer>();

		
		if(Agentreason_DBID_list.length()>0){
			String [] dd = Agentreason_DBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				Agentreason_DBID_list2.add(Integer.valueOf(dd[i]));
			}
			agentreason.setAgentreason_DBID_list(Agentreason_DBID_list2);
		}
		
		agentreason.setFlag(flag);
		agentreason.setDbid(dbid);
		
		MaintainService maintainservice = new MaintainService();		
		int update = maintainservice.LogicDelete_agentreason(agentreason);
	    
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
