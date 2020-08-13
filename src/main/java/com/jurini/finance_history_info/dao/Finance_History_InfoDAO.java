package com.jurini.finance_history_info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jurini.finance_history_info.vo.Finance_History_InfoVO;

@Repository
public class Finance_History_InfoDAO {

	@Autowired
	private SqlSession SqlSession;
	
	public List<Finance_History_InfoVO> Finance_History_InfoList (String symbol){
		return SqlSession.selectList("mybatis.sql.finance_history_info_mapper.Finance_History_InfoList", symbol);
	}
	
	public int insertFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		return SqlSession.insert("mybatis.sql.finance_history_info_mapper.insertFinance_History_Data", finance_History_InfoVO);
	}

	public int updateFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		return SqlSession.update("mybatis.sql.finance_history_info_mapper.updateFinance_History_Data", finance_History_InfoVO);
	}
	
	public int deleteFinance_History_Data(Finance_History_InfoVO finance_History_InfoVO) {
		return SqlSession.delete("mybatis.sql.finance_history_info_mapper.deleteFinance_History_Data", finance_History_InfoVO);
	}
}
