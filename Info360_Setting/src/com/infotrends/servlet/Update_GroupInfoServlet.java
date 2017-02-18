package com.infotrends.servlet;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Update_GroupInfo")
public class Update_GroupInfoServlet {
	/**
	 * 雿輻POST�寞�
	 * �湔蝢斤�鞈�
	 * @param name
	 * @param state
	 * @return
	 * @throws IOException
	 */

	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("dbid") int dbid,
			@FormParam("name") String name,
			@FormParam("state") int state
			//@FormParam("person_dbid") long person_dbid
			) throws IOException {
	
		name=name.trim();
		

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		jsonObject.put("Status", Variable.POST_STATUS);
		cfg_group.setDbid(dbid);
		cfg_group.setName(name);
		cfg_group.setState(state);
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.update_GroupInfo(cfg_group);
			jsonObject.put("updatecount", updatecount);
			/*
			if(person_dbid!=0){
				List<CFG_group> cfg_grouplist = maintainService.query_Group_name(cfg_group);
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setGroup_dbid(cfg_grouplist.get(0).getDbid());
				cfg_group_person.setPerson_dbid(person_dbid);
				int persongroupcount = maintainService.update_Person_GroupInfo(cfg_group_person);
				jsonObject.put("person_group_insertcount", persongroupcount);
			}
			*/
			
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
