package com.infotrends.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Util;

import com.infotrends.bean.Activitydata;
import com.infotrends.bean.Activitygroups;
import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.CaseComments;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.Cfg_AgentStatus;
import com.infotrends.bean.Cfg_CaseStatus;
import com.infotrends.bean.Cfg_ServiceName_Mapping;
import com.infotrends.bean.Cfg_ServiceName_Setting;
import com.infotrends.bean.CommonLink;
import com.infotrends.bean.ContactData;
import com.infotrends.bean.Interaction;
import com.infotrends.bean.Rpt_Activitylog;
import com.infotrends.bean.Rpt_AgentStatus;
import com.infotrends.bean.ServiceEntry;
import com.infotrends.bean.SystemCfg;
import com.infotrends.dao.ActivitydataDao;
import com.infotrends.dao.ActivitygroupsDao;
import com.infotrends.dao.ActivitymenuDao;
import com.infotrends.dao.AgentReasonDao;
import com.infotrends.dao.CaseCommentsDao;
import com.infotrends.dao.Cfg_AgentStatusDao;
import com.infotrends.dao.Cfg_CaseStatusDao;
import com.infotrends.dao.Cfg_ServiceName_MappingDao;
import com.infotrends.dao.Cfg_ServiceName_SettingDao;
import com.infotrends.dao.CommonlinkDao;
import com.infotrends.dao.ContactDataDao;
import com.infotrends.dao.InteractionDao;
import com.infotrends.dao.Rpt_ActivitylogDao;
import com.infotrends.dao.Rpt_AgentStatusDao;
import com.infotrends.dao.ServiceEntryDao;
import com.infotrends.dao.SystemCfgDao;
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
	
