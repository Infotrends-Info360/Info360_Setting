package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.infotrends.bean.CFG_role_member;
import com.infotrends.bean.FourTableBeans;
import com.infotrends.dao.FourTableBeansDao;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/Query_Group_STATE_old")
public class QQuery_group_STATE_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("state") int state
								
			) throws IOException {
	
		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		CFG_person cfg_person =new CFG_person();
		CFG_group_person cfg_group_person = new CFG_group_person();
		CFG_role_member cfg_role_member = new CFG_role_member();
		CFG_permission cfg_permission = new CFG_permission();
		CFG_function cfg_function = new CFG_function();
		
        JSONArray GroupJsonArray = new JSONArray();
        JSONArray PersonJsonArray = new JSONArray();
        JSONArray FunctionJsonArray = new JSONArray();


		
		cfg_group.setState(state);
		jsonObject.put("status", Variable.POST_STATUS);
		
		try{
			 MaintainService maintainService = new MaintainService();
			
//        	 List<String> ALLperson = new ArrayList<String>();
//        	 List<String> ALLfunction = new ArrayList<String>();
        	 String  ALLperson = "";
	         String  ALLfunction = "";

	        	JSONObject AllpersonJsonObject = new JSONObject();
	        	JSONObject AllfunctionJsonObject = new JSONObject();

			 
			  //全部人員
		        List<CFG_person> cfg_personlist = maintainService.Query_PersonInfo_STATE(cfg_person);
		        for (int i = 0; i < cfg_personlist.size(); i++) {
		        	JSONObject PersonJsonObject = new JSONObject();
		        	PersonJsonObject.accumulate("dbid", cfg_personlist.get(i).getDbid());
		        	PersonJsonObject.accumulate("user_name", cfg_personlist.get(i).getUser_name());
		        	
		        	AllpersonJsonObject.put(String.valueOf(cfg_personlist.get(i).getDbid()), cfg_personlist.get(i).getUser_name());

		        	
//		        	ALLperson.add(cfg_personlist.get(i).getUser_name().trim());
		        	
//		        	ALLperson+= cfg_personlist.get(i).getUser_name()+",";

		        	PersonJsonArray.put(PersonJsonObject);
		        }		
		        jsonObject.put("ALLperson", PersonJsonArray);
		        
		      //全部方法
				List<CFG_function> cfg_functionlist = maintainService.select_function_state(cfg_function);
				for(int ii = 0 ; ii<cfg_functionlist.size();ii++){
		        	JSONObject FunctionJsonObject = new JSONObject();
		        	FunctionJsonObject.accumulate("dbid", cfg_functionlist.get(ii).getDbid());
		        	FunctionJsonObject.accumulate("Function_name", cfg_functionlist.get(ii).getName());
		        	
		        	AllfunctionJsonObject.put(String.valueOf(cfg_functionlist.get(ii).getDbid()), cfg_functionlist.get(ii).getName());


//		        	ALLfunction.add(cfg_functionlist.get(ii).getName().trim());

//		        	ALLfunction+= cfg_functionlist.get(ii).getName()+",";
		        	
		        	FunctionJsonArray.put(FunctionJsonObject);
				}
		        jsonObject.put("ALLfunction", FunctionJsonArray);
			 
			 
			 
			 
			 
		//全部部門(State==0)
			 List<CFG_group> cfg_grouplist = maintainService.Query_Group_state(cfg_group);
	        for (int i = 0; i < cfg_grouplist.size(); i++) {

	        	
	        	 List<String> groupperson = new ArrayList<String>();
				 List<String> persondbid = new ArrayList<String>();
				 List<String> grouppermission = new ArrayList<String>();
				 
				 
//				 List<String> groupperson2 = new ArrayList<String>();
//				 List<String> groupfunction2 = new ArrayList<String>();
				 
				 List<String> notperson = new ArrayList<String>();

				 String groupperson2 = "";
				 String groupfunction2 = "";
				 String groupfunction_dbid = "";

				 String persondbid2 = "";
	        	
	        	JSONObject GroupJsonObject = new JSONObject();
	        	GroupJsonObject.accumulate("dbid", cfg_grouplist.get(i).getDbid());
			    GroupJsonObject.accumulate("name", cfg_grouplist.get(i).getName()); 
			    GroupJsonObject.accumulate("state", cfg_grouplist.get(i).getState());
	       //裝group_dbid
			    groupperson.add(String.valueOf(cfg_grouplist.get(i).getDbid()));
			    
			//找部門內全員的DBID    
			    cfg_group_person.setGroup_dbid(cfg_grouplist.get(i).getDbid());
				 List<CFG_group_person> cfg_group_personlist = maintainService.query_Group_Person(cfg_group_person);
				 for(int a=0;a<cfg_group_personlist.size();a++){
//		        	JSONObject cfg_group_personJsonObject = new JSONObject();
//		        	cfg_group_personJsonObject.accumulate("group_dbid", cfg_group_personlist.get(a).getGroup_dbid());
//		        	cfg_group_personJsonObject.accumulate("person_dbid", cfg_group_personlist.get(a).getPerson_dbid());
					 

					 
					    persondbid.add(String.valueOf(cfg_group_personlist.get(a).getPerson_dbid()));
				 }    
				 	//person_dbid轉成user_name	 
				 		for(int b=0;b<persondbid.size();b++){					 
				 					if(persondbid.get(b)!=null && persondbid.get(b)!="" && persondbid.get(b).length()>0){
				 						cfg_person.setDbid(Integer.valueOf(persondbid.get(b)));
				 						List<CFG_person> cfg_personlist2 = maintainService.query_Person_DBID(cfg_person);
				 						
				 						groupperson2+=cfg_personlist2.get(0).getUser_name().trim()+",";
									    persondbid2+=cfg_personlist2.get(0).getDbid()+",";
									    

									    
				 						
				 					}
				 		}
				 		
				 		  String notgroupdbid = "";
			        	  String notgroupname = "";
			        	  Set<String> a = AllpersonJsonObject.keySet();
						    for (String key :  a) {
					    		  if(persondbid2.indexOf(key)<0){
					    			  notgroupdbid+=key+",";
					    			  notgroupname+=AllpersonJsonObject.getString(key)+",";
					    			  //personGroup.put("notgroupdbid", );
//					    			  personGroup.put("notgroupname", Group2JsonObject.getString(key));
					    		  }else{}
					    		  
					    	    }
						   
					GroupJsonObject.accumulate("have_person_dbid",persondbid2);

				 	GroupJsonObject.accumulate("have_person_username",groupperson2);
				 	
				 	GroupJsonObject.put("not_have_person_dbid", notgroupdbid);
				 	GroupJsonObject.put("not_have_person_username", notgroupname);
				 	
			 		
//				 	
				 		
			//找部門關聯的role_member		    
				cfg_role_member.setGroup_dbid(cfg_grouplist.get(i).getDbid());
					List<CFG_role_member> cfg_role_memberlist = maintainService.Select_Rolemember_Groupdbid(cfg_role_member);
//					GroupJsonObject.accumulate("have_role_member", cfg_role_memberlist.get(0).getRole_dbid());
						 
						 
						 //找部門關聯的permission		    
						 cfg_permission.setRole_dbid(cfg_role_memberlist.get(0).getRole_dbid());
							List<CFG_permission> cfg_permissionlist = maintainService.Select_permission_roledbid(cfg_permission);
							for(int c =0 ; c<cfg_permissionlist.size();c++){
//		 						GroupJsonObject.accumulate("have_permission", cfg_permissionlist.get(c).getFunction_dbid().trim());
		 						grouppermission.add(cfg_permissionlist.get(c).getFunction_dbid().trim());
							}

						//找部門關聯的function	
							for(int d=0 ; d<grouppermission.size();d++){
								cfg_function.setDbid(Integer.valueOf(grouppermission.get(d)));
								List<CFG_function> cfg_functionlist2 = maintainService.select_function_dbid(cfg_function);
								
								groupfunction2+=cfg_functionlist2.get(0).getName().trim()+",";
								groupfunction_dbid+=cfg_functionlist2.get(0).getDbid()+",";
//		 						groupfunction2.add(cfg_functionlist2.get(0).getName().trim());
							}
							
							
							  String notgroupdbid2 = "";
				        	  String notgroupname2 = "";
				        	  Set<String> b = AllfunctionJsonObject.keySet();
							    for (String key :  b) {
						    		  if(groupfunction_dbid.indexOf(key)<0){
						    			  notgroupdbid2+=key+",";
						    			  notgroupname2+=AllfunctionJsonObject.getString(key)+",";
						    			  //personGroup.put("notgroupdbid", );
//						    			  personGroup.put("notgroupname", Group2JsonObject.getString(key));
						    		  }else{}
						    		  
						    	    }
							    
							    
							
	 						GroupJsonObject.accumulate("have_function",groupfunction2);
	 						GroupJsonObject.accumulate("have_function_dbid",groupfunction_dbid);
	 						
	 						GroupJsonObject.put("not_function", notgroupname2);
	 						GroupJsonObject.put("not_function_dbid", notgroupdbid2);
	 				

							
							
				 GroupJsonArray.put(GroupJsonObject);
	        }		
	        jsonObject.put("group", GroupJsonArray);
	        
	        


	        
	        
	        
	       
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