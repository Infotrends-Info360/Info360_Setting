package com.infotrends.bean;

public class FourTableBeans {

//interaction	
	private String contactid;
	
	private String ixnid;
	
	private String agentid;

	private String Startdate;
	
	private String Enddate;

	private String src;

	private String Thecomment;
	
//person
	private String Agentname;
		
//activitylog
	private String activitylog_interactionid;
	
	private String activitylog_activitydataid;
		
//activitydata
	private String Codename;
	
	


	
	public String getThecomment() {
		return Thecomment;
	}

	public void setThecomment(String thecomment) {
		Thecomment = thecomment;
	}

	public String getStartdate() {
		return Startdate;
	}

	public void setStartdate(String startdate) {
		Startdate = startdate;
	}

	public String getEnddate() {
		return Enddate;
	}

	public void setEnddate(String enddate) {
		Enddate = enddate;
	}

	public String getContactid() {
		return contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}


	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getIxnid() {
		return ixnid;
	}

	public void setIxnid(String ixnid) {
		this.ixnid = ixnid;
	}

	public String getAgentname() {
		return Agentname;
	}

	public void setAgentname(String agentname) {
		Agentname = agentname;
	}

	public String getActivitylog_interactionid() {
		return activitylog_interactionid;
	}

	public void setActivitylog_interactionid(String activitylog_interactionid) {
		this.activitylog_interactionid = activitylog_interactionid;
	}

	public String getActivitylog_activitydataid() {
		return activitylog_activitydataid;
	}

	public void setActivitylog_activitydataid(String activitylog_activitydataid) {
		this.activitylog_activitydataid = activitylog_activitydataid;
	}

	public String getCodename() {
		return Codename;
	}

	public void setCodename(String codename) {
		Codename = codename;
	}
	
}
