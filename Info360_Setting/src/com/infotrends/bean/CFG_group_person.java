package com.infotrends.bean;

import java.util.ArrayList;
import java.util.List;

public class CFG_group_person {
	
	private long group_dbid;
	
	private long person_dbid;
	
	private List<String> cfg_BE_GroupPersonList = new ArrayList<String>();

	public List<String> getCfg_BB_GroupPersonList() {
		return cfg_BE_GroupPersonList;
	}

	public void setCfg_BE_GroupPersonList(List<String> cfg_BE_GroupPersonList) {
		this.cfg_BE_GroupPersonList = cfg_BE_GroupPersonList;
	}

	public long getGroup_dbid() {
		return group_dbid;
	}

	public void setGroup_dbid(long group_dbid) {
		this.group_dbid = group_dbid;
	}

	public long getPerson_dbid() {
		return person_dbid;
	}

	public void setPerson_dbid(long person_dbid) {
		this.person_dbid = person_dbid;
	}

	
	

	
}
