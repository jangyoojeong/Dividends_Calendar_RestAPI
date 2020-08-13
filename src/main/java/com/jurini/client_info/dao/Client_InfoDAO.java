package com.jurini.client_info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jurini.client_info.vo.Client_InfoVO;

@Repository
public class Client_InfoDAO {

	@Autowired
	private SqlSession SqlSession;
	
	public List<Client_InfoVO> Client_InfoList (){
		return SqlSession.selectList("mybatis.sql.client_info_mapper.Client_InfoList");
	}
	
	public Client_InfoVO Client_InfoData (String firebase_token){
		return SqlSession.selectOne("mybatis.sql.client_info_mapper.Client_InfoData", firebase_token);
	}
	
	public int insertClient_Data(Client_InfoVO client_InfoVO) {
		return SqlSession.insert("mybatis.sql.client_info_mapper.insertClient_Data", client_InfoVO);
	}

	public int updateClient_Data(Client_InfoVO client_InfoVO) {
		return SqlSession.update("mybatis.sql.client_info_mapper.updateClient_Data", client_InfoVO);
	}
	
	public int deleteClient_Data(String firebase_token) {
		return SqlSession.delete("mybatis.sql.client_info_mapper.deleteClient_Data", firebase_token);
	}
	
}
