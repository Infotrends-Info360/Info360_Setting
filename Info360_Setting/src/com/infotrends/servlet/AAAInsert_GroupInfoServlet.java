package com.infotrends.servlet;

/**
 * @author Lin
 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;

@Path("/about_Insert_GroupInfo")
public class AAAInsert_GroupInfoServlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("name") String name,
			@FormParam("state") int state,
			@FormParam("person_dbid") String person_dbid,
			@FormParam("function_dbid") String function_dbid 
			
		
			) throws IOException {
		
		name=name.trim();
	
		
		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		CFG_role cfg_role = new CFG_role();
		CFG_role_member cfg_role_member = new CFG_role_member();
		CFG_function cfg_function =new CFG_function();
		CFG_permission cfg_permission =new CFG_permission();
		CFG_group_person cfg_group_person = new CFG_group_person();
		CFG_person cfg_person = new CFG_person();

		
		List<Integer> function_dbidLIST = new ArrayList<Integer>();
		List<Integer> person_dbidLIST = new ArrayList<Integer>();


		JSONArray FunctionJsonArray = new JSONArray();
		JSONArray PersonionJsonArray = new JSONArray();
		
		cfg_group.setName(name);
		cfg_group.setState(state);
		
		try{
			MaintainService maintainService = new MaintainService();
			
			String groupname ="" ;

//		撈所有部門名稱
			 List<CFG_group> cfg_grouplist2 = maintainService.Query_Group_state(cfg_group);

			    for (int i = 0; i < cfg_grouplist2.size(); i++) {
			      	JSONObject Group1JsonObject = new JSONObject();
				    Group1JsonObject.accumulate("name", cfg_grouplist2.get(i).getName()); 
				    groupname+=cfg_grouplist2.get(i).getName()+",";
			    }	  
//				   
////				比對輸入的部門名稱
//			    
//			    //如果是新的部門
				    if (groupname.indexOf(name)<0){
//				    	System.out.println("字串找不到 "+name+"");   
////					新增部門名稱
				    			int groupcount = maintainService.insert_GroupInfo(cfg_group);
				    			jsonObject.put("group_insertcount", groupcount);
//				    		
////					新增Role
				    			cfg_role.setDescripion(name+"權限");
				    			cfg_role.setName(name+"權限");
				    				int rolecount = maintainService.Insert_Role_Info(cfg_role);
				    				jsonObject.put("role_count", rolecount);
//				    		
//				   //查詢 新增的group資訊
				    				cfg_group.setName(name);		
				    				List<CFG_group> cfg_grouplist3 = maintainService.query_Group_name(cfg_group);
//
//				//查詢 新增的role資訊
				    				cfg_role.setName(name+"權限");
				    				List<CFG_role> cfg_rolelist = maintainService.Select_role(cfg_role);

////				新增Rolemember
				    				cfg_role_member.setRole_dbid(cfg_rolelist.get(0).getDbid());
				    				cfg_role_member.setGroup_dbid(cfg_grouplist3.get(0).getDbid());
				    				int role_member_count = maintainService.Insert_Role_MemberInfo(cfg_role_member);
				    				jsonObject.put("role_member_count", role_member_count);
//				    		
//				  //查尋sort=0的 方法
//				    		cfg_function.setState(state);
//			    			List<CFG_function> cfg_functionlist = maintainService.select_function_state(cfg_function);
//				        	for(int a=0;a<cfg_functionlist.size();a++){
//					        	JSONObject functionJsonObject = new JSONObject();
//				        		functionJsonObject.put("dbid", cfg_functionlist.get(a).getDbid());
//					        	functionJsonObject.put("name", cfg_functionlist.get(a).getName());
//					        	
//					        	FunctionJsonArray.put(functionJsonObject);
//				        	}
//
//					        jsonObject.put("Function", FunctionJsonArray);
					        
					 //新增Permission
					        
					        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
							Date date = new Date();
							String strDate = sdFormat.format(date);
							
							if(function_dbid.length()>0){
								String [] dd = function_dbid.split(",");
								for(int i=0 ;i<dd.length;i++){
									function_dbidLIST.add(Integer.valueOf(dd[i]));
									
								     cfg_permission.setFunction_dbid(dd[i]);
								
								cfg_permission.setCreatedatetime(strDate);
						        cfg_permission.setRole_dbid(cfg_rolelist.get(0).getDbid());
						   
						        int permission_count  = maintainService.Insert_Permission_Info(cfg_permission);
				    			jsonObject.put("permission_count", permission_count);
								}
							}
						
							
//							cfg_person.setState(state);
//			    			List<CFG_person> cfg_personlist = maintainService.Query_PersonInfo_STATE(cfg_person);
//			    			for(int a=0;a<cfg_personlist.size();a++){
//					        	JSONObject personlistJsonObject = new JSONObject();
//					        	personlistJsonObject.put("dbid", cfg_personlist.get(a).getDbid());
//					        	personlistJsonObject.put("name", cfg_personlist.get(a).getUser_name());
//					        	PersonionJsonArray.put(personlistJsonObject);
//				        	}
//
//					        jsonObject.put("Person", PersonionJsonArray);

							
							
		//新增相關人員	
				    		if(person_dbid.length()>0){
				    			System.out.println("進入人員");
				    			String [] dd = person_dbid.split(",");
								for(int i=0 ;i<dd.length;i++){
									person_dbidLIST.add(Integer.valueOf(dd[i]));
								 		cfg_group_person.setGroup_dbid(cfg_grouplist3.get(0).getDbid());
								 		cfg_group_person.setPerson_dbid(Long.valueOf(dd[i]));
					    			int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
					    			jsonObject.put("group_person_insertcount", grouppersoncount);
								}
				    		}
	
				    }	    
//				    else{
//				    
////				    	 System.out.println("字串裡有 "+name+"。");    
//				    	 	
//				    	 if(person_dbid!=0){
//								List<CFG_group> cfg_grouplist = maintainService.query_Group_name(cfg_group);
//								CFG_group_person cfg_group_person = new CFG_group_person();
//								cfg_group_person.setGroup_dbid(cfg_grouplist.get(0).getDbid());
//								cfg_group_person.setPerson_dbid(person_dbid);
//								int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
//								jsonObject.put("group_person_insertcount", grouppersoncount);
//							}
//	
//				    	 }
				    
				    
//				    int groupcount = maintainService.insert_GroupInfo(cfg_group);
//					jsonObject.put("group_insertcount", groupcount);
//					
//					if(person_dbid!=0){
//						List<CFG_group> cfg_grouplist = maintainService.query_Group_name(cfg_group);
//						CFG_group_person cfg_group_person = new CFG_group_person();
//						cfg_group_person.setGroup_dbid(cfg_grouplist.get(0).getDbid());
//						cfg_group_person.setPerson_dbid(person_dbid);
//						int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
//						jsonObject.put("group_person_insertcount", grouppersoncount);
//					}
				    
		       
			
			
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