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

import org.json.JSONObject;

import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.service.MaintainService;
import com.infotrends.util.IsError;
import com.infotrends.util.Variable;
@Path("/Update_GroupInfo")
public class Update_GroupInfoServlet {
	/**
	 * 雿輻POST�寞�
	 * �湔蝢斤�鞈�
	 * @param name
	 * @param state
	 * @return
	 * @throws IOException
	 */

	@POST
	@Produces("application/json")
	public Response postFromPath(
			
			@FormParam("name") String name,
			@FormParam("state") int state,
			@FormParam("person_dbid") String person_dbid,
			@FormParam("function_dbid") String function_dbid,
    		@FormParam("groupDBID_list") String groupDBID_list

			//@FormParam("person_dbid") long person_dbid
			) throws IOException {
	
		name=name.trim();
		

		JSONObject jsonObject = new JSONObject();
		CFG_group cfg_group = new CFG_group();
		CFG_role_member cfg_role_member =new CFG_role_member();
		CFG_role cfg_role= new CFG_role();
		CFG_permission cfg_permission= new CFG_permission();
		CFG_group_person cfg_group_person = new CFG_group_person();
		
		jsonObject.put("Status", Variable.POST_STATUS);
		cfg_group.setName(name);
		cfg_group.setState(state);
//		cfg_group.setGroupDBID_list(groupDBID_list);
		
		
		int updatecount=0;
		
		
		List<Integer> function_dbidLIST = new ArrayList<Integer>();
		List<Integer> person_dbidLIST = new ArrayList<Integer>();
		
		try{
			MaintainService maintainService = new MaintainService();
			
			if(groupDBID_list.length()>0){
				String [] dd = groupDBID_list.split(",");
				
				for(int i=0 ;i<dd.length;i++){
					if(dd[i]!=null && dd[i]!=""){
						
										
					//刪除group_person
					cfg_group_person.setGroup_dbid(Integer.valueOf(dd[i]));
					int delete_group_person_count = maintainService.delete_Group_PersonInfo(cfg_group_person);
					jsonObject.put("delete_grouppersn_count", delete_group_person_count);
					
					
					//groupdbid轉成roledbid
					cfg_role_member.setGroup_dbid(Integer.valueOf(dd[i]));
					List<CFG_role_member> cfg_role_member2list = maintainService.Select_Rolemember_Groupdbid(cfg_role_member);
//				    	cfg_role_member2list.get(0).getRole_dbid();
				    
				    System.out.println( "轉roledbid: "+cfg_role_member2list.get(0).getRole_dbid());
				    
//				    System.out.println( "role_member setRole_dbid: "+cfg_role_member2list.get(0).getRole_dbid());

				    //刪除role_member
				    cfg_role_member.setGroup_dbid(Integer.valueOf(dd[i]));
				    int delete_role_member_count = maintainService.Delete_Role_MemberInfo(cfg_role_member);
					jsonObject.put("delete_role_member_count", delete_role_member_count);
//				    
				    System.out.println( "cfg_role setDbid: "+cfg_role_member2list.get(0).getRole_dbid());

					//刪除role
					cfg_role.setDbid(cfg_role_member2list.get(0).getRole_dbid());
					 int delete_role_count = maintainService.Delete_Role_Info(cfg_role);
					jsonObject.put("delete_role_count", delete_role_count);
//					
					
				    System.out.println( "cfg_permission setRole_dbid: "+cfg_role_member2list.get(0).getRole_dbid());

					//刪除permission
					cfg_permission.setRole_dbid(cfg_role_member2list.get(0).getRole_dbid());
					int delete_permission_count = maintainService.Delete_Permission_Info(cfg_permission);
					jsonObject.put("delete_permission_count", delete_permission_count);
					
					//刪除部門
					cfg_group.setDbid(Integer.valueOf(dd[i]));
					int deletegroupcount = maintainService.delete_GroupInfo(cfg_group);
					jsonObject.put("delete_groupcount", deletegroupcount);
					}
				}
			}
			
			
			
			if(name!=""&&name!=null){
				
			cfg_group.setName(name);
			cfg_group.setState(state);
////		新增部門名稱
	    			int groupcount = maintainService.insert_GroupInfo(cfg_group);
	    			jsonObject.put("group_insertcount", groupcount);
	    			    
////		新增Role
	    			cfg_role.setDescripion(name+"權限");
	    			cfg_role.setName(name+"權限");
	    				int rolecount = maintainService.Insert_Role_Info(cfg_role);
	    				jsonObject.put("role_count", rolecount);
//	    		
//	   查詢 新增的group資訊
	    				cfg_group.setName(name);		
	    				List<CFG_group> cfg_grouplist3 = maintainService.query_Group_name(cfg_group);
//
//	查詢 新增的role資訊
	    				cfg_role.setName(name+"權限");
	    				List<CFG_role> cfg_rolelist = maintainService.Select_role(cfg_role);

//	新增Rolemember
	    				cfg_role_member.setRole_dbid(cfg_rolelist.get(0).getDbid());
	    				cfg_role_member.setGroup_dbid(cfg_grouplist3.get(0).getDbid());
	    				int role_member_count = maintainService.Insert_Role_MemberInfo(cfg_role_member);
	    				jsonObject.put("role_member_count", role_member_count);

		        
		 //新增Permission
		        
		        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
				Date date = new Date();
				String strDate = sdFormat.format(date);
				
				if(function_dbid.length()>0){
					String [] dd = function_dbid.split(",");
					for(int i=0 ;i<dd.length;i++){
						if(dd[i]!=null&&dd[i]!=""){

						function_dbidLIST.add(Integer.valueOf(dd[i]));
						
					     cfg_permission.setFunction_dbid(dd[i]);
					
					cfg_permission.setCreatedatetime(strDate);
			        cfg_permission.setRole_dbid(cfg_rolelist.get(0).getDbid());
			   
			        int permission_count  = maintainService.Insert_Permission_Info(cfg_permission);
	    			jsonObject.put("permission_count", permission_count);
						}
					}
				}
			
				
				
//新增相關人員	
	    		if(person_dbid.length()>0){
	    			System.out.println("進入人員");
	    			String [] dd = person_dbid.split(",");
					for(int i=0 ;i<dd.length;i++){
						if(dd[i]!=null&&dd[i]!=""){
						person_dbidLIST.add(Integer.valueOf(dd[i]));
					 		cfg_group_person.setGroup_dbid(cfg_grouplist3.get(0).getDbid());
					 		cfg_group_person.setPerson_dbid(Long.valueOf(dd[i]));
		    			int grouppersoncount = maintainService.insert_Person_GroupInfo(cfg_group_person);
		    			jsonObject.put("group_person_insertcount", grouppersoncount);
						}
					}
	    		}else{
	    			
	    		
	    			
	    		}
			}
			
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
