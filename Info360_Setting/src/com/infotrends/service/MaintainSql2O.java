package com.infotrends.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.infotrends.bean.CFG_person;
import com.infotrends.dao.Sql2OPersonTest;
import com.infotrends.util.IsError;

public class MaintainSql2O {

	/**
	 * Select個人或全體資料的業務邏輯 Account Query
	 * 
	 * @param cfg_person
	 */

	public List<CFG_person> query_Person_Json(CFG_person cfg_person) {
		List<CFG_person> cfg_personlist = new ArrayList<CFG_person>();
		try {
			Sql2OPersonTest Sql2OPersonTest = new Sql2OPersonTest();
			cfg_personlist = Sql2OPersonTest.query_Person_Json(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return cfg_personlist;
	}
	
	/**
	 * Select個人或全體資料的業務邏輯 Account Query
	 * 
	 * @param cfg_person
	 */

	public JsonArray query_Person_Gson(CFG_person cfg_person) {
		JsonArray cfg_personJsonArray = null;
		try {
			Sql2OPersonTest Sql2OPersonTest = new Sql2OPersonTest();
			cfg_personJsonArray = Sql2OPersonTest.query_Person_Gson(cfg_person);
		} catch (Exception e) {
			IsError.GET_EXCEPTION = e.getMessage();
		}
		return cfg_personJsonArray;
	}
}
