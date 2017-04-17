package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.Util;

import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.GroupTableBeans;
import com.infotrends.bean.PersonTableBeans;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class GroupTableBeansDao {

	public List<GroupTableBeans> Query_GroupTableBeans_STATE(GroupTableBeans grouptablebeans){
		List<GroupTableBeans> grouptablebeansList = new ArrayList<GroupTableBeans>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			grouptablebeansList = sqlSession.selectList("GroupTableBeans.Query_GroupTableBeans_STATE", grouptablebeans);
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
		return grouptablebeansList;
	}
	
}
