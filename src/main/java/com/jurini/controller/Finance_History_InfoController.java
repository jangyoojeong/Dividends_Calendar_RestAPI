package com.jurini.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurini.finance_history_info.service.Finance_History_InfoService;
import com.jurini.finance_history_info.vo.Finance_History_InfoVO;

@Controller
public class Finance_History_InfoController {

	@Resource(name = "Finance_History_InfoService")
    private Finance_History_InfoService finance_history_infoService;
    
    @RequestMapping(value ="financeHistoryInfoList.do" , method = RequestMethod.POST)
    public @ResponseBody List<Finance_History_InfoVO> financeHistoryInfoList(@RequestParam(value="symbol") String symbol) throws ClassNotFoundException, SQLException{
          
          return finance_history_infoService.Finance_History_InfoList(symbol);
    }
}
