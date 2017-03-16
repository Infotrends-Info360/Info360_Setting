package com.infotrends.bean;

import java.util.ArrayList;
import java.util.List;


public class CFG_role_member {

	private long role_dbid;
	private long group_dbid;
	
	private List<Integer> rolemember_DBID_list = new ArrayList<Integer>();

	
	public List<Integer> getRolemember_DBID_list() {
		return rolemember_DBID_list;
	}
	public void setRolemember_DBID_list(List<Integer> rolemember_DBID_list) {
		this.rolemember_DBID_list = rolemember_DBID_list;
	}
	public long getRole_dbid() {
		return role_dbid;
	}
	public void setRole_dbid(long role_dbid) {
		this.role_dbid = role_dbid;
	}
	public long getGroup_dbid() {
		return group_dbid;
	}
	public void setGroup_dbid(long group_dbid) {
		this.group_dbid = group_dbid;
	}
	

}
