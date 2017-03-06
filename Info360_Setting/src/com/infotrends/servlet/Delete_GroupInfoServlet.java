package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;


@Path("/Delete_GroupInfo")
public class Delete_GroupInfoServlet {
	/**
	 * 使用POST方法
	 * 刪除群組資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(
    		@FormParam("dbid") int dbid,
    		@FormParam("groupDBID_list") String groupDBID_list,
    		@FormParam("GP_DBID_list") String GP_DBID_list
    		
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group= new CFG_group();
		jsonObject.put("Status", Variable.POST_STATUS);
		
		List<Integer> groupDBID_list2 = new ArrayList<Integer>();

		List<Integer> GP_DBID_list2 = new ArrayList<Integer>();

		
		if(groupDBID_list.length()>0){
			String [] dd = groupDBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				groupDBID_list2.add(Integer.valueOf(dd[i]));
			}
			cfg_group.setGroupDBID_list(groupDBID_list2);
		}
		
	
		
		cfg_group.setDbid(dbid);
		
		try{
			MaintainService maintainService = new MaintainService();
			int deletegroupcount = maintainService.delete_GroupInfo(cfg_group);
			jsonObject.put("delete_groupcount", deletegroupcount);
			
			
			CFG_group_person cfg_group_person = new CFG_group_person();
			
			if(GP_DBID_list.length()>0){
				String [] dd = GP_DBID_list.split(",");
				for(int i=0 ;i<dd.length;i++){
					GP_DBID_list2.add(Integer.valueOf(dd[i]));
				}
				cfg_group_person.setGP_DBID_list(GP_DBID_list2);
			}
			cfg_group_person.setGroup_dbid(dbid);
			int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
			jsonObject.put("delete_group_personcount", deletegrouppersoncount);
			
			
			
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
