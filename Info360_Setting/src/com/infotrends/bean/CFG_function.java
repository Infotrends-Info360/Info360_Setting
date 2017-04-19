package com.infotrends.bean;

import java.util.ArrayList;
import java.util.List;

public class CFG_function {
	private long dbid;
	private String code;
	private String name;
	private String programpath;
	private int state;
	private int catalogid;
	private int arraynumber;
	private String permimg;
	private int parentid;
	
	
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	private List<String> cfg_BE_FunctionList = new ArrayList<String>();
	
	public List<String> getCfg_BE_FunctionList() {
		return cfg_BE_FunctionList;
	}
	public void setCfg_BE_FunctionList(List<String> cfg_BE_FunctionList) {
		this.cfg_BE_FunctionList = cfg_BE_FunctionList;
	}
	public String getPermimg() {
		return permimg;
	}
	public void setPermimg(String permimg) {
		this.permimg = permimg;
	}
	public long getDbid() {
		return dbid;
	}
	public void setDbid(long dbid) {
		this.dbid = dbid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgrampath() {
		return programpath;
	}
	public void setProgrampath(String programpath) {
		this.programpath = programpath;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	public int getArraynumber() {
		return arraynumber;
	}
	public void setArraynumber(int arraynumber) {
		this.arraynumber = arraynumber;
	}

}
