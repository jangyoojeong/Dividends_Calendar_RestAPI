package com.jurini.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurini.client_info.service.Client_InfoService;
import com.jurini.client_info.vo.Client_InfoVO;

@Controller
public class Client_InfoController {

	@Resource(name = "Client_InfoService")
    private Client_InfoService client_infoService;
    
    @RequestMapping(value ="clientInfoList.do" , method = RequestMethod.POST)
    public @ResponseBody List<Client_InfoVO> clientInfoList() throws ClassNotFoundException, SQLException{
          
          return client_infoService.Client_InfoList();
    }
    
    @RequestMapping(value ="clientInfoData.do" , method = RequestMethod.POST)
    public @ResponseBody Client_InfoVO clientInfoData(@RequestParam(value="client_id") String client_id) throws ClassNotFoundException, SQLException{
          
          return client_infoService.Client_InfoData(client_id);
    }
    
    @RequestMapping(value ="insertClientData.do" , method = RequestMethod.POST)
    public void insertClientData(@RequestBody Client_InfoVO client_InfoVO) throws ClassNotFoundException, SQLException{
          
    	client_infoService.insertClient_Data(client_InfoVO);
    }
    
    @RequestMapping(value ="updateClientData.do" , method = RequestMethod.POST)
    public @ResponseBody int updateClientData(@RequestBody Client_InfoVO client_InfoVO) throws ClassNotFoundException, SQLException{
          
    	return client_infoService.updateClient_Data(client_InfoVO);
    }
    
    @RequestMapping(value ="deleteClientData.do" , method = RequestMethod.POST)
    public void deleteClientData(@RequestParam(value="client_id") String client_id) throws ClassNotFoundException, SQLException{
          
    	client_infoService.deleteClient_Data(client_id);
    }
}
