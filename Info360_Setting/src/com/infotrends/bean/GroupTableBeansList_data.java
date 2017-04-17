package com.infotrends.bean;

import java.util.List;

public class GroupTableBeansList_data {

	List<GroupTableBeans> group;
	
	List<CFG_person> ALLperson;
	List<CFG_function> ALLfunction;

	public List<GroupTableBeans> getGroup() {
		return group;
	}

	public void setGroup(List<GroupTableBeans> group) {
		this.group = group;
	}

	public List<CFG_person> getALLperson() {
		return ALLperson;
	}

	public void setALLperson(List<CFG_person> aLLperson) {
		ALLperson = aLLperson;
	}

	public List<CFG_function> getALLfunction() {
		return ALLfunction;
	}

	public void setALLfunction(List<CFG_function> aLLfunction) {
		ALLfunction = aLLfunction;
	}

	
}
