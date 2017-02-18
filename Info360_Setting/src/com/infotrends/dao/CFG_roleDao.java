package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_role;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_roleDao {
	
	/**
	 * Person_login
	 * @param CFG_person
	 */
	public List<CFG_role> Select_role_dbid(CFG_role cfg_role){
		DBAccess dbAccess = new DBAccess();
		List<CFG_role> cfg_roleList = new ArrayList<CFG_role>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_roleList = sqlSession.selectList("cfg_role.Select_role_dbid", cfg_role);
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
		return cfg_roleList;
	}
	
	
	/**
	 * insert_Role
	 * @param insert
	 */
	public int Insert_Role_Info(
			CFG_role   cfg_role)
			{
		DBAccess dbAccess = new DBAccess();
		int cfg_role_Int = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_role_Int = sqlSession.insert("cfg_role.Insert_Role_Info", cfg_role);
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
		return cfg_role_Int;
	}
	
	/**
	 * 更新個人資訊
	 * @param CFG_role
	 */
	public int Update_Role_Info(
			CFG_role   cfg_role){
		DBAccess dbAccess = new DBAccess();
		int cfg_role_Int = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_role_Int = sqlSession.insert("cfg_role.Update_Role_Info", cfg_role);
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
		return cfg_role_Int;
	}
	
	/**
	 * 刪除個人資訊
	 * @param cfg_role
	 */
	public int Delete_Role_Info(CFG_role   cfg_role){
		DBAccess dbAccess = new DBAccess();
		int cfg_roleInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_roleInt = sqlSession.delete("cfg_role.Delete_Role_Info", cfg_role);
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
		return cfg_roleInt;
	}
}
