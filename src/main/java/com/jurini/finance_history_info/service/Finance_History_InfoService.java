package com.jurini.finance_history_info.service;

import java.util.List;

import com.jurini.finance_history_info.vo.Finance_History_InfoVO;

public interface Finance_History_InfoService {

	public List<Finance_History_InfoVO> Finance_History_InfoList (String symbol);
	
	public int insertFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO);

	public int updateFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO);
	
	public int deleteFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO);
}
