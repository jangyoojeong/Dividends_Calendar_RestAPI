package com.jurini.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jurini.finance_info.service.Finance_InfoService;
import com.jurini.finance_info.vo.Finance_InfoVO;


@Controller
public class Finance_InfoController {
	
	Finance_InfoVO finance_infoVO = new Finance_InfoVO();
	
	@Resource(name = "Finance_InfoService")
    private Finance_InfoService finance_infoService;
    
    @RequestMapping(value ="goTestPage.do" , method = RequestMethod.GET)
    public @ResponseBody List<Finance_InfoVO> goTestPage() throws ClassNotFoundException, SQLException{
          
          return finance_infoService.Finance_InfoList();
    }


}
