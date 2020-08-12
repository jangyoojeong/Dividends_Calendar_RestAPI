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
	
	public Finance_InfoVO Finance_InfoOneData (Finance_InfoVO vo1) {
		return SqlSession.selectOne("mybatis.sql.finance_info_mapper.Finance_InfoOneData", vo1);

	}
	
	public List<Finance_InfoVO> Finance_InfoList (){
		return SqlSession.selectList("mybatis.sql.finance_info_mapper.Finance_InfoList");
	}

}
