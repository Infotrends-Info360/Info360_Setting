package com.infotrends.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;


@Path("/Login")
public class loginServlet {
	
	@POST
	@Produces("application/json")
	public Response postFromPath(
			@FormParam("account") String account,
			@FormParam("password") String password,
			@FormParam("pass_error_count") int pass_error_count

			) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		CFG_person cfg_person = new CFG_person();
		jsonObject.put("Status", Variable.POST_STATUS);
		
		cfg_person.setAccount(account);
	    cfg_person.setPassword(password);
	 
	    try{ 
	   
	    	MaintainService maintainService = new MaintainService();
	    	List<CFG_person> cfg_personlist = maintainService.Login_PersonInfo(cfg_person);
	    if(cfg_personlist.get(0).getPass_error_count()>=3){
	    	jsonObject.put("error", "登入錯誤過多,請洽客服");
	    }else if(cfg_person.getAccount() != null && !"".equals(cfg_person.getAccount().trim())){
	    	   
	    	 //cfg_person        
	        JSONArray PersonJsonArray = new JSONArray();
	        JSONArray PersonGroupArray = new JSONArray();
        	JSONArray GroupJsonArray = new JSONArray();
        	JSONArray Role_memberArray = new JSONArray();
        	JSONArray RoleArray = new JSONArray();
        	JSONArray PermissionJsonArray = new JSONArray();
        	JSONArray FunctionArray = new JSONArray();
        	JSONArray BEJsonArray = new JSONArray();
        	
        
        	List<String> cfg_BE_RoleFunctionList = new ArrayList<String>();
        	
        	
 	        JSONObject PersonJsonObject = new JSONObject();
 	        
 	        	PersonJsonObject.put("dn", cfg_personlist.get(0).getDn());
 	        	PersonJsonObject.put("dbid", cfg_personlist.get(0).getDbid());
 	        	PersonJsonObject.put("createdatetime", cfg_personlist.get(0).getCreatedatetime());
 	        	PersonJsonObject.put("account",    cfg_personlist.get(0).getAccount());
 	        	PersonJsonObject.put("password", cfg_personlist.get(0).getPassword());
 	        	PersonJsonObject.put("first_name", cfg_personlist.get(0).getFirst_name());
 	        	PersonJsonObject.put("last_name",  cfg_personlist.get(0).getLast_name());
 	        	PersonJsonObject.put("user_name",  cfg_personlist.get(0).getUser_name());
 	        	PersonJsonObject.put("employee_id", cfg_personlist.get(0).getEmployee_id());
 	        	PersonJsonObject.put("emailaddress", cfg_personlist.get(0).getEmailaddress());
 	        	PersonJsonObject.put("state", cfg_personlist.get(0).getState());  
 	        	PersonJsonObject.put("pass_error_count", cfg_personlist.get(0).getPass_error_count());
 	        	PersonJsonObject.put("ch_pass_on_login", cfg_personlist.get(0).getCh_pass_on_login());
 	        	PersonJsonObject.put("max_count", cfg_personlist.get(0).getMax_count());

 	        PersonJsonArray.put(PersonJsonObject);
 	       		
 	       
 	   if(cfg_person.getPassword().trim().equals(cfg_personlist.get(0).getPassword().trim())){

 		  jsonObject.put("person", PersonJsonArray);
 		  
 		  
 		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 		Date date = new Date();
 		String strDate = sdFormat.format(date);
 		String strDate2 = cfg_personlist.get(0).getCh_pass_on_login().replaceAll("-", "/");
 		String dbtime = strDate2.substring(0, 19);
 		
 		System.out.println("NOW: "+strDate);
 		System.out.println("DB: "+dbtime);
 		long cc = java.util.Date.parse(strDate);
 		long ff = java.util.Date.parse(dbtime);
 		System.out.println("轉NOW: "+cc);
 		System.out.println("轉DB: "+ff);
 		
 		long ans = cc-ff;
 		
 		System.out.println("ans "+ans);
 	
 		if(ans>180){
 			System.out.println("超過半年");
 		}else{
 			System.out.println("沒超過半年");
 		}
 		  
 	   //��cfg_group_person�
        	CFG_group_person cfg_group_person = new CFG_group_person();
        		cfg_group_person.setPerson_dbid(cfg_personlist.get(0).getDbid());
        	List<CFG_group_person> cfg_person_grouplist = maintainService.query_Group_Person(cfg_group_person);

        	for (int i = 0; i < cfg_person_grouplist.size(); i++) {
        		JSONObject PersonGroupJsonObject = new JSONObject();
	        		PersonGroupJsonObject.put("person_dbid", cfg_person_grouplist.get(i).getPerson_dbid());
	        		PersonGroupJsonObject.put("group_dbid", cfg_person_grouplist.get(i).getGroup_dbid()); 
	        	
	        		PersonGroupArray.put(PersonGroupJsonObject);
	        	jsonObject.put("person_group", PersonGroupArray);
        	
	 //��cfg_group甈�
	        CFG_group cfg_group = new CFG_group();
				cfg_group.setDbid(cfg_person_grouplist.get(i).getGroup_dbid());
			   
			List<CFG_group> cfg_grouplist = maintainService.query_Group(cfg_group);
			JSONObject GroupJsonObject = new JSONObject();
				GroupJsonObject.put("dbid", cfg_grouplist.get(0).getDbid());
				GroupJsonObject.put("name", cfg_grouplist.get(0).getName()); 
				GroupJsonObject.put("state", cfg_grouplist.get(0).getState());
			    
			GroupJsonArray.put(GroupJsonObject);
			jsonObject.put("group", GroupJsonArray);
			    
	//cfg_rolemember	
	        CFG_role_member cfg_role_member = new CFG_role_member();
	        	cfg_role_member.setGroup_dbid(cfg_person_grouplist.get(i).getGroup_dbid());
	        List<CFG_role_member> cfg_role_memberlist = maintainService.Select_Rolemember_Groupdbid(cfg_role_member);
	            	           
	        JSONObject Role_memberJsonObject = new JSONObject();
				Role_memberJsonObject.put("Role_dbid", cfg_role_memberlist.get(0).getRole_dbid());
				Role_memberJsonObject.put("Group_dbid", cfg_role_memberlist.get(0).getGroup_dbid());	
				Role_memberArray.put(Role_memberJsonObject);
	        
			jsonObject.put("role_member", Role_memberArray);
        	
						    
	//cfg_role	
	        CFG_role cfg_role = new CFG_role();
	        cfg_role.setDbid(cfg_role_memberlist.get(0).getRole_dbid());   	
	        List<CFG_role> cfg_rolelist = maintainService.Select_role_dbid(cfg_role);
	        
		    	JSONObject RoleJsonObject = new JSONObject();
		    	RoleJsonObject.put("dbid", cfg_rolelist.get(0).getDbid());
		    	RoleJsonObject.put("name", cfg_rolelist.get(0).getName());
		    	RoleJsonObject.put("descripion", cfg_rolelist.get(0).getDescripion());
		        	 	
		    RoleArray.put(RoleJsonObject);
			jsonObject.put("role", RoleArray);
		
	 //cfg_permission	
			
		    CFG_permission cfg_permission = new CFG_permission();
		    cfg_permission.setRole_dbid(cfg_role_memberlist.get(0).getRole_dbid());
		    List<CFG_permission> cfg_permissionlist = maintainService.Select_permission_roledbid(cfg_permission);
	  
		    for(int a = 0; a < cfg_permissionlist.size(); a++){
	    	
	    	JSONObject PermissionJsonObject = new JSONObject();
	    	PermissionJsonObject.put("dbid", cfg_permissionlist.get(a).getDbid());
			PermissionJsonObject.put("role_dbid", cfg_permissionlist.get(a).getRole_dbid());
			PermissionJsonObject.put("function_dbid", cfg_permissionlist.get(a).getFunction_dbid().trim());
			PermissionJsonObject.put("createdatetime", cfg_permissionlist.get(a).getCreatedatetime());
			PermissionJsonObject.put("createuserid", cfg_permissionlist.get(a).getCreateuserid());
	   
			PermissionJsonArray.put(PermissionJsonObject);

			String[] RF = cfg_permissionlist.get(a).getFunction_dbid().split(" ");
			for(int fr =0; fr<RF.length; fr++){
				
				cfg_BE_RoleFunctionList.add(RF[fr]);
			}
	    }
	    jsonObject.put("permission", PermissionJsonArray);
  }
        		
 	CFG_permission cfg_permission = new CFG_permission();
 	cfg_permission.setCfg_BE_RoleFunctionList(cfg_BE_RoleFunctionList);
 	List<CFG_permission> cfg_permissionlist = maintainService.Select_permission_roleFunction(cfg_permission);
 	for(int a = 0; a < cfg_permissionlist.size(); a++){
	    	JSONObject BEJsonObject = new JSONObject();

	    	BEJsonObject.put("function_dbid", cfg_permissionlist.get(a).getFunction_dbid().trim());

	    	BEJsonArray.put(BEJsonObject);
	   
	    jsonObject.put("RoleFunction", BEJsonArray);
 	
	     
	    int i = Integer.parseInt(cfg_permissionlist.get(a).getFunction_dbid().trim());
	    
	    
		//cfg_function
			CFG_function cfg_function= new CFG_function();
			cfg_function.setDbid(i);
					
			List<CFG_function> cfg_functionlist = maintainService.select_function_dbid(cfg_function);

			JSONObject FunctionJsonObject = new JSONObject();
				FunctionJsonObject.put("Dbid", cfg_functionlist.get(0).getDbid());
				FunctionJsonObject.put("Arraynumber", cfg_functionlist.get(0).getArraynumber());
				FunctionJsonObject.put("Catalogid", cfg_functionlist.get(0).getCatalogid());
				FunctionJsonObject.put("Code", cfg_functionlist.get(0).getCode());
				FunctionJsonObject.put("Name", cfg_functionlist.get(0).getName());
				FunctionJsonObject.put("Permimg", cfg_functionlist.get(0).getPermimg());
				FunctionJsonObject.put("Programpath", cfg_functionlist.get(0).getProgrampath());
				FunctionJsonObject.put("State", cfg_functionlist.get(0).getState());
			        	
			FunctionArray.put(FunctionJsonObject);
			jsonObject.put("Function", FunctionArray);
			
				
	
 	 }
 	
 	//Login 成功 且 Pass_error_count 小於3
 	int updatePasscount=0;
 	cfg_person.setPass_error_count(0);
	  updatePasscount = maintainService.login_ErrorCount(cfg_person);

 	
 	  }else{
 		//密碼錯誤 
 		 int updatePasscount=0;
// 		  System.out.println("帳號: " +cfg_person.getAccount());
// 		
 		  int count = cfg_personlist.get(0).getPass_error_count();
 		 int a = count+1;
 		
 		  cfg_person.setPass_error_count(a);
// 		  System.out.println("count:"+a);
 		  updatePasscount = maintainService.login_ErrorCount(cfg_person);
	    	
			jsonObject.put("ErrorCount", updatePasscount);

 		  	jsonObject.put("error", "密碼輸入錯誤");
 	  	    }
 	    
	    }else{
	    	//帳號未輸入
	    	jsonObject.put("error", "帳號未輸入");
	    	 }
	    
		} catch (Exception e) {
			if(IsError.GET_EXCEPTION != null)
			
				jsonObject.put("error", IsError.GET_EXCEPTION);

			else
				jsonObject.put("error", e.getMessage());
				jsonObject.put("error", "帳號 密碼 尚未輸入或輸入錯誤");
		}
		
		return Response.status(200).entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
			    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
			    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

}