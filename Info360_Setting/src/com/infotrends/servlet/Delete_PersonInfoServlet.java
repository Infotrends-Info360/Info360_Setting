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
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;


@Path("/Delete_PersonInfo")
public class Delete_PersonInfoServlet {
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
    		
    	
			@FormParam("personDBID_list") String personDBID_list

   
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person= new CFG_person();
		jsonObject.put("Status", Variable.POST_STATUS);
		
		List<Integer> personDBID_list2 = new ArrayList<Integer>();
		//List<Long> personDBID_list2_Long = new ArrayList<Long>();

		MaintainService maintainService = new MaintainService();
		
		if(personDBID_list.length()>0){
			String [] dd = personDBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				personDBID_list2.add(Integer.valueOf(dd[i]));
				//personDBID_list2_Long.add(Long.valueOf(dd[i]));
				
				CFG_group_person cfg_group_person = new CFG_group_person();
				cfg_group_person.setPerson_dbid(Long.valueOf(dd[i]));
				int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
				jsonObject.put("delete_group_personcount", deletegrouppersoncount);
			}
			cfg_person.setPersonDBID_list(personDBID_list2);
		}
	//long a = Long.valueOf(personDBID_list2);
	
		try{
			
			int deletepersoncount = maintainService.delete_PersonInfo(cfg_person);
			jsonObject.put("delete_personcount", deletepersoncount);
		
			
			
			
			
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
