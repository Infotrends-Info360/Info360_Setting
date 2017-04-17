package com.infotrends.servlet;

import java.io.BufferedReader;
import java.io.IOException;



import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.bean.ContactData;
import com.infotrends.service.MaintainService;
import com.infotrends.util.Util;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Query_contactdata")
public class QueryContactData_Servlet {
	
	@POST
	@Produces("application/json")
	public Response PostFromPath(
		
			@FormParam("contactid") String Contactid,
			@FormParam("inputcontactdata") String inputcontactdata

			) throws IOException {
		
		System.out.println("Contactid: " + Contactid);
		System.out.println("inputcontactdata: " + inputcontactdata);
		
		JSONObject jsonObject = new JSONObject();
		
		ContactData contactdata = new ContactData();
		MaintainService maintainservice = new MaintainService();		
		JSONArray contactdataArray = new JSONArray();
		
		
		//select全部contactdataID
		List<String> allcontactdata = new ArrayList<String>();
		List<ContactData> contactdatalist = maintainservice.Query_All_Contactdata(contactdata);
			for(int i = 0;i<contactdatalist.size();i++){
				allcontactdata.add(contactdatalist.get(i).getContactid().trim());
			}
			
				//帶出全部contactdataID的資訊
				for(int a = 0; a<allcontactdata.size(); a++){
					JSONObject contactdataObject = new JSONObject();
					String Contactkey = allcontactdata.get(a).trim();
    				System.out.println("Contactkey:  "+Contactkey);

	    			contactdata.setContactid(Contactkey);
	    			Map<String, String> contactidmap = maintainservice.Query_Contactdata(Contactkey);
	    			System.out.println(contactidmap);
	    			
//	    			contactdataObject.put("BasicINF", contactidmap);
//	    			contactdataArray.put(contactdataObject);
	    			
	    		    JSONObject datajsonObj = new JSONObject(contactidmap);
	    		    JSONObject inputjsonObj = new JSONObject(inputcontactdata);
	    		    String[] inputjsonObjkeys = JSONObject.getNames(inputjsonObj);
	    		    String[] datajsonObjkeys = JSONObject.getNames(inputjsonObj);

	    		    System.out.println("inputjsonObj: "+inputjsonObj);
//	    		    System.out.println("datajsonObj: "+datajsonObj);
	    		    
	    		    int count=0;
	    		    for(int i = 0; i<inputjsonObjkeys.length;i++){
	    		    		if(inputjsonObj.has(inputjsonObjkeys[i])&&datajsonObj.has(datajsonObjkeys[i])){
//	    		    			System.out.println(inputjsonObj.get(inputjsonObjkeys[i]));
//	    		    			System.out.println(datajsonObj.get(datajsonObjkeys[i]));

	    		    			if(inputjsonObj.get(inputjsonObjkeys[i]).equals(datajsonObj.get(inputjsonObjkeys[i]))){
	    		    				count++;
	    		    			}
		    		    	
	    		    		}
	    		    } 
	    		    
	    		    
	    		    System.out.println("count: "+count);
	    		    System.out.println("inputjsonObjkeys: "+inputjsonObjkeys.length);

	    		    if(count==inputjsonObjkeys.length){
	    		  	  contactdataObject.put("contactid", Contactkey);
				  	  contactdataArray.put(contactdataObject);
	    		  	    jsonObject.put("contactid", contactdataArray);
	    		    }

				}



				System.out.println("jsonObject.toString(): " + jsonObject.toString());
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	
}