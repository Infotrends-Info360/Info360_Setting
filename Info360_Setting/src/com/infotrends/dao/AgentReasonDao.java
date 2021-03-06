package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.Cfg_AgentReason;
import com.infotrends.bean.CommonLink;
import com.infotrends.bean.ContactData;
import com.infotrends.bean.Interaction;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;
import com.infotrends.util.Util;


public class AgentReasonDao {
	/**
	 * @param Delete_agentreason
	 */
	public int Delete_agentreason(
			Cfg_AgentReason   agentreason)
			{
		int agentreasonInt = 0;
		SqlSession sqlSession = null;

       try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentreasonInt = sqlSession.delete("agentreason.Delete_agentreason", agentreason);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} finally {
			if(sqlSession != null){
				sqlSession.close();
				DBAccess.sessonCount.decrementAndGet();
				Util.getFileLogger().debug("DB session count: " + DBAccess.sessonCount.get());
			}
		}
		return agentreasonInt;
	}
	
	/**
	 * 
	 * Insert
	 * @param Insert_agentreason
	 */
	public int Insert_agentreason(Cfg_AgentReason   agentreason){
		int agentreasonInt = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentreasonInt = sqlSession.insert("agentreason.Insert_agentreason", agentreason);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} finally {
			if(sqlSession != null){
			   sqlSession.close();
				DBAccess.sessonCount.decrementAndGet();
				Util.getFileLogger().debug("DB session count: " + DBAccess.sessonCount.get());
			}
		}
		return agentreasonInt;
	}

	/**
	 * Select_agentreason
	 * @param Select_agentreason
	 */
	public List<Cfg_AgentReason> Select_agentreason(Cfg_AgentReason agentreason){
		List<Cfg_AgentReason> agentreasonlist = new ArrayList<Cfg_AgentReason>();
		SqlSession sqlSession = null;
	
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentreasonlist = sqlSession.selectList("agentreason.Select_agentreason", agentreason);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} finally {
			if(sqlSession != null){
			   sqlSession.close();
				DBAccess.sessonCount.decrementAndGet();
				Util.getFileLogger().debug("DB session count: " + DBAccess.sessonCount.get());
			}
		}
		return agentreasonlist;
	}

	/**
	 * 更新個人資訊
	 * @param Update_agentreason
	 */
	public int Update_agentreason(
			Cfg_AgentReason   agentreason	){
		int agentreasonInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentreasonInt = sqlSession.update("agentreason.Update_agentreason", agentreason);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} finally {
			if(sqlSession != null){
				sqlSession.close();
				DBAccess.sessonCount.decrementAndGet();
				Util.getFileLogger().debug("DB session count: " + DBAccess.sessonCount.get());
			}
		}
		return agentreasonInt;
	}
	
	/**
	 * LogicDelete_agentreason
	 * @param LogicDelete_agentreason
	 */
	public int LogicDelete_agentreason(
			Cfg_AgentReason   agentreason	){
		int agentreasonInt = 0;
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentreasonInt = sqlSession.update("agentreason.LogicDelete_agentreason", agentreason);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			IsError.GET_EXCEPTION = e.getMessage();
			Util.getFileLogger().error(e.getMessage());
		} finally {
			if(sqlSession != null){
				sqlSession.close();
				DBAccess.sessonCount.decrementAndGet();
				Util.getFileLogger().debug("DB session count: " + DBAccess.sessonCount.get());
			}
		}
		return agentreasonInt;
	}
}
