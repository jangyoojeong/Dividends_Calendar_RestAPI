package com.jurini.finance_info.service;

import java.sql.SQLException;

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
	public Finance_InfoVO Finance_InfoOneData(Finance_InfoVO vo1) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return Finance_InfoDAO.Finance_InfoOneData(vo1);
	}

	
	
}
