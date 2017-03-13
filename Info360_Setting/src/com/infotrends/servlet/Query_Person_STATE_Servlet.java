package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/Query_Person_STATE")
public class Query_Person_STATE_Servlet {
	/**
	 * 使用POST方法
	 * 依據輸入DBID有無查詢個人帳號資訊或全體帳號資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("state")
								int state) throws IOException {

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		
		  JSONArray PersonJsonArray = new JSONArray();
		
		cfg_person.setState(state);
		jsonObject.put("status", Variable.POST_STATUS);
	
			MaintainService maintainService = new MaintainService();
	        List<CFG_person> cfg_personlist = maintainService.Query_PersonInfo_STATE(cfg_person);
	        if(state == 0 && state ==2){
	        	//撈取cfg_group_person關聯
	        	CFG_group_person cfg_group_person = new CFG_group_person();
	        	cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
	        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);
	        	
	        	JSONArray PersonGroupArray = new JSONArray();
	        	JSONArray GroupJsonArray = new JSONArray();
		        for (int i = 0; i < cfg_person_grouplist.size(); i++) {
		        	JSONObject PersonGroupJsonObject = new JSONObject();
		        	PersonGroupJsonObject.put("person_dbid", cfg_person_grouplist.get(i).getPerson_dbid());
		        	PersonGroupJsonObject.put("group_dbid", cfg_person_grouplist.get(i).getGroup_dbid()); 
		        	
		        	PersonGroupArray.put(PersonGroupJsonObject);
		        	
		        	//撈取cfg_group欄位
				    CFG_group cfg_group = new CFG_group();
				    cfg_group.setDbid(cfg_person_grouplist.get(i).getGroup_dbid());
				    List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
				    JSONObject GroupJsonObject = new JSONObject();
				    GroupJsonObject.put("dbid", cfg_grouplist.get(0).getDbid());
				    GroupJsonObject.put("name", cfg_grouplist.get(0).getName()); 
				    GroupJsonObject.put("state", cfg_grouplist.get(0).getState());
				    
				    GroupJsonArray.put(GroupJsonObject);
		        }		
		        jsonObject.put("person_group", PersonGroupArray);
		        jsonObject.put("group", GroupJsonArray);
	        }
	        
	        if(state == 1){
	        	//撈取cfg_group_person關聯
	        	if(cfg_personlist.size()!=0){
	        		
	        	
	        	CFG_group_person cfg_group_person = new CFG_group_person();
	        	cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
	        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);
	        	
	        	JSONArray PersonGroupArray = new JSONArray();
	        	JSONArray GroupJsonArray = new JSONArray();
		        for (int i = 0; i < cfg_person_grouplist.size(); i++) {
		        	JSONObject PersonGroupJsonObject = new JSONObject();
		        	PersonGroupJsonObject.put("person_dbid", cfg_person_grouplist.get(i).getPerson_dbid());
		        	PersonGroupJsonObject.put("group_dbid", cfg_person_grouplist.get(i).getGroup_dbid()); 
		        	
		        	PersonGroupArray.put(PersonGroupJsonObject);
		        	
		        	//撈取cfg_group欄位
				    CFG_group cfg_group = new CFG_group();
				    cfg_group.setDbid(cfg_person_grouplist.get(i).getGroup_dbid());
				    List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
				    JSONObject GroupJsonObject = new JSONObject();
				    GroupJsonObject.put("dbid", cfg_grouplist.get(0).getDbid());
				    GroupJsonObject.put("name", cfg_grouplist.get(0).getName()); 
				    GroupJsonObject.put("state", cfg_grouplist.get(0).getState());
				    
				    GroupJsonArray.put(GroupJsonObject);
		        }
		        jsonObject.put("person_group", PersonGroupArray);
		        jsonObject.put("group", GroupJsonArray);
	        	}
		        
	        }
			
	      
	        for (int i = 0; i < cfg_personlist.size(); i++) {
	        	JSONObject PersonJsonObject = new JSONObject();
	        	
	        	PersonJsonObject.put("dn", cfg_personlist.get(i).getDn());
	        	PersonJsonObject.put("dbid", cfg_personlist.get(i).getDbid());
	        	//PersonJsonObject.put("createdatetime", cfg_personlist.get(i).getCreatedatetime());
	        	PersonJsonObject.put("account",    cfg_personlist.get(i).getAccount());
	        	//PersonJsonObject.put("password", cfg_personlist.get(i).getPassword());
	        	PersonJsonObject.put("first_name", cfg_personlist.get(i).getFirst_name());
	        	PersonJsonObject.put("last_name",  cfg_personlist.get(i).getLast_name());
	        	PersonJsonObject.put("user_name",  cfg_personlist.get(i).getUser_name());
	        	PersonJsonObject.put("employee_id", cfg_personlist.get(i).getEmployee_id());
	        	PersonJsonObject.put("emailaddress", cfg_personlist.get(i).getEmailaddress());
	        	PersonJsonObject.put("max_count", cfg_personlist.get(i).getMax_count());
	     
	        	
	        	cfg_person.setDbid(cfg_personlist.get(i).getDbid());
	        	
		        List<CFG_person> cfg_personlist2 = maintainService.query_Person_DBID(cfg_person);
		        CFG_group_person cfg_group_person = new CFG_group_person();
	        	cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
	        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);
	        	
	        	JSONArray PersonGroupArray = new JSONArray();
	        	JSONArray GroupJsonArray = new JSONArray();
	        	String groupname ="";
	        	String groupdbid ="";
	        			
	        	  for (int ii = 0; ii < cfg_person_grouplist.size(); ii++) {
			        	JSONObject PersonGroupJsonObject = new JSONObject();
			        	PersonGroupJsonObject.put("person_dbid", cfg_person_grouplist.get(ii).getPerson_dbid());
			        	PersonGroupJsonObject.put("group_dbid", cfg_person_grouplist.get(ii).getGroup_dbid()); 
					    groupdbid+=cfg_person_grouplist.get(ii).getPerson_dbid()+",";

			        	PersonGroupArray.put(PersonGroupJsonObject);
			        	
			        	//撈取cfg_group欄位
					    CFG_group cfg_group = new CFG_group();
					    cfg_group.setDbid(cfg_person_grouplist.get(ii).getGroup_dbid());
					    List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
					    JSONObject GroupJsonObject = new JSONObject();
					    GroupJsonObject.put("dbid", cfg_grouplist.get(0).getDbid());
					    GroupJsonObject.put("name", cfg_grouplist.get(0).getName()); 
					    GroupJsonObject.put("state", cfg_grouplist.get(0).getState());
					    
					    groupname+=cfg_grouplist.get(0).getName()+",";

			        }		

	        	
	        	
		        	PersonJsonObject.put("groupname", groupname.substring(0, groupname.length()-1));
		        	PersonJsonObject.put("groupdbid", groupdbid.substring(0, groupdbid.length()-1));

	        	
	        	
	        	if(cfg_personlist.get(i).getState()==0){
	        		PersonJsonObject.put("state", "");
	        		
        		}else if(cfg_personlist.get(i).getState()==1){
	        		PersonJsonObject.put("state", "");

        		}else if(cfg_personlist.get(i).getState()==2){
	        		PersonJsonObject.put("state", "鎖定");

        		}
	        	
	        	
	        	
	        	PersonJsonArray.put(PersonJsonObject);
	        }		
	        jsonObject.put("person", PersonJsonArray);
	        	
	
		
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

}