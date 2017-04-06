package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.Util;

import com.infotrends.bean.Cfg_ServiceName_Mapping;
import com.infotrends.bean.Cfg_ServiceName_Setting;
import com.infotrends.bean.ServiceEntry;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class Cfg_ServiceName_MappingDao {
	
	/**
	 * 查詢個人資訊或所有資訊
	 * Account Query
	 * @param Cfg_ServiceName_Setting
	 */
	public List<Cfg_ServiceName_Mapping> Query_Cfg_ServiceName_MappingInfo(Cfg_ServiceName_Mapping   cfg_servicename_mapping){
		List<Cfg_ServiceName_Mapping> cfg_servicename_mappinglist = new ArrayList<Cfg_ServiceName_Mapping>();
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_servicename_mappinglist = sqlSession.selectList("cfg_servicename_mapping.Query_Cfg_ServiceName_MappingInfo", cfg_servicename_mapping);
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
		return cfg_servicename_mappinglist;
	}
	
}
