package com.jurini.client_info.service;

import java.util.List;

import com.jurini.client_info.vo.Client_InfoVO;

public interface Client_InfoService {

	public List<Client_InfoVO> Client_InfoList ();
	
	public Client_InfoVO Client_InfoData (String client_id);
	
	public int insertClient_Data(Client_InfoVO client_InfoVO);

	public int updateClient_Data(Client_InfoVO client_InfoVO);
	
	public int deleteClient_Data(String client_id);
}
