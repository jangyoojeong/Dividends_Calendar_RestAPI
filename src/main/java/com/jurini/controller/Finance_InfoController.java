package com.jurini.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jurini.finance_info.service.Finance_InfoService;
import com.jurini.finance_info.vo.Finance_InfoVO;


@Controller
public class Finance_InfoController {
	
	Finance_InfoVO finance_infoVO = new Finance_InfoVO();
	
	@Resource(name = "Finance_InfoService")
    private Finance_InfoService finance_infoService;
    
    @RequestMapping(value ="goTestPage.do" , method = RequestMethod.GET)
    public String goTestPage(Finance_InfoVO vo1, Model model) throws ClassNotFoundException, SQLException{
          
    	model.addAttribute("mFinance_ino", finance_infoService.Finance_InfoOneData(vo1));
          
         
          return "DBtest";
    }


}
