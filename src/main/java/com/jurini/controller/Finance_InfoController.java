package com.jurini.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.compiler.ast.Symbol;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jurini.finance_info.service.Finance_InfoService;
import com.jurini.finance_info.vo.Finance_InfoVO;

@Controller
public class Finance_InfoController {

	Finance_InfoVO finance_infoVO = new Finance_InfoVO();

	@Resource(name = "Finance_InfoService")
	private Finance_InfoService finance_infoService;

	@RequestMapping(value = "goTestPage.do", method = RequestMethod.GET)
	public @ResponseBody List<Finance_InfoVO> goTestPage() throws ClassNotFoundException, SQLException {

		return finance_infoService.Finance_InfoList();
	}

	@RequestMapping(value = "financeInfoList.do", method = RequestMethod.POST)
	public @ResponseBody List<Finance_InfoVO> financeInfoList() throws ClassNotFoundException, SQLException {

		return finance_infoService.Finance_InfoList();
	}

	@RequestMapping(value = "financeInfoData.do", method = RequestMethod.POST)
	public @ResponseBody Finance_InfoVO financeInfoData(@RequestParam(value = "symbol") String symbol)
			throws ClassNotFoundException, SQLException {

		return finance_infoService.Finance_InfoOneData(symbol);
	}

	@RequestMapping(value = "dividendsKingList.do", method = RequestMethod.POST)
	public @ResponseBody List<Finance_InfoVO> dividendsKingList() throws ClassNotFoundException, SQLException {

		return finance_infoService.Dividends_King_List();
	}

	@RequestMapping(value = "dividendsAristocratList.do", method = RequestMethod.POST)
	public @ResponseBody List<Finance_InfoVO> dividendsAristocratList() throws ClassNotFoundException, SQLException {

		return finance_infoService.Dividends_Aristocrat_List();
	}
	
	@RequestMapping(value = "dividendsMonthlyList.do", method = RequestMethod.POST)
	public @ResponseBody List<Finance_InfoVO> dividendsMonthlyList(@RequestParam(value = "date") String date) throws ClassNotFoundException, SQLException {
		
		return finance_infoService.Dividends_Monthly_List(date);
	}

	@RequestMapping(value = "latestClosePrice.do", method = RequestMethod.POST)
	public @ResponseBody String latestClosePrice(@RequestParam(value = "symbol") String symbol)
			throws ClassNotFoundException, SQLException {
		GetClosePriceThread getClosePriceThd = new GetClosePriceThread(symbol);

		Thread getClosePrice = new Thread(getClosePriceThd);
		getClosePrice.start();
		try {
			getClosePrice.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getClosePriceThd.getValue();
	}

	public class GetClosePriceThread implements Runnable {

		String apikey = "ZSFBXRCOCCY81AN5";
		String req_url = "https://www.alphavantage.co/query";
		String symbol;
		
		private volatile String value;
		
		public String getValue() {
			return this.value;
		}

		public GetClosePriceThread(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			OutputStream os = null;
			BufferedReader br = null;

			try {
				URL url = new URL(req_url + "?apikey=" + apikey + "&symbol=" + symbol + "&function=GLOBAL_QUOTE");
				HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.connect();

				br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				StringBuilder builder = new StringBuilder();
				while ((output = br.readLine()) != null) {
					builder.append(output);
				}
				br.close();
				String result = builder.toString();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(result);
				JSONObject jsonObj = (JSONObject) obj;
				String closeValue = ((JSONObject)jsonObj.get("Global Quote")).get("05. price").toString();
				this.value = closeValue;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
