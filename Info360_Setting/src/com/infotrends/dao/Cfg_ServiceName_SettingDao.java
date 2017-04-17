package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.infotrends.bean.Cfg_ServiceName_Setting;
import com.infotrends.bean.ServiceEntry;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;
import com.infotrends.util.Util;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class Cfg_ServiceName_SettingDao {
	
	/**
	 * 查詢個人資訊或所有資訊
	 * Account Query
	 * @param Cfg_ServiceName_Setting
	 */
	public List<Cfg_ServiceName_Setting> query_Cfg_ServiceName_Setting(Cfg_ServiceName_Setting   cfg_servicename_setting){
		List<Cfg_ServiceName_Setting> cfg_servicename_settinglist = new ArrayList<Cfg_ServiceName_Setting>();
		//int serviceentryInt = 0;
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			cfg_servicename_settinglist = sqlSession.selectList("cfg_servicename_setting.Query_Cfg_ServiceName_SettingInfo", cfg_servicename_setting);
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
		return cfg_servicename_settinglist;
	}
	
}
