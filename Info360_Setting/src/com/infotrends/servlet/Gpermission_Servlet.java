package com.infotrends.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

@Path("/Gpermission")
public class Gpermission_Servlet {

	@POST
	@Produces("application/json")
	public Response postFromPath(@FormParam("dbid") int dbid)
			throws IOException {

		JSONObject jsonObject = new JSONObject();

		CFG_group cfg_group = new CFG_group();
		cfg_group.setDbid(dbid);

		try {

			MaintainService maintainService = new MaintainService();

			List<CFG_group> cfg_grouplist = maintainService
					.query_Group(cfg_group);

			if (cfg_group.getDbid() != 0) {

				// cfg_person
				JSONArray PersonGroupArray = new JSONArray();
				JSONArray GroupJsonArray = new JSONArray();
				JSONArray Role_memberArray = new JSONArray();
				JSONArray RoleArray = new JSONArray();
				JSONArray PermissionJsonArray = new JSONArray();
				JSONArray FunctionArray = new JSONArray();
				JSONArray PersonJsonArray = new JSONArray();
				JSONArray BEJsonArray = new JSONArray();

				List<String> cfg_BE_RoleFunctionList = new ArrayList<String>();

				for (int i = 0; i < cfg_grouplist.size(); i++) {

					JSONObject GroupJsonObject = new JSONObject();
					GroupJsonObject.put("dbid", cfg_grouplist.get(0).getDbid());
					GroupJsonObject.put("name", cfg_grouplist.get(0).getName());
					GroupJsonObject.put("state", cfg_grouplist.get(0)
							.getState());

					GroupJsonArray.put(GroupJsonObject);
				}
				jsonObject.put("group", GroupJsonArray);

				// ��cfg_group甈�

				if (1 == 1) {

					// ��cfg_group_person�
					CFG_group_person cfg_group_person = new CFG_group_person();
					cfg_group_person.setPerson_dbid(cfg_grouplist.get(0)
							.getDbid());
					List<CFG_group_person> cfg_person_grouplist = maintainService
							.query_Group_Person(cfg_group_person);

					for (int i = 0; i < cfg_person_grouplist.size(); i++) {
						JSONObject PersonGroupJsonObject = new JSONObject();
						PersonGroupJsonObject.put("person_dbid",
								cfg_person_grouplist.get(i).getPerson_dbid());
						PersonGroupJsonObject.put("group_dbid",
								cfg_person_grouplist.get(i).getGroup_dbid());

						PersonGroupArray.put(PersonGroupJsonObject);
						jsonObject.put("person_group", PersonGroupArray);

						// cfg_rolemember
						CFG_role_member cfg_role_member = new CFG_role_member();
						cfg_role_member.setGroup_dbid(cfg_person_grouplist.get(
								i).getGroup_dbid());
						List<CFG_role_member> cfg_role_memberlist = maintainService
								.Select_Rolemember_Groupdbid(cfg_role_member);

						JSONObject Role_memberJsonObject = new JSONObject();
						Role_memberJsonObject.put("Role_dbid",
								cfg_role_memberlist.get(0).getRole_dbid());
						Role_memberJsonObject.put("Group_dbid",
								cfg_role_memberlist.get(0).getGroup_dbid());
						Role_memberArray.put(Role_memberJsonObject);

						jsonObject.put("role_member", Role_memberArray);

						// cfg_role
						CFG_role cfg_role = new CFG_role();
						cfg_role.setDbid(cfg_role_memberlist.get(0)
								.getRole_dbid());
						List<CFG_role> cfg_rolelist = maintainService
								.Select_role_dbid(cfg_role);

						JSONObject RoleJsonObject = new JSONObject();
						RoleJsonObject.put("dbid", cfg_rolelist.get(0)
								.getDbid());
						RoleJsonObject.put("name", cfg_rolelist.get(0)
								.getName());
						RoleJsonObject.put("descripion", cfg_rolelist.get(0)
								.getDescripion());

						RoleArray.put(RoleJsonObject);
						jsonObject.put("role", RoleArray);

						// cfg_permission

						CFG_permission cfg_permission = new CFG_permission();
						cfg_permission.setRole_dbid(cfg_role_memberlist.get(0)
								.getRole_dbid());
						List<CFG_permission> cfg_permissionlist = maintainService
								.Select_permission_roledbid(cfg_permission);

						for (int a = 0; a < cfg_permissionlist.size(); a++) {

							JSONObject PermissionJsonObject = new JSONObject();
							PermissionJsonObject.put("dbid", cfg_permissionlist
									.get(a).getDbid());
							PermissionJsonObject.put("role_dbid",
									cfg_permissionlist.get(a).getRole_dbid());
							PermissionJsonObject.put("function_dbid",
									cfg_permissionlist.get(a)
											.getFunction_dbid().trim());
							PermissionJsonObject.put("createdatetime",
									cfg_permissionlist.get(a)
											.getCreatedatetime());
							PermissionJsonObject
									.put("createuserid", cfg_permissionlist
											.get(a).getCreateuserid());

							PermissionJsonArray.put(PermissionJsonObject);

							String[] RF = cfg_permissionlist.get(a)
									.getFunction_dbid().split(" ");
							for (int fr = 0; fr < RF.length; fr++) {

								cfg_BE_RoleFunctionList.add(RF[fr]);
							}
						}
						jsonObject.put("permission", PermissionJsonArray);
					}

					CFG_permission cfg_permission = new CFG_permission();
					cfg_permission
							.setCfg_BE_RoleFunctionList(cfg_BE_RoleFunctionList);
					List<CFG_permission> cfg_permissionlist = maintainService
							.Select_permission_roleFunction(cfg_permission);
					for (int a = 0; a < cfg_permissionlist.size(); a++) {
						JSONObject BEJsonObject = new JSONObject();

						BEJsonObject.put("function_dbid", cfg_permissionlist
								.get(a).getFunction_dbid().trim());

						BEJsonArray.put(BEJsonObject);

						jsonObject.put("RoleFunction", BEJsonArray);

						int i = Integer.parseInt(cfg_permissionlist.get(a)
								.getFunction_dbid().trim());

						// cfg_function
						CFG_function cfg_function = new CFG_function();
						cfg_function.setDbid(i);

						List<CFG_function> cfg_functionlist = maintainService
								.select_function_dbid(cfg_function);

						JSONObject FunctionJsonObject = new JSONObject();
						FunctionJsonObject.put("Dbid", cfg_functionlist.get(0)
								.getDbid());
						FunctionJsonObject.put("Arraynumber", cfg_functionlist
								.get(0).getArraynumber());
						FunctionJsonObject.put("Catalogid", cfg_functionlist
								.get(0).getCatalogid());
						FunctionJsonObject.put("Code", cfg_functionlist.get(0)
								.getCode());
						FunctionJsonObject.put("Name", cfg_functionlist.get(0)
								.getName());
						FunctionJsonObject.put("Permimg",
								cfg_functionlist.get(0).getPermimg());
						FunctionJsonObject.put("Programpath", cfg_functionlist
								.get(0).getProgrampath());
						FunctionJsonObject.put("State", cfg_functionlist.get(0)
								.getState());

						FunctionArray.put(FunctionJsonObject);
						jsonObject.put("Function", FunctionArray);

					}
					System.out.println("恭喜!! Login成功囉~");

				}
			} else {
				jsonObject.put("error", "帳號未輸入");
			}
		} catch (Exception e) {
			if (IsError.GET_EXCEPTION != null)

				jsonObject.put("error", IsError.GET_EXCEPTION);

			else
				jsonObject.put("error", e.getMessage());
			jsonObject.put("error", "帳號 密碼 尚未輸入或輸入錯誤");
		}

		return Response
				.status(200)
				.entity(jsonObject.toString())
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}

}
