package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.Util;

import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.PersonTableBeans;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class PersonTableBeansDao {

	public List<PersonTableBeans> Query_PersonTableBeans_STATE(PersonTableBeans persontablebeans){
		List<PersonTableBeans> persontablebeansList = new ArrayList<PersonTableBeans>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			persontablebeansList = sqlSession.selectList("PersonTableBeans.Query_PersonTableBeans_STATE", persontablebeans);
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
		return persontablebeansList;
	}
	
}
