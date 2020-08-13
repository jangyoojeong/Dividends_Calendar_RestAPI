package com.jurini.finance_history_info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jurini.finance_history_info.dao.Finance_History_InfoDAO;
import com.jurini.finance_history_info.vo.Finance_History_InfoVO;

@Service("Finance_History_InfoService")
public class Finance_History_InfoServiceImpl implements Finance_History_InfoService {

	@Autowired
    private Finance_History_InfoDAO finance_History_InfoDAO;
	
	@Override
	public List<Finance_History_InfoVO> Finance_History_InfoList(String symbol) {
		// TODO Auto-generated method stub
		return finance_History_InfoDAO.Finance_History_InfoList(symbol);
	}

	@Override
	public int insertFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		// TODO Auto-generated method stub
		return finance_History_InfoDAO.insertFinance_History_Data(finance_History_InfoVO);
	}

	@Override
	public int updateFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		// TODO Auto-generated method stub
		return finance_History_InfoDAO.updateFinance_History_Data(finance_History_InfoVO);
	}

	@Override
	public int deleteFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		// TODO Auto-generated method stub
		return finance_History_InfoDAO.deleteFinance_History_Data(finance_History_InfoVO);
	}

}
