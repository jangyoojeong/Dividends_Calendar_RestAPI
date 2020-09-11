package com.jurini.finance_info.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jurini.finance_info.dao.Finance_InfoDAO;
import com.jurini.finance_info.vo.Finance_InfoVO;

@Service("Finance_InfoService")
public class Finance_InfoServiceImpl implements Finance_InfoService{

    @Autowired
    private Finance_InfoDAO Finance_InfoDAO;
 

	@Override
	public Finance_InfoVO Finance_InfoOneData(String symbol) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Finance_InfoOneData(symbol);
	}

	@Override
	public List<Finance_InfoVO> Finance_InfoList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Finance_InfoList();
	}

	@Override
	public List<String> Payment_Alarm_FinanceList(String date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Payment_Alarm_FinanceList(date);
	}

	@Override
	public List<String> Dividends_Alarm_FinanceList(String date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Dividends_Alarm_FinanceList(date);
	}

	@Override
	public List<Finance_InfoVO> Dividends_King_List() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Dividends_King_List();
	}

	@Override
	public List<Finance_InfoVO> Dividends_Aristocrat_List() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Dividends_Aristocrat_List();
	}

	@Override
	public List<Finance_InfoVO> Dividends_Monthly_List(String date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Finance_InfoDAO.Dividends_Monthly_List(date);
	}
	
}
