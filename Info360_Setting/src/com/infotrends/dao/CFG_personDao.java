package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_person;
import com.infotrends.db.DBAccess_old;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_personDao {
	
	/**
	 * Logic_Delete
	 * @param CFG_person
	 */
	public int Logic_Delete(
			CFG_person   cfg_person	){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.update("cfg_person.Logic_Delete", cfg_person);
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
	
	/**
	 * 更新login_ErrorCount
	 * @param CFG_person
	 */
	public int login_ErrorCount(
			CFG_person   cfg_person	){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.insert("cfg_person.login_ErrorCount", cfg_person);
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
	
	
	/**
	 * Person_login
	 * @param CFG_person
	 */
	public List<CFG_person> Login_PersonInfo(CFG_person cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Login_PersonInfo", cfg_person);
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
	
	
	public List<CFG_person> Ppermission(CFG_person cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Ppermission", cfg_person);
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
	 * 查詢個人資訊或所有資訊
	 * Account Query
	 * @param CFG_person
	 */
	public List<CFG_person> query_Person_Account(CFG_person   cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Query_PersonInfo_Account", cfg_person);
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
	 * 查詢個人資訊或所有資訊
	 * DBID Query
	 * @param CFG_person
	 */
	public List<CFG_person> query_Person_DBID(CFG_person   cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Query_PersonInfo_DBID", cfg_person);
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
	 * 查詢個人資訊或所有資訊
	 * STATE Query
	 * @param CFG_person
	 */
	public List<CFG_person> Query_PersonInfo_STATE(CFG_person   cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_person> cfg_personList = new ArrayList<CFG_person>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personList = sqlSession.selectList("cfg_person.Query_PersonInfo_STATE", cfg_person);
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
	 * 新增註冊個人資訊
	 * @param CFG_person
	 */
	public int Insert_PersonInfo(
			CFG_person   cfg_person)
			{
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

       try {
    	 
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_personInt = sqlSession.insert("cfg_person.Insert_PersonInfo", cfg_person);
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
	

	/**
	 * 更新個人資訊
	 * @param CFG_person
	 */
	public int update_PersonInfo(
			CFG_person   cfg_person	){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.insert("cfg_person.Update_PersonInfo", cfg_person);
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
	
	/**
	 * 刪除個人資訊
	 * @param CFG_person
	 */
	public int delete(CFG_person   cfg_person){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_personInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_personInt = sqlSession.delete("cfg_person.Delete_PersonInfo", cfg_person);
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
