package com.infotrends.bean;

import java.util.ArrayList;
import java.util.List;

public class CFG_group {
	
	private long dbid;
	
	private String name;
	
	private int state;
	
	private List<Integer> groupDBID_list = new ArrayList<Integer>();


	public List<Integer> getGroupDBID_list() {
		return groupDBID_list;
	}

	public void setGroupDBID_list(List<Integer> groupDBID_list) {
		this.groupDBID_list = groupDBID_list;
	}

	public long getDbid() {
		return dbid;
	}

	public void setDbid(long dbid) {
		this.dbid = dbid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	

}
