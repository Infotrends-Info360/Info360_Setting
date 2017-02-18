package com.infotrends.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Update_Permission_Info")
public class Update_PermissionInfoServlet {
	/**
	 * 使用POST方法
	 * 依據帳號更新個人資訊
	 * @param ACCOUNT
	 * @param FIRST_NAME
	 * @param LAST_NAME
	 * @param USER_NAME
	 * @param EMAILADDRESS
	 * @param PASSWORD
	 * @param USERNAME
	 * @return
	 * @throws IOException
	 */

	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("dbid") int dbid,
			@FormParam("role_dbid") int role_dbid,
			@FormParam("function_dbid") int function_dbid
			

			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_permission cfg_permission = new CFG_permission();
		jsonObject.put("Status", Variable.POST_STATUS);
		
		cfg_permission.setDbid(dbid);
		//cfg_permission.setFunction_dbid(function_dbid);
		cfg_permission.setRole_dbid(role_dbid);

		
		int updatecount=0;
		try{
			MaintainService maintainService = new MaintainService();
			updatecount = maintainService.Update_Permission_Info(cfg_permission);
			jsonObject.put("updatecount", updatecount);
		
			
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
