package com.infotrends.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class CFG_permission implements Serializable {
	
	private long dbid;
	private long role_dbid;
	private String function_dbid;
	private String createdatetime;
	private  int createuserid;
	private List<String> cfg_BE_RoleFunctionList = new ArrayList<String>();
	

	
	public List<String> getCfg_BE_RoleFunctionList() {
		return cfg_BE_RoleFunctionList;
	}
	public void setCfg_BE_RoleFunctionList(List<String> cfg_BE_RoleFunctionList) {
		this.cfg_BE_RoleFunctionList = cfg_BE_RoleFunctionList;
	}
	public long getDbid() {
		return dbid;
	}
	public void setDbid(long dbid) {
		this.dbid = dbid;
	}
	public long getRole_dbid() {
		return role_dbid;
	}
	public void setRole_dbid(long role_dbid) {
		this.role_dbid = role_dbid;
	}
	public String getFunction_dbid() {
		return function_dbid;
	}
	public void setFunction_dbid(String function_dbid) {
		this.function_dbid = function_dbid;
	}
	public String getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(String createdatetime) {
		this.createdatetime = createdatetime;
	}
	public int getCreateuserid() {
		return createuserid;
	}
	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}
			     
	
}
