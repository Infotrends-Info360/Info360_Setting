package com.infotrends.servlet;

import java.io.IOException;



import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.infotrends.bean.Activitydata;
import com.infotrends.bean.Activitygroups;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.service.MaintainService;


/**
 * RESTful Interaction
 * @author Lin
 */

@Path("/Query_titlegroup_ActivityData")
public class Query_titlegroup_ActivityData_Servlet {
	

	@POST
	@Produces("application/json")
	public Response PostFromPath(
			@FormParam("titlegroup") int titlegroup
			
			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		Activitydata activitydata = new Activitydata();
		
		activitydata.setTitlegroup(titlegroup);;
	
		MaintainService maintainservice = new MaintainService();	
		
    			JSONArray ActivitydataJsonArray = new JSONArray();

        	  	if(titlegroup!=0){	
    	  		List<Activitydata> activitydatalist = maintainservice.TITLEGROUP_activitydata(activitydata);
        	  	for(int g = 0; g < activitydatalist.size(); g++){
        	  		
        	  		JSONObject activitydataObject = new JSONObject();
        	
        			activitydataObject.put("dbid", activitydatalist.get(g).getDbid());
        			activitydataObject.put("activitygroupsid", activitydatalist.get(g).getActivitygroupsid());
        			activitydataObject.put("codename", activitydatalist.get(g).getCodename());
        			activitydataObject.put("color", activitydatalist.get(g).getColor());
        			activitydataObject.put("deleteflag", activitydatalist.get(g).getDeleteflag());
        			activitydataObject.put("titlegroup", activitydatalist.get(g).getTitlegroup());
        			activitydataObject.put("titleflag", activitydatalist.get(g).getTitleflag());
        			activitydataObject.put("sort", activitydatalist.get(g).getSort());
        			
        			int a = Integer.valueOf(activitydatalist.get(g).getDeleteflag().trim());
        			if(a==0){
        				if(activitydatalist.get(g).getCreatedatetime()!=null&&activitydatalist.get(g).getCreatedatetime()!=""){
                			activitydataObject.put("createdatetime", activitydatalist.get(g).getCreatedatetime());
                			ActivitydataJsonArray.put(activitydataObject);

        				}else{
                			activitydataObject.put("createdatetime", "");
                			ActivitydataJsonArray.put(activitydataObject);
        				}
        			}
        	  	}

    		}
        		
        		jsonObject.put("titlegroup", ActivitydataJsonArray);
    		
        		

		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}
	
}
