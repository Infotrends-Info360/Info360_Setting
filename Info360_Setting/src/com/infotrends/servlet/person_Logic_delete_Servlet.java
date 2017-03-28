package com.infotrends.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;



import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Person_logicdelete")
public class person_Logic_delete_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(

			@FormParam("dbid") 	int dbid,
			@FormParam("state") int state,
			
			@FormParam("personDBID_list") String personDBID_list,

			@FormParam("pass_error_count") 	int pass_error_count
			
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		List<Integer> personDBID_list2 = new ArrayList<Integer>();

		if(personDBID_list.length()>0){
			String [] dd = personDBID_list.split(",");
			for(int i=0 ;i<dd.length;i++){
				personDBID_list2.add(Integer.valueOf(dd[i]));
			}
			cfg_person.setPersonDBID_list(personDBID_list2);
		}
		
		
		
//		cfg_person.setDbid(dbid);
		cfg_person.setState(state);
		

		
		
	
		int updatecount=0;
		try{
			
			
			List<Integer> dbidS = new ArrayList<>();
			
			MaintainService maintainService = new MaintainService();
			if(state==0){
				cfg_person.setPass_error_count(0);
				updatecount = maintainService.Logic_Delete(cfg_person);
				jsonObject.put("updatecount", updatecount);
			}else if(state==2){
				cfg_person.setPass_error_count(3);
				updatecount = maintainService.Logic_Delete(cfg_person);
				jsonObject.put("updatecount", updatecount);
			}else if(state==3){
				updatecount = maintainService.Logic_Delete(cfg_person);
				jsonObject.put("updatecount", updatecount);
			}else{
				cfg_person.setPass_error_count(3);
				updatecount = maintainService.Logic_Delete(cfg_person);
				jsonObject.put("updatecount", updatecount);
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
