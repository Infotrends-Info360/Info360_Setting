package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.CFG_function;
import com.infotrends.bean.CFG_group_person;
import com.infotrends.bean.CFG_person;
import com.infotrends.bean.CFG_role_member;
import com.infotrends.db.DBAccess_old;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class CFG_role_memberDao {
	
	/**
	 * Select_Rolemember_Roledbid
	 * @param Select_Rolemember_Roledbid
	 */
	public List<CFG_role_member> Select_Rolemember_Roledbid(CFG_role_member cfg_role_member){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_role_member> cfg_role_memberList = new ArrayList<CFG_role_member>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_role_memberList = sqlSession.selectList("cfg_role_member.Select_Rolemember_Roledbid", cfg_role_member);
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
		return cfg_role_memberList;
	}
	
	
	/**
	 * Select_Rolemember_Groupdbid
	 * @param Select_Rolemember_Groupdbid
	 */
	public List<CFG_role_member> Select_Rolemember_Groupdbid(CFG_role_member cfg_role_member){
		DBAccess_old dbAccess = new DBAccess_old();
		List<CFG_role_member> cfg_role_memberList = new ArrayList<CFG_role_member>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_role_memberList = sqlSession.selectList("cfg_role_member.Select_Rolemember_Groupdbid", cfg_role_member);
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
		return cfg_role_memberList;
	}
	

	
	
	/**
	 * insert_Role_MemberInfo
	 * @param insert_Role_MemberInfo
	 */
	public int Insert_Role_MemberInfo(
			CFG_role_member   cfg_role_member)
			{
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_role_memberInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			
			cfg_role_memberInt = sqlSession.insert("cfg_role_member.Insert_Role_MemberInfo", cfg_role_member);
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
		return cfg_role_memberInt;
	}
	
	/**
	 * 更新個人資訊
	 * @param CFG_function
	 */
	public int Update_Role_MemberInfo(
			CFG_role_member   cfg_role_member){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_role_memberInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_role_memberInt = sqlSession.insert("cfg_role_member.Update_Role_MemberInfo", cfg_role_member);
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
		return cfg_role_memberInt;
	}
	
	/**
	 * 刪除個人資訊
	 * @param CFG_function
	 */
	public int Delete_Role_MemberInfo(CFG_role_member   cfg_role_member){
		DBAccess_old dbAccess = new DBAccess_old();
		int cfg_role_memberInt = 0;
		SqlSession sqlSession = null;

		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_role_memberInt = sqlSession.delete("cfg_role_member.Delete_Role_MemberInfo", cfg_role_member);
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
		return cfg_role_memberInt;
	}
	
}
