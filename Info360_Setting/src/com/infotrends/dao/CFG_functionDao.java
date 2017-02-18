package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_permission;
import com.infotrends.bean.CFG_person;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_functionDao {

	
	/**
	 * "Select_BE_FunctionPermission"
	 * @param "Select_BE_FunctionPermission"
	 */
	public List<CFG_function> Select_BE_FunctionPermission(CFG_function cfg_function){
		DBAccess dbAccess = new DBAccess();
		List<CFG_function> cfg_functionList = new ArrayList<CFG_function>();
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_functionList = sqlSession.selectList("cfg_function.Select_BE_FunctionPermission", cfg_function);
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
		return cfg_functionList;
	}
	
	
	/**
	 * 查詢
	 * DBID 
	 * @param CFG_function
	 */
	public List<CFG_function> select_function_dbid(CFG_function cfg_function){
		DBAccess dbAccess = new DBAccess();
		List<CFG_function> cfg_functionList = new ArrayList<CFG_function>();
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_functionList = sqlSession.selectList("cfg_function.select_function_dbid", cfg_function);
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
		return cfg_functionList;
	}
	
	
	/**
	 * 新增註冊個人資訊
	 * @param CFG_function
	 */
	public int Insert_Function(
			CFG_function   cfg_function)
			{
		DBAccess dbAccess = new DBAccess();
		int cfg_functionInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_functionInt = sqlSession.insert("cfg_function.Insert_Function", cfg_function);
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
		return cfg_functionInt;
	}
	
	
	/**
	 * 更新個人資訊
	 * @param CFG_function
	 */
	public int Update_FunctionInfo(
			CFG_function   cfg_function	){
		DBAccess dbAccess = new DBAccess();
		int cfg_functionInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_functionInt = sqlSession.insert("cfg_function.Update_FunctionInfo", cfg_function);
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
		return cfg_functionInt;
	}
	
	/**
	 * 刪除個人資訊
	 * @param CFG_function
	 */
	public int Delete_FunctionInfo(CFG_function   cfg_function){
		DBAccess dbAccess = new DBAccess();
		int cfg_functionInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_functionInt = sqlSession.delete("cfg_function.Delete_FunctionInfo", cfg_function);
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
		return cfg_functionInt;
	}
	
}
