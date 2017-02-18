package com.infotrends.servlet;

/**
 * @author Lin
 */

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;

@Path("/PersonGroupInfo")
public class PersonGroupInfoServlet {
	/**
	 * 使用POST方法Insert個人資料
	 * 
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("method") String method,
			@FormParam("person_dbid") long person_dbid,
			@FormParam("group_dbid") long group_dbid

			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_group_person cfg_group_person = new CFG_group_person();
		jsonObject.put("status", Variable.POST_STATUS);
		try{
			if(method.trim().equals("insert")){
				MaintainService maintainService = new MaintainService();
				cfg_group_person.setPerson_dbid(person_dbid);
				cfg_group_person.setGroup_dbid(group_dbid);
				int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
				jsonObject.put("group_person_insertcount", grouppersoncount);
			}else if(method.trim().equals("delete")){
				if(person_dbid!=0){
					cfg_group_person.setPerson_dbid(person_dbid);
				}
				if(group_dbid!=0){
					cfg_group_person.setGroup_dbid(group_dbid);
				}
				if(group_dbid!=0&&person_dbid!=0){
					jsonObject.put("error", "You can not enter two values.");
				}else if(group_dbid==0&&person_dbid==0){
					jsonObject.put("error", "You need to enter value.");
				}else{
					MaintainService maintainService = new MaintainService();
					int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
					jsonObject.put("delete_group_personcount", deletegrouppersoncount);
				}
			}else{
				jsonObject.put("error", "You need to enter method.");
			}
			
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
