package com.jurini.alarm_info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jurini.alarm_info.vo.Alarm_InfoVO;

@Repository
public class Alarm_InfoDAO {

	
	@Autowired
	private SqlSession SqlSession;
	
	public List<Alarm_InfoVO> Alarm_InfoList (String client_id){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.Alarm_InfoList", client_id);
	}
	
	public int insertAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		return SqlSession.insert("mybatis.sql.alarm_info_mapper.insertAlarm_Data", alarm_InfoVO);
	}

	public int updateAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		return SqlSession.update("mybatis.sql.alarm_info_mapper.updateAlarm_Data", alarm_InfoVO);
	}
	
	public int deleteAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		return SqlSession.delete("mybatis.sql.alarm_info_mapper.deleteAlarm_Data", alarm_InfoVO);
	}
	
	public List<String> monthlyPush_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.monthlyPush_List", symbol);
	}
	
	public List<String> havePaymentPush_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.havePaymentPush_List", symbol);
	}
	
	public List<String> haveDividendsPush_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.haveDividendsPush_List", symbol);
	}
	
	public List<String> likePaymentPush_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.likePaymentPush_List", symbol);
	}
	
	public List<String> likeDividendsPush_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.likeDividendsPush_List", symbol);
	}
}
