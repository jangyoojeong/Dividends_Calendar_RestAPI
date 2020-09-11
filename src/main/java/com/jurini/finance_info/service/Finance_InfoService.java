package com.jurini.finance_info.service;

import java.sql.SQLException;
import java.util.List;

import com.jurini.finance_info.vo.Finance_InfoVO;

public interface Finance_InfoService {

	public Finance_InfoVO Finance_InfoOneData(String symbol) throws ClassNotFoundException, SQLException;
	
	public List<Finance_InfoVO> Finance_InfoList() throws ClassNotFoundException, SQLException;
	
	public List<String> Payment_Alarm_FinanceList(String date) throws ClassNotFoundException, SQLException;
	
	public List<String> Dividends_Alarm_FinanceList(String date) throws ClassNotFoundException, SQLException;
	
	public List<Finance_InfoVO> Dividends_King_List () throws ClassNotFoundException, SQLException;
	
	public List<Finance_InfoVO> Dividends_Aristocrat_List () throws ClassNotFoundException, SQLException;
	
	public List<Finance_InfoVO> Dividends_Monthly_List (String date) throws ClassNotFoundException, SQLException;
}
