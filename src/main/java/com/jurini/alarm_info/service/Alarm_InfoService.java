package com.jurini.alarm_info.service;

import java.util.List;

import com.jurini.alarm_info.vo.Alarm_InfoVO;

public interface Alarm_InfoService {
	public List<Alarm_InfoVO> Alarm_InfoList (String client_id);
	
	public int insertAlarm_Data(Alarm_InfoVO alarm_InfoVO);

	public int updateAlarm_Data(Alarm_InfoVO alarm_InfoVO);
	
	public int deleteAlarm_Data(Alarm_InfoVO alarm_InfoVO);
	
	public List<String> monthlyPush_List(String symbol);
	
	public List<String> havePaymentPush_List(String symbol);
	
	public List<String> haveDividendsPush_List(String symbol);
	
	public List<String> likePaymentPush_List(String symbol);
	
	public List<String> likeDividendsPush_List(String symbol);
}
