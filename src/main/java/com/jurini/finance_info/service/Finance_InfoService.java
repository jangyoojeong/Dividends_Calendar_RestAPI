package com.jurini.finance_info.service;

import java.sql.SQLException;

import com.jurini.finance_info.vo.Finance_InfoVO;

public interface Finance_InfoService {

	public Finance_InfoVO Finance_InfoOneData(Finance_InfoVO vo1) throws ClassNotFoundException, SQLException;
}
