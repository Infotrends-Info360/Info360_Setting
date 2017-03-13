package com.infotrends.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Update_PersonInfo")
public class Update_PersonInfoServlet {
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


			@FormParam("account") 		String account,
			@FormParam("first_name") 	String first_name,
			@FormParam("last_name") 	String last_name,
			@FormParam("user_name") 	String user_name,
			@FormParam("emailaddress")  String emailaddress,
			@FormParam("password") 		String password,
			@FormParam("employee_id")   String employee_id,
			@FormParam("state")   		int state,
			@FormParam("dn")   			int dn,
			@FormParam("ch_pass_on_login")String ch_pass_on_login,
			@FormParam("group_dbid") long group_dbid,
			@FormParam("max_count") int max_count,
			@FormParam("pass_error_count") int pass_error_count
			
			//@FormParam("group_dbid") long group_dbid
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", Variable.POST_STATUS);
		
		cfg_person.setAccount(account);
		cfg_person.setFirst_name(first_name);
		cfg_person.setLast_name(last_name);
		cfg_person.setEmailaddress(emailaddress);;
	    cfg_person.setPassword(password);
		cfg_person.setUser_name(user_name);
		cfg_person.setEmployee_id(employee_id);
		cfg_person.setDn(dn);
		cfg_person.setState(state);
		cfg_person.setMax_count(max_count);
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		cfg_person.setCh_pass_on_login(strDate);
	
		int persondbid = 0;
		
		int updatecount=0;
		
		try{
			MaintainService maintainService = new MaintainService();
			
			
			List<CFG_person> cfg_personlist = maintainService.query_Person_Account(cfg_person);
//			System.out.println(cfg_personlist.get(0).getDbid());
			
			persondbid=cfg_personlist.get(0).getDbid();
			
			
			if(state==0){
				cfg_person.setPass_error_count(0);
				updatecount = maintainService.update_PersonInfo(cfg_person);
				jsonObject.put("updatecount", updatecount);
				if(group_dbid!=0){
					CFG_group_person cfg_group_person = new CFG_group_person();
					
					cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
					cfg_group_person.setGroup_dbid(group_dbid);
					int grouppersoncount = maintainService.update_Group_PersonInfo(cfg_group_person);
					jsonObject.put("group_person_insertcount", grouppersoncount);
				}
			}else{
				cfg_person.setPass_error_count(3);
				updatecount = maintainService.update_PersonInfo(cfg_person);
				jsonObject.put("updatecount", updatecount);
				if(group_dbid!=0){
					
					CFG_group_person cfg_group_person = new CFG_group_person();
					cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
					cfg_group_person.setGroup_dbid(group_dbid);
					int grouppersoncount = maintainService.update_Group_PersonInfo(cfg_group_person);
					jsonObject.put("group_person_insertcount", grouppersoncount);
			}
			}
			
			
			
			CFG_group_person cfg_group_person = new CFG_group_person();

			cfg_group_person.setPerson_dbid(persondbid);
				int Delete_groupperson = maintainService.delete_Group_PersonInfo(cfg_group_person);
				jsonObject.put("Delete_groupperson", Delete_groupperson);
			
				
			cfg_group_person.setPerson_dbid(persondbid);
			cfg_group_person.setGroup_dbid(group_dbid);
				int Insert_groupperson = maintainService.insert_Person_GroupInfo(cfg_group_person);
				jsonObject.put("Insert_groupperson", Insert_groupperson);
			
			
			
			
			
			
			
			
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
