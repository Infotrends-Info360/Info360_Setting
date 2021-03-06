package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.Interaction;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;
import com.infotrends.util.Util;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class InteractionDao {
	
	/**
	 * 查詢
	 * Selcet_interaction
	 * @param interaction
	 */
	
	
	public List<Interaction> Selcet_Detail_interaction(Interaction interaction){
		List<Interaction> interactionList = new ArrayList<Interaction>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			interactionList = sqlSession.selectList("interaction.Selcet_Detail_interaction", interaction);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		return interactionList;
	}
	
	
	
	public List<Interaction> Selcet_interaction(Interaction interaction){
		List<Interaction> interactionList = new ArrayList<Interaction>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			interactionList = sqlSession.selectList("interaction.Selcet_interaction", interaction);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		return interactionList;
	}
	/**
	 * 查詢
	 * SelcetAll_interaction
	 * @param interaction
	 */
	public List<Interaction> SelcetAll_interaction(Interaction interaction){
		List<Interaction> interactionList = new ArrayList<Interaction>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			interactionList = sqlSession.selectList("interaction.SelcetAll_interaction", interaction);
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
		return interactionList;
	}
	
	
	
	/**
	 * Account insert
	 * @param insert_Interaction
	 */
	public int insert_Interaction(Interaction   interaction){
		//List<ServiceEntry> serviceentrylist = new ArrayList<ServiceEntry>();
		int interactionInt = 0;
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			interactionInt = sqlSession.insert("interaction.Insert_Interaction", interaction);
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
		return interactionInt;
	}
	
	/**
	 * Account update
	 * @param update_Interaction_comment
	 */
	public int update_Interaction_comment(Interaction   interaction){
		//List<ServiceEntry> serviceentrylist = new ArrayList<ServiceEntry>();
		int interactionInt = 0;
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			interactionInt = sqlSession.update("interaction.Update_Interaction_comment", interaction);
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
		return interactionInt;
	}
	
}
