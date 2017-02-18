package com.infotrends.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;


@Path("/Delete_Permission_Info")
public class Delete_Permission_InfoServlet {
	/**
	 * 使用POST方法
	 * 依據帳號與密碼皆吻合刪除個人資訊
	 * @param ACCOUNT
	 * @param PASSWORD
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(
    		@FormParam("dbid") int dbid
    			
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_permission cfg_permission = new CFG_permission();
		jsonObject.put("Status", Variable.POST_STATUS);
	
		cfg_permission.setDbid(dbid);
		
		try{
			MaintainService maintainService = new MaintainService();
			int cfg_permission_list = maintainService.Delete_Permission_Info(cfg_permission);
			
			jsonObject.put("delete_permissioncount", cfg_permission_list);
			
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
