package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.GroupTableBeans;
import com.infotrends.bean.GroupTableBeansList_data;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Query_Group_STATE")
public class GroupTable_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
			
			@FormParam("state") String state

			) throws IOException {
		
		String jsongrouptablebeanslist_data = "";

		MaintainService maintainservice = new MaintainService();
		
		GroupTableBeans grouptablebeans = new GroupTableBeans();
		GroupTableBeansList_data grouptablebeanslist_data = new GroupTableBeansList_data();
		
		CFG_person cfg_person = new CFG_person();
		CFG_function cfg_function = new CFG_function();
		
		 String AllNohave_persondbid="";
		 String AllNothave_personusername="";
		 List<String> all_Personkeys = new ArrayList<String>();
		 HashMap<String,String> AllPersonMap = new HashMap<String,String>(); 
//全部Person
		 cfg_person.setState(0);
		 List<CFG_person> cfg_personlist = maintainservice.Query_PersonInfo_STATE(cfg_person);
		 for(int i=0 ; i<cfg_personlist.size();i++){
			 AllPersonMap.put(String.valueOf(cfg_personlist.get(i).getDbid()), cfg_personlist.get(i).getUser_name());
			 all_Personkeys.add(String.valueOf(cfg_personlist.get(i).getDbid()));
			 AllNohave_persondbid +=cfg_personlist.get(i).getDbid() +",";
			 AllNothave_personusername+=cfg_personlist.get(i).getUser_name()+",";
		 }
		 
		 
		    String AllNohave_functiondbid="";
			String AllNothave_functionname="";
			List<String> all_Functionkeys = new ArrayList<String>();
			HashMap<String,String> AllFunctionMap = new HashMap<String,String>();
//全部Function
			cfg_function.setState(0);
			List<CFG_function> FunctionBeansList = maintainservice.ALL_function_state(cfg_function);	
//		 List<CFG_function> cfg_functionlist = maintainservice.select_function_state(cfg_function);
		 for(int i=0 ; i<FunctionBeansList.size();i++){
			 AllFunctionMap.put(String.valueOf(FunctionBeansList.get(i).getDbid()), FunctionBeansList.get(i).getName());
			 all_Functionkeys.add(String.valueOf(FunctionBeansList.get(i).getDbid()));
			 AllNohave_functiondbid +=FunctionBeansList.get(i).getDbid() +",";
			 AllNothave_functionname+=FunctionBeansList.get(i).getName()+",";
		 }
		 
		 

		 grouptablebeans.setState(state);
		 
			List<GroupTableBeans> GroupTableBeansList = maintainservice.Query_GroupTableBeans_STATE(grouptablebeans);

			for (GroupTableBeans grouptablebeans2: GroupTableBeansList){
				HashMap<String,String> HavePersonMap = new HashMap<String,String>(); 
				HashMap<String,String> NOThavePersonMap = new HashMap<String,String>();
				String not_Persondbid="";
				String not_Person_username="";
				
				HashMap<String,String> HaveFunctionMap = new HashMap<String,String>(); 
				HashMap<String,String> NOThaveFunctionMap = new HashMap<String,String>();
				String not_Functiondbid="";
				String not_Functionname="";

				if(grouptablebeans2.getHave_person_dbid()!=null && !grouptablebeans2.getHave_person_dbid().isEmpty()){
					
					String Persondbid [] =grouptablebeans2.getHave_person_dbid().split(",");
					String Personname []=grouptablebeans2.getHave_person_username().split(",");
					
					  		for(int i =0;i<Persondbid.length;i++){
					  			HavePersonMap.put(Persondbid[i], Personname[i]);
					  		}
					  		
					  		if(HavePersonMap.size()==AllPersonMap.size()){
								grouptablebeans2.setNot_have_person_dbid("");
								grouptablebeans2.setNot_have_person_username("");
							}else{
									for(int i =0;i<all_Personkeys.size();i++){
											if(AllPersonMap.get(all_Personkeys.get(i)).equals(HavePersonMap.get(all_Personkeys.get(i)))){
											}else{
											NOThavePersonMap.put(all_Personkeys.get(i), AllPersonMap.get(all_Personkeys.get(i)));
											not_Persondbid += all_Personkeys.get(i)+",";
											not_Person_username += AllPersonMap.get(all_Personkeys.get(i))+",";
											}
									}
								if(not_Persondbid.length()==0){
									grouptablebeans2.setNot_have_person_dbid(not_Persondbid);
									grouptablebeans2.setNot_have_person_username(not_Person_username);
								}else{
									grouptablebeans2.setNot_have_person_dbid(not_Persondbid.substring(0, not_Persondbid.length()-1));
									grouptablebeans2.setNot_have_person_username(not_Person_username.substring(0, not_Person_username.length()-1));
								}
							}
				}else{
					grouptablebeans2.setNot_have_person_dbid(AllNohave_persondbid.substring(0, AllNohave_persondbid.length()-1));
					grouptablebeans2.setNot_have_person_username(AllNothave_personusername.substring(0, AllNothave_personusername.length()-1));
				}
				
				
				if(grouptablebeans2.getHave_function_dbid()!=null && !grouptablebeans2.getHave_function_dbid().isEmpty()){
					
					String Functiondbid [] =grouptablebeans2.getHave_function_dbid().split(",");
					String Functionname []=grouptablebeans2.getHave_function().split(",");
					
					  		for(int i =0;i<Functiondbid.length;i++){
					  			HaveFunctionMap.put(Functiondbid[i], Functionname[i]);
					  		}
					  		if(HaveFunctionMap.size()==AllFunctionMap.size()){
								grouptablebeans2.setNot_function_dbid("");
								grouptablebeans2.setNot_function("");
							}else{
									for(int i =0;i<all_Functionkeys.size();i++){
											if(AllFunctionMap.get(all_Functionkeys.get(i)).equals(HaveFunctionMap.get(all_Functionkeys.get(i)))){
											}else{
											NOThaveFunctionMap.put(all_Functionkeys.get(i), AllFunctionMap.get(all_Functionkeys.get(i)));
											not_Functiondbid += all_Functionkeys.get(i)+",";
											not_Functionname += AllFunctionMap.get(all_Functionkeys.get(i))+",";
											}
									}
								if(not_Functiondbid.length()==0){
										grouptablebeans2.setNot_have_person_dbid(not_Functiondbid);
										grouptablebeans2.setNot_have_person_username(not_Functionname);
									}else{
										grouptablebeans2.setNot_function_dbid(not_Functiondbid.substring(0, not_Functiondbid.length()-1));
										grouptablebeans2.setNot_function(not_Functionname.substring(0, not_Functionname.length()-1));
									}
							}
//
				}else{
					grouptablebeans2.setNot_function_dbid(AllNohave_functiondbid.substring(0, not_Functiondbid.length()-1));
					grouptablebeans2.setNot_function(AllNothave_functionname.substring(0, not_Functionname.length()-1));
				}
				
				

			}
			
//			cfg_person.setState(0);	
//			List<CFG_person> PersonBeansList = maintainservice.Query_PersonInfo_STATE(cfg_person);
//			System.out.println("person: "+PersonBeansList.size());
//			cfg_function.setState(0);
//			List<CFG_function> FunctionBeansList = maintainservice.ALL_function_state(cfg_function);
//			System.out.println(FunctionBeansList.size());
			
			grouptablebeanslist_data.setGroup(GroupTableBeansList);
			grouptablebeanslist_data.setALLperson(cfg_personlist);
			grouptablebeanslist_data.setALLfunction(FunctionBeansList);

			Gson gson = new Gson();

			jsongrouptablebeanslist_data = gson.toJson(grouptablebeanslist_data, GroupTableBeansList_data.class);

			return Response.status(200).entity(jsongrouptablebeanslist_data)
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	
}
