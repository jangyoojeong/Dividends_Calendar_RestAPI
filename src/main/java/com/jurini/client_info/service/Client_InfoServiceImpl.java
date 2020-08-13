package com.jurini.client_info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jurini.client_info.dao.Client_InfoDAO;
import com.jurini.client_info.vo.Client_InfoVO;

@Service("Client_InfoService")
public class Client_InfoServiceImpl implements Client_InfoService {

	@Autowired
    private Client_InfoDAO client_InfoDAO;
	
	@Override
	public List<Client_InfoVO> Client_InfoList() {
		// TODO Auto-generated method stub
		return client_InfoDAO.Client_InfoList();
	}
	
	@Override
	public Client_InfoVO Client_InfoData(String firebase_token) {
		// TODO Auto-generated method stub
		return client_InfoDAO.Client_InfoData(firebase_token);
	}

	@Override
	public int insertClient_Data(Client_InfoVO client_InfoVO) {
		// TODO Auto-generated method stub
		return client_InfoDAO.insertClient_Data(client_InfoVO);
	}

	@Override
	public int updateClient_Data(Client_InfoVO client_InfoVO) {
		// TODO Auto-generated method stub
		return client_InfoDAO.updateClient_Data(client_InfoVO);
	}

	@Override
	public int deleteClient_Data(String firebase_token) {
		// TODO Auto-generated method stub
		return client_InfoDAO.deleteClient_Data(firebase_token);
	}

}
