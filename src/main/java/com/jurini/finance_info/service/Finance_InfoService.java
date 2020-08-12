package com.jurini.finance_info.service;

import java.sql.SQLException;
import java.util.List;

import com.jurini.finance_info.vo.Finance_InfoVO;

public interface Finance_InfoService {

	public Finance_InfoVO Finance_InfoOneData(Finance_InfoVO vo1) throws ClassNotFoundException, SQLException;
	
	public List<Finance_InfoVO> Finance_InfoList() throws ClassNotFoundException, SQLException;
	
	public List<String> Alarm_FinanceList(String date) throws ClassNotFoundException, SQLException;
}
