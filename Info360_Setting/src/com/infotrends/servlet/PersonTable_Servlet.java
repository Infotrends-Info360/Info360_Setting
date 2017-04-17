package com.infotrends.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.infotrends.bean.CFG_group;
import com.infotrends.bean.PersonTableBeans;
import com.infotrends.bean.PersonTableBeansList_data;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Query_Person_STATE")
public class PersonTable_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
			
			@FormParam("state") String state

			) throws IOException {
		
		String jsonpersontablebeanslist_data = "";

		MaintainService maintainservice = new MaintainService();
		
		PersonTableBeans persontablebeans = new PersonTableBeans();
		PersonTableBeansList_data persontablebeanslist_data = new PersonTableBeansList_data();
		CFG_group cfg_group = new CFG_group();
		
		String AllNohavedbid="";
		String AllNothavename="";

		List<String> allkeys = new ArrayList<String>();
		HashMap<String,String> AllGroupMap = new HashMap<String,String>(); 
		 List<CFG_group> cfg_grouplist = maintainservice.Query_Group_state(cfg_group);
		 for(int i=0 ; i<cfg_grouplist.size();i++){
			 AllGroupMap.put(String.valueOf(cfg_grouplist.get(i).getDbid()), cfg_grouplist.get(i).getName());
			 allkeys.add(String.valueOf(cfg_grouplist.get(i).getDbid()));
			 AllNohavedbid +=cfg_grouplist.get(i).getDbid() +",";
			 AllNothavename+=cfg_grouplist.get(i).getName()+",";
		 }

		persontablebeans.setState(state);


			List<PersonTableBeans> PersonTableBeansList = maintainservice.Query_PersonTableBeans_STATE(persontablebeans);
//			List<PersonTableBeans> PersonTableBeansListModified = new ArrayList<>();
			
			
			
			for (PersonTableBeans persontablebeans2: PersonTableBeansList){
				HashMap<String,String> HAVEGroupMap = new HashMap<String,String>(); 
				HashMap<String,String> NOThaveGroupMap = new HashMap<String,String>();
				String notdbid="";
				String notnam="";

				if(persontablebeans2.getGroupdbid()!=null && !persontablebeans2.getGroupdbid().isEmpty()){
					
					String Groupdbid [] =persontablebeans2.getGroupdbid().split(",");
					String Groupname []=persontablebeans2.getGroupname().split(",");
					
					  for(int i =0;i<Groupdbid.length;i++){
						HAVEGroupMap.put(Groupdbid[i], Groupname[i]);
					  }
							if(HAVEGroupMap.size()==AllGroupMap.size()){
								persontablebeans2.setNotgroupdbid("");
								persontablebeans2.setNotgroupname("");
							}else{
									for(int i =0;i<allkeys.size();i++){
										if(AllGroupMap.get(allkeys.get(i)).equals(HAVEGroupMap.get(allkeys.get(i)))){
										}else{
											NOThaveGroupMap.put(allkeys.get(i), AllGroupMap.get(allkeys.get(i)));
											notdbid += allkeys.get(i)+",";
											notnam += AllGroupMap.get(allkeys.get(i))+",";
										}
									}
//							System.out.println(notdbid.substring(0, notdbid.length()-1));
//							System.out.println(notnam.substring(0, notnam.length()-1));
						persontablebeans2.setNotgroupdbid(notdbid.substring(0, notdbid.length()-1));
						persontablebeans2.setNotgroupname(notnam.substring(0, notnam.length()-1));
							}

				}else{
//					System.out.println(AllNohavedbid.substring(0, AllNohavedbid.length()-1));
//					System.out.println(AllNothavename.substring(0, AllNohavedbid.length()-1));
					persontablebeans2.setNotgroupdbid(AllNohavedbid.substring(0, AllNohavedbid.length()-1));
					persontablebeans2.setNotgroupname(AllNothavename.substring(0, AllNothavename.length()-1));
				}
				if("0".equals(persontablebeans2.getState())){
					persontablebeans2.setState("");
				}else if("1".equals(persontablebeans2.getState())){
					persontablebeans2.setState("鎖定");
				}
				
			}
			persontablebeanslist_data.setPerson(PersonTableBeansList);
			Gson gson = new Gson();

			jsonpersontablebeanslist_data = gson.toJson(persontablebeanslist_data, PersonTableBeansList_data.class);
//			System.out.println("jsonPTlist_data: " + jsonpersontablebeanslist_data);

		return Response.status(200).entity(jsonpersontablebeanslist_data)
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	
}
