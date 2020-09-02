package com.jurini.alarm_info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jurini.alarm_info.dao.Alarm_InfoDAO;
import com.jurini.alarm_info.vo.Alarm_InfoVO;

@Service("Alarm_InfoService")
public class Alarm_InfoServiceImpl implements Alarm_InfoService {

	@Autowired
    private Alarm_InfoDAO alarm_InfoDAO;
	
	@Override
	public List<Alarm_InfoVO> Alarm_InfoList() {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.Alarm_InfoList();
	}

	@Override
	public int insertAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.insertAlarm_Data(alarm_InfoVO);
	}

	@Override
	public int updateAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.updateAlarm_Data(alarm_InfoVO);
	}

	@Override
	public int deleteAlarm_Data(Alarm_InfoVO alarm_InfoVO) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.deleteAlarm_Data(alarm_InfoVO);
	}

	@Override
	public List<String> monthlyPush_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.monthlyPush_List(symbol);
	}

	@Override
	public List<String> havePaymentPush_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.havePaymentPush_List(symbol);
	}

	@Override
	public List<String> haveDividendsPush_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.haveDividendsPush_List(symbol);
	}

	@Override
	public List<String> likePaymentPush_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.likePaymentPush_List(symbol);
	}

	@Override
	public List<String> likeDividendsPush_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.likeDividendsPush_List(symbol);
	}

}
