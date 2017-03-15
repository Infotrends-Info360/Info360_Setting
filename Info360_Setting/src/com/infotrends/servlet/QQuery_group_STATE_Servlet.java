package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.*;
@Path("/Query_Group_STATE")
public class QQuery_group_STATE_Servlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("state")
								int state) throws IOException {

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
			
        	 List<String> ALLperson = new ArrayList<String>();
        	 List<String> ALLfunction = new ArrayList<String>();
//        	 String  ALLperson = "";
//	         String  ALLfunction = "";


			 
			  //全部人員
		        List<CFG_person> cfg_personlist = maintainService.Query_PersonInfo_STATE(cfg_person);
		        for (int i = 0; i < cfg_personlist.size(); i++) {
		        	JSONObject PersonJsonObject = new JSONObject();
		        	PersonJsonObject.accumulate("dbid", cfg_personlist.get(i).getDbid());
		        	PersonJsonObject.accumulate("user_name", cfg_personlist.get(i).getUser_name());
		        	
		        	ALLperson.add(cfg_personlist.get(i).getUser_name().trim());
		        	
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

		        	ALLfunction.add(cfg_functionlist.get(ii).getName().trim());

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
				 List<String> groupperson2 = new ArrayList<String>();
				 List<String> groupfunction2 = new ArrayList<String>();
				 
				 List<String> notperson = new ArrayList<String>();


	        	
	        	
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
//					    GroupJsonObject.accumulate("have_person_dbid", cfg_group_personlist.get(a).getPerson_dbid());
					    
					    persondbid.add(String.valueOf(cfg_group_personlist.get(a).getPerson_dbid()));
				 }    
				 	//person_dbid轉成user_name	 
				 		for(int b=0;b<persondbid.size();b++){					 
				 					if(persondbid.get(b)!=null && persondbid.get(b)!="" && persondbid.get(b).length()>0){
				 						cfg_person.setDbid(Integer.valueOf(persondbid.get(b)));
				 						List<CFG_person> cfg_personlist2 = maintainService.query_Person_DBID(cfg_person);
				 						GroupJsonObject.accumulate("have_person_username", cfg_personlist2.get(0).getUser_name());
				 						groupperson2.add(cfg_personlist2.get(0).getUser_name().trim());
				 						
				 					}
				 		}
				 		
				 		System.out.println("部門人員  :"+groupperson2);
				 		System.out.println("全部人員  :"+ALLperson);
				 		System.out.println("開始比人");
				 		
				 		
				 		for(int n =0;n<ALLperson.size();n++){
				 			int a=1;
			 				int b=0;
			 				int c=1;
			 			
			 			if(groupperson2.size()>0){
			 				
				 			for(int m =0;m<groupperson2.size();m++){
				 				
				 				if(ALLperson.get(n).equals(groupperson2.get(m))){
				 					c=a*c;
					 			}else{
					 				c=a*b;
					 			}
				 			}
				 			
				 			if(c==0){
				 				System.out.println("待加入部門人員 :  "+ALLperson.get(n));
				 				notperson.add(ALLperson.get(n));

				 			}else{
				 				System.out.println("部門人員 :  "+ALLperson.get(n));
				 			}
				 			
			 			}else if(groupperson2.size()<=0){	
			 				if(c==1){
				 				System.out.println("待加入部門人員 :  "+ALLperson.get(n));
				 				notperson.add(ALLperson.get(n));

				 			}else{
				 				System.out.println("部門人員 :  "+ALLperson.get(n));
				 			}
			 			}
				 			
				 			
				 		}
				 	
	 						GroupJsonObject.accumulate("not_in_person", notperson);
				 	
				 		System.out.println("結束比人");
				 		System.out.println("                             ");

				 	        
				 	        
				 		

				 		
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
		 						GroupJsonObject.accumulate("have_function", cfg_functionlist2.get(0).getName());
		 						groupfunction2.add(cfg_functionlist2.get(0).getName().trim());
							}
							
//							System.out.println("ALLfunction:  "+ALLfunction);
//							System.out.println("Have function:  "+groupfunction2);
//							for(int j =0;j<ALLfunction.size();j++){
//					 			int a=1;
//				 				int b=0;
//				 				int c=1;
//				 			
//				 			if(groupfunction2.size()>0){
//				 				
//					 			for(int k =0;k<groupfunction2.size();k++){
//					 				
//					 				if(ALLfunction.get(j).equals(groupfunction2.get(k))){
//					 					c=a*c;
//						 			}else{
//						 				c=a*b;
//						 			}
//					 			}
//					 			
//					 			if(c==0){
//					 				System.out.println("待加入部門方法 :  "+ALLfunction.get(j));
//					 			}else{
//					 				System.out.println("部門方法 :  "+ALLfunction.get(j));
//					 			}
//					 			
//				 			}else if(groupfunction2.size()<=0){	
//				 				if(c==1){
//					 				System.out.println("待加入部門方法 :  "+ALLfunction.get(j));
//					 			}else{
//					 				System.out.println("部門方法 :  "+ALLfunction.get(j));
//					 			}
//				 			}
//					 			
//					 			
//					 		}
//							
//							
//							System.out.println("  ");
//							System.out.println("-------------------------------------------------------");

							
							
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