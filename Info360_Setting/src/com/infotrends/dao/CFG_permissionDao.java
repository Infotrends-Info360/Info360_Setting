package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_permission;

import com.infotrends.db.DBAccess_old;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_permissionDao {
	
	/**
	 * "Select_permission_roleFunction"
	 * @param "Select_permission_roleFunction"
	 */
	public List<CFG_permission> Select_permission_roleFunction(CFG_permission cfg_permission){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_permission> cfg_permissionList = new ArrayList<CFG_permission>();
		SqlSession sqlSession = null;
		try {
			
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_permissionList = sqlSession.selectList("cfg_permission.Select_permission_roleFunction", cfg_permission);
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
		return cfg_permissionList;
	}
	
	
	/**
	 * Select_permission_dbid
	 * @param Select_permission_dbid
	 */
	public List<CFG_permission> Select_permission_roledbid(CFG_permission cfg_permission){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_permission> cfg_permissionList = new ArrayList<CFG_permission>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_permissionList = sqlSession.selectList("cfg_permission.Select_permission_roledbid", cfg_permission);
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
		return cfg_permissionList;
	}
	
	/**
	 * Insert_Permission_Info
	 * @param Insert_Permission_Info
	 */
	public int Insert_Permission_Info(
			CFG_permission   cfg_permission)
			{
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_permissionInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_permissionInt = sqlSession.insert("cfg_permission.Insert_Permission_Info", cfg_permission);
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
		return cfg_permissionInt;
	}
	
	/**
	 * 更新個人資訊
	 * @param Update_Permission_Info
	 */
	public int Update_Permission_Info(
			CFG_permission   cfg_permission){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_permissionInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_permissionInt = sqlSession.insert("cfg_permission.Update_Permission_Info", cfg_permission);
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
		return cfg_permissionInt;
	}
	
	/**
	 * 刪除個人資訊
	 * @param CFG_Permission
	 */
	public int Delete_Permission_Info(CFG_permission   cfg_permission){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_permissionInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_permissionInt = sqlSession.delete("cfg_permission.Delete_Permission_Info", cfg_permission);
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
		return cfg_permissionInt;
	}
	
}
