package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
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


@Path("/Delete_GroupInfo")
public class Delete_GroupInfoServlet {
	/**
	 * 使用POST方法
	 * 刪除群組資訊
	 * @param DBID
	 * @return
	 * @throws IOException
	 */
	
	@POST
	@Produces("application/json")
    public Response postFromPath(
    		@FormParam("dbid") int dbid,
    		@FormParam("groupDBID_list") String groupDBID_list,
    		
    		@FormParam("GP_DBID_list") String GP_DBID_list
    		
			) throws IOException {
		

		JSONObject jsonObject = new JSONObject();
		
		CFG_group cfg_group = new CFG_group();
		CFG_role_member cfg_role_member =new CFG_role_member();
		CFG_role cfg_role= new CFG_role();
		CFG_permission cfg_permission= new CFG_permission();
		CFG_group_person cfg_group_person = new CFG_group_person();
		
		
		jsonObject.put("Status", Variable.POST_STATUS);
		
		List<Integer> groupDBID_list2 = new ArrayList<Integer>();

//		List<Integer> GP_DBID_list2 = new ArrayList<Integer>();

		
		
				
		try{
			MaintainService maintainService = new MaintainService();
			
			
			if(groupDBID_list.length()>0){
				String [] dd = groupDBID_list.split(",");
				
				for(int i=0 ;i<dd.length;i++){
					if(dd[i]!=null && dd[i]!=""){
						
					
					groupDBID_list2.add(Integer.valueOf(dd[i]));
					
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
			

			
			
			
			
			
			
			
			
		    
		    
		   
			
			
			
			
//			//刪除group person關聯式
//			if(GP_DBID_list.length()>0){
//				String [] dd = GP_DBID_list.split(",");
//				for(int i=0 ;i<dd.length;i++){
//					GP_DBID_list2.add(Integer.valueOf(dd[i]));
//				}
//				cfg_group_person.setGP_DBID_list(GP_DBID_list2);
//			}
//			cfg_group_person.setGroup_dbid(dbid);
//			int deletegrouppersoncount =maintainService.delete_Group_PersonInfo(cfg_group_person);
//			jsonObject.put("delete_group_personcount", deletegrouppersoncount);
			
			
//			List<CFG_role_member> cfg_role_member2list = maintainService.Select_Rolemember_Groupdbid(cfg_role_member);
//		    for (int i = 0; i < cfg_role_member2list.size(); i++) {
//
//		    	JSONObject Group2JsonObject = new JSONObject();
//		    }
			
//			cfg_role_member.setRolemember_DBID_list(GP_DBID_list2);
//			int delete_rolemember_count = maintainService.Delete_Role_MemberInfo(cfg_role_member);
//			jsonObject.put("delete_rolemember_count", delete_rolemember_count);
			
			 
			
			
			
			
//			cfg_role_member.setGroup_dbid(cfg_role_member2list.get(0).getRole_dbid());
//
//			int rolemember_count = maintainService.Delete_Role_MemberInfo(cfg_role_member);
//			jsonObject.put("role_count", rolemember_count);
//			
//			cfg_role.setDbid(cfg_role_member2list.get(0).getRole_dbid());
//			int role_count = maintainService.Delete_Role_Info(cfg_role);
//			jsonObject.put("role_count", role_count);
//			
//			
//			cfg_permission.setRole_dbid(cfg_role_member2list.get(0).getRole_dbid());
//			int permission_count = maintainService.Delete_Permission_Info(cfg_permission);
//			jsonObject.put("permission_count", permission_count);
			
			
			
			
			
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
