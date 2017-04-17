package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.Util;

import com.infotrends.bean.Cfg_AgentStatus;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;


public class Cfg_AgentStatusDao {
	
	/**
	 * 
	 * Select
	 * @param agentstatus
	 */
	public List<Cfg_AgentStatus> Select_agentstatus(Cfg_AgentStatus agentstatus){
		List<Cfg_AgentStatus> agentstatuslist = new ArrayList<Cfg_AgentStatus>();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			agentstatuslist = sqlSession.selectList("cfg_agentstatus.Select_agentstatus", agentstatus);
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
		return agentstatuslist;
	}
	
}
