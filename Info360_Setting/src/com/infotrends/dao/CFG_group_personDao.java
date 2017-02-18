package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_permission;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

public class CFG_group_personDao {
	
	
	/**
	 * "Select_BE_GroupPerson"
	 * @param "Select_BE_GroupPerson"
	 */
	public List<CFG_group_person> Select_BE_GroupPerson(CFG_group_person cfg_group_person){
		DBAccess dbAccess = new DBAccess();
		List<CFG_group_person> cfg_group_personList = new ArrayList<CFG_group_person>();
		SqlSession sqlSession = null;
		try {
			
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_group_personList = sqlSession.selectList("cfg_group_person.Select_BE_GroupPerson", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
			   sqlSession.close();
			}
		}
		return cfg_group_personList;
	}
	
	
	
	
	/**
	 * 新增個人所屬群組資訊
	 * @param CFG_group_person
	 */
	public int insert_Group_PersonInfo(
			CFG_group_person   cfg_group_person)
			{
		DBAccess dbAccess = new DBAccess();
		int cfg_Int = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_Int = sqlSession.insert("cfg_group_person.Insert_Group_PersonInfo", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_Int;
	}
	
	
	/**
	 * 查詢個人所屬群組資訊
	 * @param CFG_group_person
	 */
	
	
	public List<CFG_group_person> query_Group_PersonInfo(CFG_group_person   cfg_group_person){
		DBAccess dbAccess = new DBAccess();
		List<CFG_group_person> cfg_personList = new ArrayList<CFG_group_person>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_group_person.Query_Group_PersonInfo", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
			   sqlSession.close();
			}
		}
		return cfg_personList;
	}
	
	
	
	/**
	 * 個人所屬群組資訊
	 * @param CFG_group_person
	 */
	
	public int update_Group_PersonInfo(
			CFG_group_person   cfg_group_person	){
		DBAccess dbAccess = new DBAccess();
		int cfg_group_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_group_personInt = sqlSession.insert("cfg_group_person.Update_Group_PersonInfo", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_group_personInt;
	}
	
	/**
	 * 個人所屬群組資訊
	 * @param CFG_group_person
	 */
	
	public int update_Person_GroupInfo(
			CFG_group_person   cfg_group_person	){
		DBAccess dbAccess = new DBAccess();
		int cfg_group_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_group_personInt = sqlSession.insert("cfg_group_person.Update_Person_GroupInfo", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_group_personInt;
	}
	
	
	/**
	 * 刪除個人資訊
	 * @param CFG_person
	 */
	
	public int delete(CFG_group_person   cfg_group_person){
		DBAccess dbAccess = new DBAccess();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.delete("cfg_group_person.Delete_Group_PersonInfo", cfg_group_person);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return cfg_personInt;
	}
}
