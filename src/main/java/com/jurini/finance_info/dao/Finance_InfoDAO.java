package com.jurini.finance_info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jurini.finance_info.vo.Finance_InfoVO;

@Repository
public class Finance_InfoDAO {

	
	@Autowired
	private SqlSession SqlSession;
	
	public Finance_InfoVO Finance_InfoOneData (String symbol) {
		return SqlSession.selectOne("mybatis.sql.finance_info_mapper.Finance_InfoOneData", symbol);
	}
	
	public List<Finance_InfoVO> Finance_InfoList (){
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Finance_InfoList");
	}

	public List<String> Payment_Alarm_FinanceList(String date) {
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Payment_Alarm_FinanceList", date);
	}

	public List<String> Dividends_Alarm_FinanceList(String date) {
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Dividends_Alarm_FinanceList", date);
	}
	
	public List<Finance_InfoVO> Dividends_King_List (){
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Dividends_King_List");
	}
	
	public List<Finance_InfoVO> Dividends_Aristocrat_List (){
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Dividends_Aristocrat_List");
	}
	
	public List<Finance_InfoVO> Dividends_Monthly_List (String date){
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Dividends_Monthly_List", date);
	}
}
