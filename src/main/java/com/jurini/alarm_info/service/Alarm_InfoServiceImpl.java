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
	public List<Alarm_InfoVO> Alarm_InfoList(String date) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.Alarm_InfoList(date);
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
	public List<String> Push_List(String symbol) {
		// TODO Auto-generated method stub
		return alarm_InfoDAO.Push_List(symbol);
	}

}
