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
	
	private static final int[] pasts = {0, 3, 7};

	private static final String SERVER_KEY = "AAAAlleqw9I:APA91bE6D6DbekJ19oCc88flI4Z9kh4Mu3X7sOvUFWrVHYnaSIU25t-UXimeX2COKGQXo4ywdYKG1Yc9__ncGLcAk3xd2aniW0w-fPZmQYP0MqY3XNuTav_Xm61U__3Q2t357sN2aAxk";

	@Scheduled(cron="0 0 13 * * *") // 미국 워싱턴 DC 기준 9시 -> UTC(현재 서버 Timezone) 시간으로 오후 1시 
	//@Scheduled(cron = "*/30 * * * * *") // 테스트 용
	public void scheduleDailyRun() {
		
		for(int past : pasts) {
			PaymantAlarmThread paymentAlarmThd = new PaymantAlarmThread(past);
			DividendsAlarmThread dividendsmentAlarmThd = new DividendsAlarmThread(past);
			
			Thread paymentAlarm = new Thread(paymentAlarmThd);
			Thread dividendsAlarm = new Thread(dividendsmentAlarmThd);
			
			paymentAlarm.start();
			dividendsAlarm.start();
		}
		
	}
	
	@Scheduled(cron="0 0 13 1 * *") // 매월 알림
	public void scheduleMonthlyRun() {
		//TODO 매월 알림 내용 작성
	
	}
	
	// 지불일 알림
	public class PaymantAlarmThread implements Runnable{
		
		private int past;
		
		public PaymantAlarmThread(int past) {
			this.past = past;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			OutputStream os = null;
			BufferedReader br = null;
			
			try {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, past);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(cal.getTime());
				List<String> pushSymbols = (List<String>)finance_InfoService.Payment_Alarm_FinanceList(date);
				if (pushSymbols.isEmpty()) {
					return;
				}

				for (String symbol : pushSymbols) {
					List<String> pushList = alarm_InfoService.havePaymentPush_List(symbol);
					pushList.addAll( alarm_InfoService.likePaymentPush_List(symbol));

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
					notiData.put("title", "주달");
					if(past == 0) {
						notiData.put("body", symbol + " 지급일입니다. 확인하세요.");
					}else {
						notiData.put("body", symbol + " 지급일 " + past + "일 전입니다. 확인하세요.");
					}
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
	
	// 배당일 알림
		public class DividendsAlarmThread implements Runnable{

			private int past;
			
			public DividendsAlarmThread(int past) {
				this.past = past;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				OutputStream os = null;
				BufferedReader br = null;
				
				try {
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, past);
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String date = dateFormat.format(cal.getTime());
					List<String> pushSymbols = (List<String>)finance_InfoService.Dividends_Alarm_FinanceList(date);
					if (pushSymbols.isEmpty()) {
						return;
					}

					for (String symbol : pushSymbols) {
						List<String> pushList = alarm_InfoService.haveDividendsPush_List(symbol);
						pushList.addAll(pushList = alarm_InfoService.likeDividendsPush_List(symbol));

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
						notiData.put("title", "주달");
						if(past == 0) {
							notiData.put("body", symbol + " 배당일 "+ past + "일 전입니다. 확인하세요.");
						}else {
							notiData.put("body", symbol + " 배당일입니다. 확인하세요.");
						}
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
