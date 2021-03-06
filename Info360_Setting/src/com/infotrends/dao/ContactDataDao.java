package com.infotrends.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;

import com.infotrends.bean.Activitymenu;
import com.infotrends.bean.ContactData;
import com.infotrends.bean.Interaction;
import com.infotrends.bean.ServiceEntry;
import com.infotrends.db.DBAccess;
import com.infotrends.util.IsError;
import com.infotrends.util.Util;

/**
 * 和Message表相關的數據庫操作
 * @author Lin
 */
public class ContactDataDao {
	
	/**
	 * Query_All_Contactdata
	 * @param Query_All_Contactdata
	 */
	public List<ContactData> Query_All_Contactdata(ContactData contactdata){
		List<ContactData> contactdatalist = new ArrayList<ContactData>();
		SqlSession sqlSession = null;
	
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			contactdatalist = sqlSession.selectList("contactdata.Query_All_Contactdata", contactdata);
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
		return contactdatalist;
	}
	
	
	public Map<String, String> Query_Contactdata(String contactid){
		List<Map<String, String>> contactdataList = new ArrayList<Map<String, String>>();
		Map<String, String> contactdatamap = new HashMap<String, String>();
		Object contactdataobject;
		SqlSession sqlSession = null;

		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			contactdataList = sqlSession.selectList("contactdata.Query_Contactdata", contactid);
			for(int i =0 ;i<contactdataList.size();i++){
				contactdatamap = contactdataList.get(i);
			}
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
		return contactdatamap;
	}
	
	
	
	
	/**
	 * 
	 * Query
	 * @param ContactData
	 */
	public String query_ContactData(ContactData   contactdata){
		//List<String> contactdatalist = new ArrayList<String>();
		String contactID = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			contactID = sqlSession.selectOne("contactdata.Query_ContactID",  contactdata);
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
		return contactID;
	}
	
	/**
	 * 
	 * Insert
	 * @param ContactData
	 */
	public int insert_ContactData(ContactData   contactdata){
		//List<ServiceEntry> serviceentrylist = new ArrayList<ServiceEntry>();
		int contactdataInt = 0;
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			contactdataInt = sqlSession.insert("contactdata.Insert_ContactData", contactdata);
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
		return contactdataInt;
	}
	
	/**
	 * 
	 * update
	 * @param ContactData
	 */
	public int update_ContactData(ContactData   contactdata){
		//List<ServiceEntry> serviceentrylist = new ArrayList<ServiceEntry>();
		int contactdataInt = 0;
		SqlSession sqlSession = null;
		
		
		try {
			sqlSession = DBAccess.getSqlSession();
			//通過sqlSession執行SQL語句
			contactdataInt = sqlSession.update("contactdata.Update_ContactData", contactdata);
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
		return contactdataInt;
	}
	
}
