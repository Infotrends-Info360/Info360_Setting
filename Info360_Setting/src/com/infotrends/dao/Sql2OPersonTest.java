package com.infotrends.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.infotrends.bean.CFG_person;

public class Sql2OPersonTest {
	
	/**
	 * 查詢個人資訊或所有資訊
	 * DBID Query
	 * @param CFG_person
	 */
	public List<CFG_person> query_Person_Json(CFG_person cfg_person){
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		
		String DB_URL = "jdbc:sqlserver://192.168.10.42:1433;database=HongLin";
		String USER = "sa";
		String PASS = "password";
		
		Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

		String sql = "select DBID,ACCOUNT,PASSWORD from tblCfg_Person"; 
//		    "SELECT id, category, duedate " +
//		    "FROM tasks " +
//		    "WHERE category = :category";
		
		try(Connection con = sql2o.open()) {
			cfg_personList = con.createQuery(sql)
//		        .addParameter("category", "foo")
		        .executeAndFetch(CFG_person.class);
		}
		return cfg_personList;
	}
	
	/**
	 * 查詢個人資訊或所有資訊
	 * DBID Query
	 * @param CFG_person
	 */
	public JsonArray query_Person_Gson(CFG_person cfg_person){
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		
		String DB_URL = "jdbc:sqlserver://192.168.10.42:1433;database=HongLin";
		String USER = "sa";
		String PASS = "password";
		
		Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);

		String sql = "select DBID,ACCOUNT,PASSWORD from tblCfg_Person"; 
//		    "SELECT id, category, duedate " +
//		    "FROM tasks " +
//		    "WHERE category = :category";
		
		try (Connection con = sql2o.open()){
			cfg_personList = con.createQuery(sql)
//			        .addParameter("category", "foo")
			        .executeAndFetch(CFG_person.class);
		}
		
		Gson gson = new Gson();
		
		JsonElement element = gson.toJsonTree(cfg_personList, new TypeToken<List<CFG_person>>() {}.getType());
		
		JsonArray jsonArray = element.getAsJsonArray();
		
		return jsonArray;
	}
}
