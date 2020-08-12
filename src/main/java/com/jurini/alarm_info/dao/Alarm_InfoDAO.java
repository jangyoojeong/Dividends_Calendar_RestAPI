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
	
	public List<Alarm_InfoVO> Alarm_InfoList (String date){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.Alarm_InfoList", date);
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
	
	public List<String> Push_List(String symbol){
		return SqlSession.selectList("mybatis.sql.alarm_info_mapper.Push_List", symbol);
	}
}
