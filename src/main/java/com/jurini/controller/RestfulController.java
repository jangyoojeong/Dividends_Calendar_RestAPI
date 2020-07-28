package com.jurini.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jurini.restful.vo.Close_Price_HistoryVO;
import com.jurini.restful.vo.Dividend_HistoryVO;

@RestController   
@RequestMapping("/rest")

public class RestfulController {

	
	//배당 이력 가져오기
	@RequestMapping(value ="/getDividendHistory", method = RequestMethod.GET)    
    public Dividend_HistoryVO responseDividendHistory(HttpServletRequest req) {    
		
		String ticker = req.getParameter("ticker");
		String start_year = req.getParameter("start_year");
		String end_year = req.getParameter("end_year");

		Dividend_HistoryVO vo = new Dividend_HistoryVO();
		
		vo.setTicker(ticker);                           
		vo.setStart_year(start_year);
		vo.setEnd_year(end_year);

		return vo;                               

	}
	
	//종가 이력 가져오기
	@RequestMapping(value ="/getClosePriceHistory", method = RequestMethod.GET)    
    public Close_Price_HistoryVO responseClosePriceHistory(HttpServletRequest req) {    
		
		String symbol = req.getParameter("symbol");


		Close_Price_HistoryVO vo = new Close_Price_HistoryVO();
		
		vo.setSymbol(symbol);                           

		return vo;                               

	}



}