//	/**
//	 * Select個人或全體資料的業務邏輯
//	 * DBID Query
//	 * @param cfg_person.account
//	 */
//
//	public List<CFG_person> query_Person_DBID(CFG_person cfg_person) {
//		if (cfg_person.getDbid() != 0) {
//			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
//			try {
//				CFG_personDao cfg_personDao = new CFG_personDao();
//				cfg_personlist = cfg_personDao.query_Person_DBID(cfg_person);
//			} catch (Exception e) {
//				IsError.GET_EXCEPTION = e.getMessage();
//			}
//			return cfg_personlist;
//		}
//		 if (cfg_person.getDbid() == 0) {
//			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
//			try {
//				CFG_personDao cfg_personDao = new CFG_personDao();
//				cfg_personlist = cfg_personDao.query_Person_DBID(cfg_person);
//			} catch (Exception e) {
//				IsError.GET_EXCEPTION = e.getMessage();
//			}
//			return cfg_personlist;
//		}
//		return null;
//	}
	
	
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
	
	
	/*** 從IMWebsocket移過來的RESTful(以下) ***/
	/**
	 * @param Query_All_Contactdata
	 */
	public List<ContactData> Query_All_Contactdata(ContactData contactdata) {
		
			List<ContactData> contactdatalist = new ArrayList<ContactData>();
			try {
				ContactDataDao contactdatadao = new ContactDataDao();
				contactdatalist = contactdatadao.Query_All_Contactdata(contactdata);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return contactdatalist;
	}
	
	/**
	 * @param Query_PersonInfo_STATE
	 */
	public List<Cfg_ServiceName_Mapping> Query_Cfg_ServiceName_MappingInfo(Cfg_ServiceName_Mapping cfg_servicename_mapping) {
		
			List<Cfg_ServiceName_Mapping> cfg_servicename_mappinglist = new ArrayList<Cfg_ServiceName_Mapping>();
			try {
				Cfg_ServiceName_MappingDao cfg_servicename_mappingdao = new Cfg_ServiceName_MappingDao();
				cfg_servicename_mappinglist = cfg_servicename_mappingdao.Query_Cfg_ServiceName_MappingInfo(cfg_servicename_mapping);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_servicename_mappinglist;
	}
	
	
	
	
	/**
	 * @param TITLEGROUP_activitydata
	 */

	public List<Activitydata> TITLEGROUP_activitydata(Activitydata activitydata) {
		
			List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
			try {
				ActivitydataDao activitydatadao = new ActivitydataDao();
				activitydatalist = activitydatadao.TITLEGROUP_activitydata(activitydata);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitydatalist;
	}
	
	/**
	 * @param Query_AGroup_DBID
	 */

	public List<Activitygroups> Query_AGroup_DBID(Activitygroups activitygroups) {
		
			List<Activitygroups> activitygroupslist = new ArrayList<Activitygroups>();
			try {
				ActivitygroupsDao activitygroupsdao = new ActivitygroupsDao();
				activitygroupslist = activitygroupsdao.Query_AGroup_DBID(activitygroups);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitygroupslist;
		
	}
	
	/**

	 * @param Query_AGroup_Sort
	 */

	public List<Activitygroups> Query_AGroup_Sort(Activitygroups activitygroups) {
		
			List<Activitygroups> activitygroupslist = new ArrayList<Activitygroups>();
			try {
				ActivitygroupsDao activitygroupsdao = new ActivitygroupsDao();
				activitygroupslist = activitygroupsdao.Query_AGroup_Sort(activitygroups);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitygroupslist;
		
	}
	
	/**
	 * AGroup_Sort
	 * @param AGroup_Sort
	 */
	public int AGroup_Sort(Activitygroups activitygroups) {
		int count = 0;
		try {
			ActivitygroupsDao activitygroupsdao = new ActivitygroupsDao();
			count = activitygroupsdao.AGroup_Sort(activitygroups);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}
	
	/**

	 * @param Query_AData_DBID
	 */

	public List<Activitydata> Query_AData_DBID(Activitydata activitydata) {
		
			List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
			try {
				ActivitydataDao activitydatadao = new ActivitydataDao();
				activitydatalist = activitydatadao.Query_AData_DBID(activitydata);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitydatalist;
		
	}
	
	/**

	 * @param Query_AData_Sort
	 */

	public List<Activitydata> Query_AData_Sort(Activitydata activitydata) {
		
			List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
			try {
				ActivitydataDao activitydatadao = new ActivitydataDao();
				activitydatalist = activitydatadao.Query_AData_Sort(activitydata);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitydatalist;
		
	}
	
	/**
	 * AData_Sort
	 * @param AData_Sort
	 */
	public int AData_Sort(Activitydata activitydata) {
		int count = 0;
		try {
			ActivitydataDao activitydatadao = new ActivitydataDao();
			count = activitydatadao.AData_Sort(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}
	

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_casecomments
	 */

	public int Insert_casecomments(CaseComments casecomments) {
		int count = 0;
		try {
			CaseCommentsDao casecommentsdao = new CaseCommentsDao();
			count = casecommentsdao.Insert_casecomments(casecomments);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}
	
	
	/**
	 * 
	 * IXN_cfg_commonlink
	 * 
	 * @param IXN_cfg_commonlink
	 */
	public List<Cfg_CaseStatus> Select_IXN_cfg_casestatus(Cfg_CaseStatus cfg_casestatus) {

		List<Cfg_CaseStatus> cfg_casestatuslist = new ArrayList<Cfg_CaseStatus>();
		try {
			Cfg_CaseStatusDao cfg_casestatusdaodao = new Cfg_CaseStatusDao();
			cfg_casestatuslist = cfg_casestatusdaodao.Select_IXN_cfg_casestatus(cfg_casestatus);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return cfg_casestatuslist;
	}
	
	
	/**
	 * 
	 * Select_IXN_cfg_casecomments
	 * 
	 * @param Select_IXN_cfg_casecomments
	 */
	public List<CaseComments> Select_IXN_casecomments(CaseComments casecomments) {

		List<CaseComments> casecommentslist = new ArrayList<CaseComments>();
		try {
			CaseCommentsDao casecommentsdao = new CaseCommentsDao();
			casecommentslist = casecommentsdao.Select_IXN_casecomments(casecomments);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return casecommentslist;
	}
	
	
	/**
	 * 
	 * Query_Contactdata
	 * 
	 * @param Query_Contactdata
	 */
	public Map<String, String> Query_Contactdata(String contactid) {
		Map<String, String> contactdatamap = new HashMap<String, String>();
		//List<ContactData> contactdatalist = new ArrayList<ContactData>();
		try {
			ContactDataDao contactdatadao = new ContactDataDao();
			contactdatamap = contactdatadao.Query_Contactdata(contactid);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return contactdatamap;
	}
	
	
	/**
	 * 
	 * Select_commonlink
	 * 
	 * @param Select_commonlink
	 */
	public List<CommonLink> Select_PARNETID_commonlink(CommonLink commonlink) {

		List<CommonLink> commonlinklist = new ArrayList<CommonLink>();
		try {
			CommonlinkDao commonlinkdao = new CommonlinkDao();
			commonlinklist = commonlinkdao.Select_PARNETID_commonlink(commonlink);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return commonlinklist;
	}
	
	
	/**

	 * @param Query_AMenu_DBID
	 */

	public List<Activitymenu> Query_AMenu_DBID(Activitymenu activitymenu) {
		
			List<Activitymenu> activitymenulist = new ArrayList<Activitymenu>();
			try {
				ActivitymenuDao activitymenudao = new ActivitymenuDao();
				activitymenulist = activitymenudao.Query_AMenu_DBID(activitymenu);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitymenulist;
		
	}
	
	/**

	 * @param Query_AMenu_Sort
	 */

	public List<Activitymenu> Query_AMenu_Sort(Activitymenu activitymenu) {
		
			List<Activitymenu> activitymenulist = new ArrayList<Activitymenu>();
			try {
				ActivitymenuDao activitymenudao = new ActivitymenuDao();
				activitymenulist = activitymenudao.Query_AMenu_Sort(activitymenu);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return activitymenulist;
		
	}
	
	/**
	 * 
	 * AMenu_Sort
	 * 
	 * @param AMenu_Sort
	 */
	public int AMenu_Sort(Activitymenu activitymenu) {
		int count = 0;
		try {
			ActivitymenuDao activitymenudaodao = new ActivitymenuDao();
			count = activitymenudaodao.AMenu_Sort(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}
	
	
	
	/**
	 * Select個人或全體資料的業務邏輯
	 * DBID Query
	 * @param cfg_person.account
	 */

	public List<CFG_person> query_Person_DBID(CFG_person cfg_person) {
		
			List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
			try {
				CFG_personDao cfg_personDao = new CFG_personDao();
				cfg_personlist = cfg_personDao.query_Person_DBID(cfg_person);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
			}
			return cfg_personlist;
		
	}
	
	/**
	 * 
	 * IXN_activitydata
	 * 
	 * @param IXN_activitydata
	 */
	public List<Activitydata> IXN_activitydata(Activitydata activitydata) {

		List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
		try {
			ActivitydataDao activitydatadao = new ActivitydataDao();
			activitydatalist = activitydatadao.IXN_activitydata(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
		}
		return activitydatalist;
	}
	
	
	
	/**
	 * 
	 * Selcet_activitylog
	 * 
	 * @param Selcet_activitylog
	 */
	public List<Rpt_Activitylog> Selcet_activitylog(Rpt_Activitylog rpt_activitylog) {

		List<Rpt_Activitylog> rpt_activityloglist = new ArrayList<Rpt_Activitylog>();
		try {
			Rpt_ActivitylogDao Rpt_ActivitylogDaoDao = new Rpt_ActivitylogDao();
			rpt_activityloglist = Rpt_ActivitylogDaoDao.Selcet_activitylog(rpt_activitylog);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
		}
		return rpt_activityloglist;
	}
	

	/**
	 * 
	 * LogicDelete_activitygroups
	 * 
	 * @param LogicDelete_activitygroups
	 */
	public int LogicDelete_activitygroups(Activitygroups activitygroups) {
		int count = 0;
		try {
			ActivitygroupsDao activitygroupsdaodao = new ActivitygroupsDao();
			count = activitygroupsdaodao
					.LogicDelete_activitygroups(activitygroups);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * LogicDelete_ActivityData
	 * 
	 * @param LogicDelete_ActivityData
	 */
	public int LogicDelete_ActivityData(Activitydata activitydata) {
		int count = 0;
		try {
			ActivitydataDao activitydatadaodao = new ActivitydataDao();
			count = activitydatadaodao.LogicDelete_ActivityData(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * Flag_activitydata
	 * 
	 * @param Flag_activitydata
	 */
	public List<Activitydata> Flag_activitydata(Activitydata activitydata) {

		List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
		try {
			ActivitydataDao ActivitydataDao = new ActivitydataDao();
			activitydatalist = ActivitydataDao.Flag_activitydata(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return activitydatalist;
	}

	/**
	 * 
	 * LogicDelete_activitymenu
	 * 
	 * @param LogicDelete_activitymenu
	 */
	public int LogicDelete_activitymenu(Activitymenu activitymenu) {
		int count = 0;
		try {
			ActivitymenuDao activitymenudaodao = new ActivitymenuDao();
			count = activitymenudaodao.LogicDelete_activitymenu(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * Delete_agentreason
	 * 
	 * @param Delete_agentreason
	 */
	public int Delete_agentreason(Cfg_AgentReason agentreason) {
		int count = 0;
		try {
			AgentReasonDao agentreasondaodao = new AgentReasonDao();
			count = agentreasondaodao.Delete_agentreason(agentreason);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * Flag_activitymenu
	 * 
	 * @param Flag_activitymenu
	 */
	public List<Activitymenu> Flag_activitymenu(Activitymenu activitymenu) {

		List<Activitymenu> activitymenulist = new ArrayList<Activitymenu>();
		try {
			ActivitymenuDao activitymenudao = new ActivitymenuDao();
			activitymenulist = activitymenudao.Flag_activitymenu(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return activitymenulist;
	}

	/**
	 * update
	 * 
	 * @param Update_activitydata
	 */
	public int Update_activitydata(Activitydata activitydata) {
		int count = 0;
		try {
			ActivitydataDao activitydatadaodao = new ActivitydataDao();
			count = activitydatadaodao.Update_activitydata(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * update
	 * 
	 * @param Update_activitygroups
	 */
	public int Update_activitygroups(Activitygroups activitygroups) {
		int count = 0;
		try {
			ActivitygroupsDao activitygroupsdaodao = new ActivitygroupsDao();
			count = activitygroupsdaodao.Update_activitygroups(activitygroups);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * update
	 * 
	 * @param Update_activitymenu
	 */
	public int Update_activitymenu(Activitymenu activitymenu) {
		int count = 0;
		try {
			ActivitymenuDao activitymenudaodao = new ActivitymenuDao();
			count = activitymenudaodao.Update_activitymenu(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_activitydata
	 */

	public int Insert_activitydata(Activitydata activitydata) {
		int count = 0;
		try {
			ActivitydataDao activitydatadao = new ActivitydataDao();
			count = activitydatadao.Insert_activitydata(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_activitygroups
	 */

	public int Insert_activitygroups(Activitygroups activitygroups) {
		int count = 0;
		try {
			ActivitygroupsDao activitygroupsdao = new ActivitygroupsDao();
			count = activitygroupsdao.Insert_activitygroups(activitygroups);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_activitymenu
	 */

	public int Insert_activitymenu(Activitymenu activitymenu) {
		int count = 0;
		try {
			ActivitymenuDao activitymenudao = new ActivitymenuDao();
			count = activitymenudao.Insert_activitymenu(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_agentreason
	 */

	public int Insert_agentreason(Cfg_AgentReason agentreason) {
		int count = 0;
		try {
			AgentReasonDao agentreasondao = new AgentReasonDao();
			count = agentreasondao.Insert_agentreason(agentreason);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * Select_activitydata
	 * 
	 * @param Select_activitydata
	 */
	public List<Activitydata> Select_activitydata(Activitydata activitydata) {

		List<Activitydata> activitydatalist = new ArrayList<Activitydata>();
		try {
			ActivitydataDao activitydatadao = new ActivitydataDao();
			activitydatalist = activitydatadao
					.Select_activitydata(activitydata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return activitydatalist;
	}

	/**
	 * 
	 * Select_activitygroups
	 * 
	 * @param Select_activitygroups
	 */
	public List<Activitygroups> Select_activitygroups(
			Activitygroups activitygroups) {

		List<Activitygroups> activitygroupslist = new ArrayList<Activitygroups>();
		try {
			ActivitygroupsDao activitygroupsdao = new ActivitygroupsDao();
			activitygroupslist = activitygroupsdao
					.Select_activitygroups(activitygroups);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return activitygroupslist;

	}

	/**
	 * 
	 * Select_activitymenu
	 * 
	 * @param Select_activitymenu
	 */
	public List<Activitymenu> Select_activitymenu(Activitymenu activitymenu) {

		List<Activitymenu> activitymenulist = new ArrayList<Activitymenu>();
		try {
			ActivitymenuDao activitymenudao = new ActivitymenuDao();
			activitymenulist = activitymenudao
					.Select_activitymenu(activitymenu);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return activitymenulist;
	}
	
	
	/**
	 * 
	 * LogicDelete_agentstatus
	 * 
	 * @param agentstatus
	 */
	public int LogicDelete_agentreason(Cfg_AgentReason agentreason) {
		int count = 0;
		try {
			AgentReasonDao agentreasondaodao = new AgentReasonDao();
			count = agentreasondaodao.LogicDelete_agentreason(agentreason);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * update
	 * 
	 * @param agentstatus
	 */
	public int Update_agentreason(Cfg_AgentReason agentreason) {
		int count = 0;
		try {
			AgentReasonDao agentreasondaodao = new AgentReasonDao();
			count = agentreasondaodao.Update_agentreason(agentreason);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * Delete
	 * 
	 * @param commonlink
	 */
	public int Delete_commonlink(CommonLink commonlink) {
		int count = 0;
		try {
			CommonlinkDao commonlinkdaodao = new CommonlinkDao();
			count = commonlinkdaodao.Delete_commonlink(commonlink);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * update
	 * 
	 * @param commonlink
	 */
	public int Update_commonlink(CommonLink commonlink) {
		int count = 0;
		try {
			CommonlinkDao commonlinkdaodao = new CommonlinkDao();
			count = commonlinkdaodao.Update_commonlink(commonlink);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_commonlink
	 */

	public int Insert_commonlink(CommonLink commonlink) {
		int count = 0;
		try {
			CommonlinkDao commonlinkdao = new CommonlinkDao();
			count = commonlinkdao.Insert_commonlink(commonlink);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * Selcet_interaction
	 * 
	 * @param Selcet_interaction
	 */
	public List<Interaction> Selcet_Detail_interaction(Interaction interaction) {

		List<Interaction> interactionlist = new ArrayList<Interaction>();
		try {
			InteractionDao interactiondao = new InteractionDao();
			interactionlist = interactiondao.Selcet_Detail_interaction(interaction);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return interactionlist;

	}
	
	
	/**
	 * 
	 * Selcet_interaction
	 * 
	 * @param Selcet_interaction
	 */
	public List<Interaction> Selcet_interaction(Interaction interaction) {

		List<Interaction> interactionlist = new ArrayList<Interaction>();
		try {
			InteractionDao interactiondao = new InteractionDao();
			interactionlist = interactiondao.Selcet_interaction(interaction);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return interactionlist;

	}

	/**
	 * 
	 * Select_agentstatus
	 * 
	 * @param Select_agentstatus
	 */
	public List<Cfg_AgentReason> Select_agentreason(Cfg_AgentReason agentreason) {

		List<Cfg_AgentReason> agentreasonlist = new ArrayList<Cfg_AgentReason>();
		try {
			AgentReasonDao agentreasondao = new AgentReasonDao();
			agentreasonlist = agentreasondao.Select_agentreason(agentreason);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return agentreasonlist;

	}

	/**
	 * 
	 * SelcetAll_interaction
	 * 
	 * @param Selcet_interaction
	 */
	public List<Interaction> SelcetAll_interaction(Interaction interaction) {

		List<Interaction> interactionlist = new ArrayList<Interaction>();
		try {
			InteractionDao interactiondao = new InteractionDao();
			interactionlist = interactiondao.SelcetAll_interaction(interaction);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return interactionlist;

	}

	/**
	 * 
	 * Select_commonlink
	 * 
	 * @param Select_commonlink
	 */
	public List<CommonLink> Select_commonlink(CommonLink commonlink) {

		List<CommonLink> commonlinklist = new ArrayList<CommonLink>();
		try {
			CommonlinkDao commonlinkdao = new CommonlinkDao();
			commonlinklist = commonlinkdao.Select_commonlink(commonlink);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return commonlinklist;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param ServiceEntry
	 */

	public int insert_ServiceEntry(ServiceEntry serviceentry) {
		Util.getConsoleLogger().debug("insert_ServiceEntry() called");
		Util.getFileLogger().info("insert_ServiceEntry() called");
		int count = 0;
		try {
			ServiceEntryDao serviceentrydao = new ServiceEntryDao();
			count = serviceentrydao.insert_ServiceEntry(serviceentry);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * select
	 * 
	 * @param ContactData
	 */

	public String select_ContactData(ContactData contactdata) {
		String contactID = null;
		try {
			ContactDataDao contactdatadao = new ContactDataDao();
			contactID = contactdatadao.query_ContactData(contactdata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return contactID;
	}

	/**
	 * 
	 * Insert
	 * 
	 * @param ContactData
	 */

	public int insert_ContactData(ContactData contactdata) {
		int count = 0;
		try {
			ContactDataDao contactdatadao = new ContactDataDao();
			count = contactdatadao.insert_ContactData(contactdata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * update
	 * 
	 * @param ContactData
	 */

	public int update_ContactData(ContactData contactdata) {
		int count = 0;
		try {
			ContactDataDao contactdatadao = new ContactDataDao();
			count = contactdatadao.update_ContactData(contactdata);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Interaction
	 */

	public int insert_Interaction(Interaction interaction) {
		int count = 0;
		try {
			InteractionDao interactiondao = new InteractionDao();
			count = interactiondao.insert_Interaction(interaction);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * select
	 * 
	 * @param Cfg_ServiceName_Setting
	 */

	public List<Cfg_ServiceName_Setting> select_Cfg_ServiceName_Setting(
			Cfg_ServiceName_Setting cfg_servicename_setting) {
		List<Cfg_ServiceName_Setting> cfg_servicename_settinglist = null;
		try {
			Cfg_ServiceName_SettingDao cfg_servicename_settingdao = new Cfg_ServiceName_SettingDao();
			cfg_servicename_settinglist = cfg_servicename_settingdao
					.query_Cfg_ServiceName_Setting(cfg_servicename_setting);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return cfg_servicename_settinglist;
	}
	
	
	/**
	 * 
	 * Select
	 * 
	 * @param Select_rpt_agentstatus_usetime
	 */

	public int Select_rpt_agentstatus_usetime(Rpt_AgentStatus agentstatus) {
		int second = 0;
		try {
			Rpt_AgentStatusDao agentstatusdao = new Rpt_AgentStatusDao();
			second = agentstatusdao.Select_agentstatus_usetime(agentstatus);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return second;
	}
	
	/**
	 * 
	 * Select
	 * 
	 * @param Select_rpt_agentstatus_usetime
	 */

	public int Select_rpt_agentstatus_usetime_avg(Rpt_AgentStatus agentstatus) {
		int second = 0;
		try {
			Rpt_AgentStatusDao agentstatusdao = new Rpt_AgentStatusDao();
			second = agentstatusdao.Select_agentstatus_usetime_avg(agentstatus);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return second;
	}

	/**
	 * 
	 * insert
	 * 
	 * @param Insert_rpt_agentstatus
	 */

	public int Insert_rpt_agentstatus(Rpt_AgentStatus agentstatus) {
		int count = 0;
		try {
			Rpt_AgentStatusDao agentstatusdao = new Rpt_AgentStatusDao();
			count = agentstatusdao.Insert_agentstatus(agentstatus);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}

	/**
	 * 
	 * update
	 * 
	 * @param rpt_agentstatus
	 */
	public int Update_rpt_agentstatus(Rpt_AgentStatus agentstatus) {
		int count = 0;
		try {
			Rpt_AgentStatusDao agentstatusdao = new Rpt_AgentStatusDao();
			count = agentstatusdao.Update_agentstatus(agentstatus);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
			e.printStackTrace();
			Util.getFileLogger().error(e.getMessage());
		}
		return count;
	}
	
	/**
	  * 
	  * Select_agentstatus
	  * @param Select_cfg_agentstatus
	  */
	 public List<Cfg_AgentStatus> Select_cfg_agentstatus(Cfg_AgentStatus agentstatus) {
	  
	   List<Cfg_AgentStatus> agentstatuslist = new ArrayList<Cfg_AgentStatus>();
	   try {
	    Cfg_AgentStatusDao agentstatusdao = new Cfg_AgentStatusDao();
	    agentstatuslist = agentstatusdao.Select_agentstatus(agentstatus);
	   } catch (Exception e) {
	    IsError.GET_EXCEPTION = e.getMessage();
	    e.printStackTrace();
		Util.getFileLogger().error(e.getMessage());
	   }
	   return agentstatuslist;
	 
	 }
	 
	 /**
		 * 
		 * insert
		 * 
		 * @param Insert_rpt_activitylog
		 */

		public int Insert_rpt_activitylog(Rpt_Activitylog activitylog) {
			int count = 0;
			try {
				Rpt_ActivitylogDao activitylogdao = new Rpt_ActivitylogDao();
				count = activitylogdao.Insert_activitylog(activitylog);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
				e.printStackTrace();
				Util.getFileLogger().error(e.getMessage());
			}
			return count;
		}
		
		/**
		 * 
		 * update
		 * 
		 * @param Interaction comment
		 */

		public int update_Interaction_comment(Interaction interaction) {
			int count = 0;
			try {
				InteractionDao interactiondao = new InteractionDao();
				count = interactiondao.update_Interaction_comment(interaction);
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
				e.printStackTrace();
				Util.getFileLogger().error(e.getMessage());
			}
			return count;
		}	
	
		/**
		 * 
		 * selectAll_SystemCfg
		 * 
		 * @param selectAll_SystemCfg
		 */
		public List<SystemCfg> selectAll_SystemCfg() {

			List<SystemCfg> systemCfglist = new ArrayList<SystemCfg>();
			try {
				SystemCfgDao dao = new SystemCfgDao();
				systemCfglist = dao.selectAll_SystemCfg();
			} catch (Exception e) {
				IsError.GET_EXCEPTION = e.getMessage();
				e.printStackTrace();
				Util.getFileLogger().error(e.getMessage());
			}
			return systemCfglist;
		}	
}