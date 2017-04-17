package com.infotrends.servlet;

import java.io.IOException;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.Activitydata;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.CaseComments;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Insert_CaseComments")
public class Insert_CaseComments_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("ixnid") String ixnid,
			@FormParam("contactid") String contactid,
			@FormParam("comment") String comment,
			@FormParam("status") String status,
			@FormParam("mediatype") String mediatype,
			@FormParam("source") String source,
			@FormParam("agentid") String agentid
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CaseComments casecomments = new CaseComments();
		
		 
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		//Util.getConsoleLogger().debug(strDate);
		casecomments.setDatetime(strDate);
		casecomments.setIxnid(ixnid);
		casecomments.setContactid(contactid);
		casecomments.setSource(source);
		casecomments.setStatus(status);
		casecomments.setAgentid(agentid);
		casecomments.setMediatype(mediatype);
		casecomments.setComment(comment);
		
		
		MaintainService maintainservice = new MaintainService();		
		int insert_casecomments = maintainservice.Insert_casecomments(casecomments);
	    
    		jsonObject.put("casecomments", insert_casecomments);
  
  	  
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
