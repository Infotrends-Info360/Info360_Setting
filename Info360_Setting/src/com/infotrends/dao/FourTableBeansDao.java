package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.FourTableBeans;
import com.infotrends.bean.FourTableBeans;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;
import com.infotrends.util.Util;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class FourTableBeansDao {
	

	
	public List<FourTableBeans> Selcet_fourTableBeans(FourTableBeans fourtablebeans){
		List<FourTableBeans> fourTableBeansList = new ArrayList<FourTableBeans>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			fourTableBeansList = sqlSession.selectList("FourTableBeans.Selcet_FourTableBeans", fourtablebeans);
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
		return fourTableBeansList;
	}
	
}
