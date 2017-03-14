package com.infotrends.service;

import java.util.ArrayList;
import java.util.List;

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_group;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.dao.CFG_functionDao;
import com.infotrends.dao.CFG_groupDao;
import com.infotrends.dao.CFG_group_personDao;
import com.infotrends.dao.CFG_permissionDao;
import com.infotrends.dao.CFG_personDao;
import com.infotrends.dao.CFG_roleDao;
import com.infotrends.dao.CFG_role_memberDao;
import com.infotrends.util.IsError;

/**
 * 維護相關業務功能
 * 
 * @author Lin
 */
public class MaintainService {
	
	/**
	 * Logic_Delete
	 * 
	 * @param cfg_person
	 */
	public int Logic_Delete(CFG_group cfg_group) {
		int count = 0;
		try {
			CFG_groupDao cfg_groupdao = new CFG_groupDao();
			count = cfg_groupdao.Logic_Delete(cfg_group);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;
	}
	
	/**
	 * Select個人或全體資料的業務邏輯
	 * Query_PersonInfo_STATE
	 * @param cfg_person
	 */

	public List<CFG_group> Query_Group_state(CFG_group cfg_group) {
		if (cfg_group.getState() == 0) {
			List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
			try {
				CFG_groupDao cfg_groupdaodao = new CFG_groupDao();
				cfg_grouplist = cfg_groupdaodao.Query_Group_state(cfg_group);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_grouplist;
		}
		 if (cfg_group.getState() == 1) {
			 List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
				try {
					CFG_groupDao cfg_groupdaodao = new CFG_groupDao();
					cfg_grouplist = cfg_groupdaodao.Query_Group_state(cfg_group);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_grouplist;
		 }
		return null;
	}
	
	/**
	 * Logic_Delete
	 * 
	 * @param cfg_person
	 */
	public int Logic_Delete(CFG_person cfg_person) {
		int count = 0;
		try {
			CFG_personDao cfg_persondao = new CFG_personDao();
			count = cfg_persondao.Logic_Delete(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;
	}
	
	/**
	 * login_ErrorCount
	 * 
	 * @param cfg_person
	 */
	public int login_ErrorCount(CFG_person cfg_person) {
		int count = 0;
		try {
			CFG_personDao cfg_persondao = new CFG_personDao();
			count = cfg_persondao.login_ErrorCount(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;
	}
	
	/**
	 * Ppermission
	 * @param cfg_person
	 */

	public List<CFG_person> Ppermission(CFG_person cfg_person) {
		
		if (cfg_person.getDbid()!=0) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.Ppermission(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 
		return null;
	}
	
	
	/**
	 * @param Select_role
	 */

	public List<CFG_role> Select_role(CFG_role cfg_role) {
			List<CFG_role> cfg_rolelist = new ArrayList<CFG_role>();
			try {
				CFG_roleDao cfg_roleDao = new CFG_roleDao();
				cfg_rolelist = cfg_roleDao.Select_role(cfg_role);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_rolelist;
	}	
	
	
	
	/**
	 * Select_role_dbid
	 * Select_role_dbid
	 * @param Select_role_dbid
	 */

	public List<CFG_role> Select_role_dbid(CFG_role cfg_role) {
		if (cfg_role.getDbid() != 0) {
			List<CFG_role> cfg_rolelist = new ArrayList<CFG_role>();
			try {
				CFG_roleDao cfg_roleDao = new CFG_roleDao();
				cfg_rolelist = cfg_roleDao.Select_role_dbid(cfg_role);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_rolelist;
		}
		 if (cfg_role.getDbid() == 0) {
			 List<CFG_role> cfg_rolelist = new ArrayList<CFG_role>();
				try {
					CFG_roleDao cfg_roleDao = new CFG_roleDao();
					cfg_rolelist = cfg_roleDao.Select_role_dbid(cfg_role);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_rolelist;
		 }
		 return null;
	}	
	
	
	/**
	 * Select_Rolemember_Roledbid
	 * Select_Rolemember_Roledbid
	 * @param Select_Rolemember_Roledbid
	 */

	public List<CFG_role_member> Select_Rolemember_Roledbid(CFG_role_member cfg_role_member) {
		if (cfg_role_member.getRole_dbid() != 0) {
			List<CFG_role_member> cfg_role_memberlist = new ArrayList<CFG_role_member>();
			try {
				CFG_role_memberDao cfg_role_memberDaoDao = new CFG_role_memberDao();
				cfg_role_memberlist = cfg_role_memberDaoDao.Select_Rolemember_Roledbid(cfg_role_member);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_role_memberlist;
		}
		 if (cfg_role_member.getRole_dbid() == 0) {
			 List<CFG_role_member> cfg_role_memberlist = new ArrayList<CFG_role_member>();
				try {
					CFG_role_memberDao cfg_role_memberDaoDao = new CFG_role_memberDao();
					cfg_role_memberlist = cfg_role_memberDaoDao.Select_Rolemember_Roledbid(cfg_role_member);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_role_memberlist;
		 }
		 return null;
	}
	
	
	/**
	 * Select_Rolemember_Groupdbid
	 * Select_Rolemember_Groupdbid
	 * @param Select_Rolemember_Groupdbid
	 */

	public List<CFG_role_member> Select_Rolemember_Groupdbid(CFG_role_member cfg_role_member) {
		if (cfg_role_member.getGroup_dbid() != 0) {
			List<CFG_role_member> cfg_role_memberlist = new ArrayList<CFG_role_member>();
			try {
				CFG_role_memberDao cfg_role_memberDao = new CFG_role_memberDao();
				cfg_role_memberlist = cfg_role_memberDao.Select_Rolemember_Groupdbid(cfg_role_member);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_role_memberlist;
		}
		 if (cfg_role_member.getGroup_dbid()==0) {
			 List<CFG_role_member> cfg_role_memberlist = new ArrayList<CFG_role_member>();
				try {
					CFG_role_memberDao cfg_role_memberDao = new CFG_role_memberDao();
					cfg_role_memberlist = cfg_role_memberDao.Select_Rolemember_Groupdbid(cfg_role_member);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_role_memberlist;
		 }
		 return null;
	}	
	
	
	/**
	 * Select_permission_dbid
	 * Select_permission_dbid
	 * @param Select_permission_dbid
	 */

	public List<CFG_permission> Select_permission_roledbid(CFG_permission cfg_permission) {
		if (cfg_permission.getRole_dbid() != 0) {
			List<CFG_permission> cfg_permissionlist = new ArrayList<CFG_permission>();
			try {
				CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
				cfg_permissionlist = cfg_permissionDao.Select_permission_roledbid(cfg_permission);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_permissionlist;
		}
		 if (cfg_permission.getRole_dbid() == 0) {
			 List<CFG_permission> cfg_permissionlist = new ArrayList<CFG_permission>();
				try {
					CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
					cfg_permissionlist = cfg_permissionDao.Select_permission_roledbid(cfg_permission);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_permissionlist;
		 }
		 return null;
	}	
	
	
	/**
	 * Select_permission_roleFunction
	 * Select_permission_roleFunction
	 * @param Select_permission_roleFunction
	 */

	public List<CFG_permission> Select_permission_roleFunction(CFG_permission cfg_permission) {
		if (cfg_permission.getFunction_dbid()!="") {
			List<CFG_permission> cfg_permissionlist = new ArrayList<CFG_permission>();
			try {
				CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
				cfg_permissionlist = cfg_permissionDao.Select_permission_roleFunction(cfg_permission);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_permissionlist;
		}
		 if (cfg_permission.getFunction_dbid()=="") {
			 List<CFG_permission> cfg_permissionlist = new ArrayList<CFG_permission>();
				try {
					CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
					cfg_permissionlist = cfg_permissionDao.Select_permission_roleFunction(cfg_permission);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_permissionlist;
		 }
		 return null;
	}	
	
	/**
	 * Select_BE_FunctionPermission
	 * Select_BE_FunctionPermission
	 * @param Select_BE_FunctionPermission
	 */

	public List<CFG_function> Select_BE_FunctionPermission(CFG_function cfg_function) {
		if (cfg_function.getDbid()!=0) {
			List<CFG_function> cfg_functionlist = new ArrayList<CFG_function>();
			try {
				CFG_functionDao cfg_functionDao = new CFG_functionDao();
				cfg_functionlist = cfg_functionDao.Select_BE_FunctionPermission(cfg_function);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_functionlist;
		}
		
		 return null;
	}	
	
	
	/**
	 * Select_BE_GroupPerson
	 * Select_BE_GroupPerson
	 * @param Select_BE_GroupPerson
	 */

	public List<CFG_group_person> Select_BE_GroupPerson(CFG_group_person cfg_group_person) {
		if (cfg_group_person.getPerson_dbid()!=0) {
			List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
			try {
				CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
				cfg_group_personlist = cfg_group_personDao.Select_BE_GroupPerson(cfg_group_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_group_personlist;
		}
		 if (cfg_group_person.getPerson_dbid()==0) {
			 List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
				try {
					CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
					cfg_group_personlist = cfg_group_personDao.Select_BE_GroupPerson(cfg_group_person);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_group_personlist;
		 }
		 return null;
	}	
	
	
	/**
	 * select_function_sort
	 * select_function_sort
	 * @param select_function_sort
	 */

	public List<CFG_function> select_function_state(CFG_function cfg_function) {
		
			List<CFG_function> cfg_functionlist = new ArrayList<CFG_function>();
			try {
				CFG_functionDao cfg_functionDao = new CFG_functionDao();
				cfg_functionlist = cfg_functionDao.select_function_state(cfg_function);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_functionlist;
	}
	
	
	/**
	 * select_function_DBID
	 * select_function_DBID
	 * @param select_function_DBID
	 */

	public List<CFG_function> select_function_dbid(CFG_function cfg_function) {
		if (cfg_function.getDbid() != 0) {
			List<CFG_function> cfg_functionlist = new ArrayList<CFG_function>();
			try {
				CFG_functionDao cfg_functionDao = new CFG_functionDao();
				cfg_functionlist = cfg_functionDao.select_function_dbid(cfg_function);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_functionlist;
		}
		 if (cfg_function.getDbid() == 0) {
			 List<CFG_function> cfg_functionlist = new ArrayList<CFG_function>();
				try {
					CFG_functionDao cfg_functionDao = new CFG_functionDao();
					cfg_functionlist = cfg_functionDao.select_function_dbid(cfg_function);
				} catch (Exception e) {
					IsError.GET_EXCEPTION = e.getMessage();
				}
				return cfg_functionlist;
		}
		return null;
	}
	


	/**
	 * Login_PersonInfo
	 * @param cfg_person.account
	 */

	public List<CFG_person> Login_PersonInfo(CFG_person cfg_person) {
		
		if (cfg_person.getAccount() != null && !"".equals(cfg_person.getAccount().trim())&&
			cfg_person.getPassword() != null && !"".equals(cfg_person.getPassword().trim())) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.Login_PersonInfo(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 
		return null;
	}
	
	
	/**
	 * Select個人或全體資料的業務邏輯
	 * Account Query
	 * @param cfg_person.account
	 */

	public List<CFG_person> query_Person_Account(CFG_person cfg_person) {
		if (cfg_person.getAccount() != null && !"".equals(cfg_person.getAccount().trim())) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person_Account(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 if (cfg_person.getAccount().trim() == null || "".equals(cfg_person.getAccount().trim())) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person_Account(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		return null;
	}
	
	/**
	 * Select個人或全體資料的業務邏輯
	 * DBID Query
	 * @param cfg_person.account
	 */

	public List<CFG_person> query_Person_DBID(CFG_person cfg_person) {
		if (cfg_person.getDbid() != 0) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person_DBID(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 if (cfg_person.getDbid() == 0) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person_DBID(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		return null;
	}
	
	
	/**
	 * Select個人或全體資料的業務邏輯
	 * Query_PersonInfo_STATE
	 * @param cfg_person
	 */

	public List<CFG_person> Query_PersonInfo_STATE(CFG_person cfg_person) {
		if (cfg_person.getState() == 0) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.Query_PersonInfo_STATE(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		 if (cfg_person.getState() == 1) {
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.Query_PersonInfo_STATE(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		}
		return null;
	}
	
	
	/**
	 * Select群組資料的業務邏輯
	 * DBID Query
	 * @param CFG_group.dbid
	 */

	public List<CFG_group> query_Group(CFG_group cfg_group) {
		if (cfg_group.getDbid() != 0) {
			List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
			try {
				CFG_groupDao cfg_groupDao = new CFG_groupDao();
				cfg_grouplist = cfg_groupDao.query_Group(cfg_group);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_grouplist;
		}
		 if (cfg_group.getDbid() == 0) {
			List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
			try {
				CFG_groupDao cfg_groupDao = new CFG_groupDao();
				cfg_grouplist = cfg_groupDao.query_Group(cfg_group);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_grouplist;
		}
		return null;
	}
	
	/**
	 * Select群組資料的業務邏輯
	 * name Query
	 * @param CFG_group.dbid
	 */

	public List<CFG_group> query_Group_name(CFG_group cfg_group) {
		if (cfg_group.getDbid() != 0) {
			List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
			try {
				CFG_groupDao cfg_groupDao = new CFG_groupDao();
				cfg_grouplist = cfg_groupDao.query_Group_name(cfg_group);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_grouplist;
		}
		 if (cfg_group.getDbid() == 0) {
			List<CFG_group> cfg_grouplist = new ArrayList<CFG_group>();
			try {
				CFG_groupDao cfg_groupDao = new CFG_groupDao();
				cfg_grouplist = cfg_groupDao.query_Group_name(cfg_group);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_grouplist;
		}
		return null;
	}
	
	/**
	 * Select個人群組獲所有群組資料的業務邏輯
	 * 
	 * @param CFG_group_person
	 */

	public List<CFG_group_person> query_Group_Person(CFG_group_person cfg_group_person) {
		if (cfg_group_person.getGroup_dbid()!=0) {
			List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
			try {
				CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
				cfg_group_personlist = cfg_group_personDao.query_Group_PersonInfo(cfg_group_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_group_personlist;
		}
		 if (cfg_group_person.getPerson_dbid()!=0) {
			List<CFG_group_person> cfg_group_personlist = new ArrayList<CFG_group_person>();
			try {
				CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
				cfg_group_personlist = cfg_group_personDao.query_Group_PersonInfo(cfg_group_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_group_personlist;
		}
		
		return null;

}
	
	/**
	 * 新增註冊個人資料
	 * 
	 * @param cfg_function
	 */
	public int Insert_Function(CFG_function cfg_function) {
		int count = 0;
		try {
			CFG_functionDao cfg_functionDao = new CFG_functionDao();
			count = cfg_functionDao.Insert_Function(cfg_function);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * 新增註冊個人資料
	 * 
	 * @param cfg_role_member
	 */
	public int Insert_Role_MemberInfo(CFG_role_member cfg_role_member) {
		int count = 0;
		try {
			CFG_role_memberDao cfg_role_memberDao = new CFG_role_memberDao();
			count = cfg_role_memberDao.Insert_Role_MemberInfo(cfg_role_member);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * 新增註冊個人資料
	 * 
	 * @param cfg_role
	 */
	public int Insert_Role_Info(CFG_role cfg_role) {
		int count = 0;
		try {
			CFG_roleDao cfg_role_Dao = new CFG_roleDao();
			count = cfg_role_Dao.Insert_Role_Info(cfg_role);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	
	/**
	 * 新增註冊個人資料
	 * 
	 * @param Insert_Permission_Info
	 */
	public int Insert_Permission_Info(CFG_permission cfg_permission) {
		int count = 0;
		try {
			CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
			count = cfg_permissionDao.Insert_Permission_Info(cfg_permission);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * 新增註冊個人資料
	 * 
	 * @param cfg_person
	 */
	public int Insert_PersonInfo(CFG_person cfg_person) {
	
		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.Insert_PersonInfo(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	
	/**
	 * 新增註冊群組資料
	 * 
	 * @param cfg_person
	 */
	public int insert_GroupInfo(CFG_group cfg_group) {
		int count = 0;
		try {
			CFG_groupDao cfg_groupDao = new CFG_groupDao();
			count = cfg_groupDao.insert_GroupInfo(cfg_group);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}

	/**
	 * 新增個人所屬群組資料
	 * 
	 * @param CFG_group_person
	 */
	public int insert_Person_GroupInfo(CFG_group_person cfg_group_person) {
		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.insert_Group_PersonInfo(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}

	
	
	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param cfg_person
	 */
	public int update_PersonInfo(CFG_person cfg_person) {

		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.update_PersonInfo(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param Update_Permission_Info
	 */
	public int Update_Permission_Info(CFG_permission cfg_permission) {

		int count = 0;
		try {
			CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
			count = cfg_permissionDao.Update_Permission_Info(cfg_permission);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param cfg_role
	 */
	public int Update_Role_Info(CFG_role cfg_role) {

		int count = 0;
		try {
			CFG_roleDao cfg_roleDao = new CFG_roleDao();
			count = cfg_roleDao.Update_Role_Info(cfg_role);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param cfg_role_member
	 */
	public int Update_Role_MemberInfo(CFG_role_member cfg_role_member) {

		int count = 0;
		try {
			CFG_role_memberDao cfg_role_memberDao = new CFG_role_memberDao();
			count = cfg_role_memberDao.Update_Role_MemberInfo(cfg_role_member);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update個人資料的業務邏輯
	 * 
	 * @param cfg_Funftion
	 */
	public int Update_FunctionInfo(CFG_function cfg_function) {

		int count = 0;
		try {
			CFG_functionDao cfg_functionDao = new CFG_functionDao();
			count = cfg_functionDao.Update_FunctionInfo(cfg_function);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update群組資料的業務邏輯
	 * 
	 * @param cfg_person
	 */
	public int update_GroupInfo(CFG_group cfg_group) {

		int count = 0;
		try {
			CFG_groupDao cfg_groupdao = new CFG_groupDao();
			count = cfg_groupdao.update_GroupInfo(cfg_group);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update個人群組資訊
	 * 
	 * @param CFG_group_person
	 */
	public int update_Group_PersonInfo(CFG_group_person cfg_group_person) {

		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.update_Group_PersonInfo(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Update群組個人資訊
	 * 
	 * @param CFG_group_person
	 */
	public int update_Person_GroupInfo(CFG_group_person cfg_group_person) {

		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.update_Person_GroupInfo(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	

	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_person
	 */
	public int delete_PersonInfo(CFG_person cfg_person) {

		int count = 0;
		try {
			CFG_personDao cfg_personDao = new CFG_personDao();
			count = cfg_personDao.delete(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_permission
	 */
	public int Delete_Permission_Info(CFG_permission cfg_permission) {

		int count = 0;
		try {
			CFG_permissionDao cfg_permissionDao = new CFG_permissionDao();
			count = cfg_permissionDao.Delete_Permission_Info(cfg_permission);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	
	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_role
	 */
	public int Delete_Role_Info(CFG_role cfg_role) {

		int count = 0;
		try {
			CFG_roleDao cfg_roleDao = new CFG_roleDao();
			count = cfg_roleDao.Delete_Role_Info(cfg_role);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_Role_Member
	 */
	public int Delete_Role_MemberInfo(CFG_role_member cfg_role_member) {

		int count = 0;
		try {
			CFG_role_memberDao cfg_role_memberDao = new CFG_role_memberDao();
			count = cfg_role_memberDao.Delete_Role_MemberInfo(cfg_role_member);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Delete 個人資料的業務邏輯
	 * 
	 * @param cfg_Funftion
	 */
	public int Delete_FunctionInfo(CFG_function cfg_function) {

		int count = 0;
		try {
			CFG_functionDao cfg_functionDao = new CFG_functionDao();
			count = cfg_functionDao.Delete_FunctionInfo(cfg_function);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Delete 群組資料的業務邏輯
	 * 
	 * @param cfg_person
	 */
	public int delete_GroupInfo(CFG_group cfg_group) {

		int count = 0;
		try {
			CFG_groupDao cfg_groupdao = new CFG_groupDao();
			count = cfg_groupdao.delete(cfg_group);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
	/**
	 * Delete 個人群組資料資訊
	 * 
	 * @param CFG_group_person
	 */
	public int delete_Group_PersonInfo(CFG_group_person cfg_group_person) {

		int count = 0;
		try {
			CFG_group_personDao cfg_group_personDao = new CFG_group_personDao();
			count = cfg_group_personDao.delete(cfg_group_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return count;

		// return null;
	}
	
}