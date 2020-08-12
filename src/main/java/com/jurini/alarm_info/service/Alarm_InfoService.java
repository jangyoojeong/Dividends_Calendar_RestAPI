package com.jurini.alarm_info.service;

import java.util.List;

import com.jurini.alarm_info.vo.Alarm_InfoVO;

public interface Alarm_InfoService {
	public List<Alarm_InfoVO> Alarm_InfoList (String date);
	
	public int insertAlarm_Data(Alarm_InfoVO alarm_InfoVO);

	public int updateAlarm_Data(Alarm_InfoVO alarm_InfoVO);
	
	public int deleteAlarm_Data(Alarm_InfoVO alarm_InfoVO);
	
	public List<String> Push_List(String symbol);
}
