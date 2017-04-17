package com.infotrends.servlet;

import java.io.BufferedReader;
import java.io.IOException;



import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.infotrends.bean.Activitydata;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.ContactData;
import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.FourTableBeansList_data;
import com.infotrends.bean.Interaction;
import com.infotrends.bean.InteractionList_data;
import com.infotrends.bean.Rpt_Activitylog;
import com.infotrends.dao.FourTableBeansDao;
import com.infotrends.service.MaintainService;
import com.infotrends.util.Util;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Query")
public class Query_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
			
			@FormParam("startdate") String startdate,
			@FormParam("enddate") String enddate,
			@FormParam("agentid") String agentid,
			@FormParam("contactid") String contactid,
			@FormParam("inputcontactdata") String inputcontactdata

			) throws IOException {
		
		JsonObject jsonObject = new JsonObject();
		List<Interaction> interactionlist = null;
//		JSONObject jsonObject = new JSONObject();
		String jsonfourtablebeanslist_data = "";
		Interaction interaction = new Interaction();
		Rpt_Activitylog rpt_activitylog = new Rpt_Activitylog();
		Activitydata activitydata = new Activitydata();
		CFG_person cfg_person = new CFG_person();
		ContactData contactdata = new ContactData();

		List<String> contactidlist = new ArrayList<String>();
		MaintainService maintainservice = new MaintainService();
		
		FourTableBeans fourtablebeans = new FourTableBeans();
		
    	FourTableBeansList_data fourtablebeanslist_data = new FourTableBeansList_data();

		fourtablebeans.setStartdate(startdate);
		fourtablebeans.setEnddate(enddate);
//inputcontactdata 有輸入
			
			if(inputcontactdata!=null && !inputcontactdata.isEmpty()){
				System.out.println("inputcontactdata if");
				//select全部contactdataID
				List<String> allcontactdata = new ArrayList<String>();
				List<ContactData> contactdatalist = maintainservice.Query_All_Contactdata(contactdata);
				
					for(int i = 0;i<contactdatalist.size();i++){
						allcontactdata.add(contactdatalist.get(i).getContactid().trim());
					}
			//帶出contactdataID的資訊 
					for(int a = 0; a<allcontactdata.size(); a++){
						JSONObject contactdataObject = new JSONObject();
						String Contactkey = allcontactdata.get(a).trim();

						contactdata.setContactid(Contactkey);
						Map<String, String> contactidmap = maintainservice.Query_Contactdata(Contactkey);
						//System.out.println(contactidmap);
			//inputcontactdata的資訊與contactdataID的資訊做比對
						JSONObject datajsonObj = new JSONObject(contactidmap);
						JSONObject inputjsonObj = new JSONObject(inputcontactdata);
						String[] inputjsonObjkeys = JSONObject.getNames(inputjsonObj);
						String[] datajsonObjkeys = JSONObject.getNames(inputjsonObj);

    		    			//System.out.println("inputjsonObj: "+inputjsonObj);   
							int count=0;
							//System.out.println("=================");
							for(int i = 0; i<inputjsonObjkeys.length;i++){
									if(inputjsonObj.has(inputjsonObjkeys[i])&&datajsonObj.has(datajsonObjkeys[i])){
										if(!inputjsonObj.get(inputjsonObjkeys[i]).toString().trim().equals("")&&
											inputjsonObj.get(inputjsonObjkeys[i]).toString().trim()!=null){
											
											int	x = datajsonObj.get(inputjsonObjkeys[i]).toString().trim().indexOf(inputjsonObj.get(inputjsonObjkeys[i]).toString().trim());
											System.out.println("input: "+inputjsonObj.get(inputjsonObjkeys[i]).toString().trim());
											System.out.println("data: "+datajsonObj.get(inputjsonObjkeys[i]).toString().trim());

											System.out.println("OUT: "+x);
												if(x>=0){
													count++;
												}
										}
									}
							} 
							if(count>0){

								contactidlist.add(Contactkey);
							}
					}
		}
//判斷agentid條件有沒有下
		if(agentid!=null&& !agentid.isEmpty()){
			System.out.println("agentid if");
			fourtablebeans.setAgentid(agentid);
		}
//判斷contactid條件有沒有下
		if(contactid!=null&& !contactid.isEmpty()){
			System.out.println("contactid if");
			fourtablebeans.setContactid(contactid);
		}
		int oo = 0;
		if(contactidlist.size()>0){
			List<FourTableBeans> FourTableBeansALLList= new ArrayList<FourTableBeans>();

			List<FourTableBeans> FourTableBeansList= new ArrayList<FourTableBeans>();

			System.out.println("======= IF =======");
			System.out.println("======= IF ======="+contactidlist);

			for(int i = 0; i<contactidlist.size();i++){
				fourtablebeans.setContactid(contactidlist.get(i));
		
				FourTableBeansList = maintainservice.Selcet_FourTableBeans(fourtablebeans);
				
				/** 更新src值 **/
				for (FourTableBeans fourTableBeans: FourTableBeansList){
					if("2".equals(fourTableBeans.getSrc())){
						fourTableBeans.setSrc("chat");
					}
				}
				FourTableBeansALLList.addAll(FourTableBeansList);	
					
				System.out.println("FourTableBeansList.size(): " + FourTableBeansList.size());

			}
			fourtablebeanslist_data.setData(FourTableBeansALLList);
			Gson gson = new Gson();
			jsonfourtablebeanslist_data = gson.toJson(fourtablebeanslist_data, FourTableBeansList_data.class);
			
			System.out.println("jsonfourtablebeanslist_data: " + jsonfourtablebeanslist_data);	
			
		}else if(inputcontactdata!=null && !inputcontactdata.isEmpty() && contactidlist.size()==0){
			
			List<FourTableBeans> FourTableBeansList =new ArrayList <FourTableBeans>();

	    	fourtablebeanslist_data.setData(FourTableBeansList);
			Gson gson = new Gson();
			jsonfourtablebeanslist_data = gson.toJson(fourtablebeanslist_data, FourTableBeansList_data.class);
			System.out.println("jsonfourtablebeanslist_data: " + jsonfourtablebeanslist_data);
			
			System.out.println("======= inputcontactdata有輸入 但是沒有匹配成功 =======");
		}else{
			System.out.println("======= else =======");


			
			List<FourTableBeans> FourTableBeansList = maintainservice.Selcet_FourTableBeans(fourtablebeans);
			/** 更新src值 **/
			for (FourTableBeans fourTableBeans: FourTableBeansList){
				if("2".equals(fourTableBeans.getSrc())){
					fourTableBeans.setSrc("chat");
				}
			}
			System.out.println("FourTableBeansList.size(): " + FourTableBeansList.size());

//GSON
	    	fourtablebeanslist_data.setData(FourTableBeansList);
			Gson gson = new Gson();

			
			jsonfourtablebeanslist_data = gson.toJson(fourtablebeanslist_data, FourTableBeansList_data.class);
			System.out.println("jsonfourtablebeanslist_data: " + jsonfourtablebeanslist_data);

		}

		return Response.status(200).entity(jsonfourtablebeanslist_data)
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
