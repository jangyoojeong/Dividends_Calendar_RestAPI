package com.jurini.scheduler;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jurini.alarm_info.service.Alarm_InfoService;
import com.jurini.finance_info.service.Finance_InfoService;

// Fix-Me :  에러 수정 필요~!
@EnableScheduling
@Component
public class NotiScheduler {

	@Resource(name = "Alarm_InfoService")
	private Alarm_InfoService alarm_InfoService;

	@Resource(name = "Finance_InfoService")
	private Finance_InfoService finance_InfoService;

	private static final String SERVER_KEY = "AAAAlleqw9I:APA91bE6D6DbekJ19oCc88flI4Z9kh4Mu3X7sOvUFWrVHYnaSIU25t-UXimeX2COKGQXo4ywdYKG1Yc9__ncGLcAk3xd2aniW0w-fPZmQYP0MqY3XNuTav_Xm61U__3Q2t357sN2aAxk";

	@Scheduled(cron="0 0 22 * * *") // 미국 시간 오전 9시 = 한국 시간 오후 10시
	//@Scheduled(cron = "*/30 * * * * *") // 테스트 용
	public void scheduleRun() {
		
		PaymantAlarmThread paymentAlarmThd = new PaymantAlarmThread();
		DividendsAlarmThread dividendsmentAlarmThd = new DividendsAlarmThread();
		
		Thread paymentAlarm = new Thread(paymentAlarmThd);
		Thread dividendsAlarm = new Thread(dividendsmentAlarmThd);
		
		paymentAlarm.start();
		dividendsAlarm.start();
		
	}
	
	// 지불일 알림
	public class PaymantAlarmThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			OutputStream os = null;
			BufferedReader br = null;
			
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(new Date());
				List<String> pushSymbols = (List<String>)finance_InfoService.Payment_Alarm_FinanceList(date);
				if (pushSymbols.isEmpty()) {
					return;
				}

				for (String symbol : pushSymbols) {
					List<String> pushList = alarm_InfoService.Push_List(symbol);

					if (pushList.isEmpty()) {
						continue;
					}

					URL url = new URL("https://fcm.googleapis.com/fcm/send");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					conn.setUseCaches(false);
					conn.setDoInput(true);
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);

					JSONObject jsonData = new JSONObject();
					JSONObject notiData = new JSONObject();
					// 보낼 정보
					// 실제 보낼 정보는 to가 아닌 registration_ids 에 배열로 여러명에게 푸시해야함.

					JSONArray users = new JSONArray();
					users.addAll(pushList);
					jsonData.put("registration_ids", users);
					// jsonData.put("to",
					// "fhXZ0WW5RhSnmXtXMgL_vx:APA91bEonEcMCplCLMJOiJ_hS0GTQ8sLLKqp-MHwkm1oo0FM9ix7NXJJONLTa38ne7xUQ_D-lIwxcIucqxZnBxGyMFhdDbG5x-mQgJx6NuH7we8quVz65Qbo89mOxCg-uFtXc9KOlc4K");
					jsonData.put("priority", "high");
					notiData.put("title", "주린이");
					notiData.put("body", symbol + " 지급일입니다. 확인하세요.");
					jsonData.put("notification", notiData);

					os = conn.getOutputStream();
					os.write(jsonData.toString().getBytes("UTF-8"));
					os.flush();
					os.close();

					br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

					String output;
					StringBuilder builder = new StringBuilder();
					while ((output = br.readLine()) != null) {
						builder.append(output);
					}
					br.close();
					System.out.println(builder);
					String result = builder.toString();

					JSONParser parser = new JSONParser();
					Object obj = parser.parse(result);
					JSONObject jsonObj = (JSONObject) obj;

					// int succ = (Integer) jsonObj.get("success");
					// int fail = (Integer) jsonObj.get("failure");

					// To-Do : 푸시 성공, 실패 시 로직

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(os != null) {
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(br != null) {
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
	
	// 배당일 3일전 알림
		public class DividendsAlarmThread implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				OutputStream os = null;
				BufferedReader br = null;
				
				try {
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 4);
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String date = dateFormat.format(cal.getTime());
					List<String> pushSymbols = (List<String>)finance_InfoService.Dividends_Alarm_FinanceList(date);
					if (pushSymbols.isEmpty()) {
						return;
					}

					for (String symbol : pushSymbols) {
						List<String> pushList = alarm_InfoService.Push_List(symbol);

						if (pushList.isEmpty()) {
							continue;
						}

						URL url = new URL("https://fcm.googleapis.com/fcm/send");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();

						conn.setUseCaches(false);
						conn.setDoInput(true);
						conn.setDoOutput(true);
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Content-Type", "application/json");
						conn.setRequestProperty("Accept", "application/json");
						conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);

						JSONObject jsonData = new JSONObject();
						JSONObject notiData = new JSONObject();
						// 보낼 정보
						// 실제 보낼 정보는 to가 아닌 registration_ids 에 배열로 여러명에게 푸시해야함.

						JSONArray users = new JSONArray();
						users.addAll(pushList);
						jsonData.put("registration_ids", users);
						// jsonData.put("to",
						// "fhXZ0WW5RhSnmXtXMgL_vx:APA91bEonEcMCplCLMJOiJ_hS0GTQ8sLLKqp-MHwkm1oo0FM9ix7NXJJONLTa38ne7xUQ_D-lIwxcIucqxZnBxGyMFhdDbG5x-mQgJx6NuH7we8quVz65Qbo89mOxCg-uFtXc9KOlc4K");
						jsonData.put("priority", "high");
						notiData.put("title", "주린이");
						notiData.put("body", symbol + " 배당일 3일전입니다. 확인하세요.");
						jsonData.put("notification", notiData);

						os = conn.getOutputStream();
						os.write(jsonData.toString().getBytes("UTF-8"));
						os.flush();
						os.close();

						br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

						String output;
						StringBuilder builder = new StringBuilder();
						while ((output = br.readLine()) != null) {
							builder.append(output);
						}
						br.close();
						System.out.println(builder);
						String result = builder.toString();

						JSONParser parser = new JSONParser();
						Object obj = parser.parse(result);
						JSONObject jsonObj = (JSONObject) obj;

						// int succ = (Integer) jsonObj.get("success");
						// int fail = (Integer) jsonObj.get("failure");

						// To-Do : 푸시 성공, 실패 시 로직

					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(os != null) {
						try {
							os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(br != null) {
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
