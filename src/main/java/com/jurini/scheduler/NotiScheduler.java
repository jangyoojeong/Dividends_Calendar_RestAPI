package com.jurini.scheduler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;

public class NotiScheduler {
	
	private static final String SERVER_KEY = "AAAAlleqw9I:APA91bE6D6DbekJ19oCc88flI4Z9kh4Mu3X7sOvUFWrVHYnaSIU25t-UXimeX2COKGQXo4ywdYKG1Yc9__ncGLcAk3xd2aniW0w-fPZmQYP0MqY3XNuTav_Xm61U__3Q2t357sN2aAxk";

//	@Scheduled(cron="0 0 22 * * *") // 미국 오전 9시 = 한국 오후 10시
	@Scheduled(cron="0 * * * * *") // 테스트
    public void scheduleRun() {
		
		System.out.println("푸시 알림~!!");
		// To-Do :
		// 알림이 필요한 데이터 조회
		try {
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
	        // 테스트 파이어베이스 토큰
	        // 여러 인원에게 전송할 때는 registration_ids 로 배열로 묶어 보내야됨.
	        jsonData.put("to", "fhXZ0WW5RhSnmXtXMgL_vx:APA91bEonEcMCplCLMJOiJ_hS0GTQ8sLLKqp-MHwkm1oo0FM9ix7NXJJONLTa38ne7xUQ_D-lIwxcIucqxZnBxGyMFhdDbG5x-mQgJx6NuH7we8quVz65Qbo89mOxCg-uFtXc9KOlc4K");
	        jsonData.put("priority", "high");
	        notiData.put("title", "주린이 테스트");
	        notiData.put("body", "주린이 배당락일을 확인해주세요.");
	        jsonData.put("notification", notiData);

            OutputStream os = conn.getOutputStream();
            os.write(jsonData.toString().getBytes("UTF-8"));
            os.flush();
            os.close();
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

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

//            int succ = (Integer) jsonObj.get("success");
//            int fail = (Integer) jsonObj.get("failure");
            
            // To-Do : 성공 실패에 따른 추가 대응?

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
