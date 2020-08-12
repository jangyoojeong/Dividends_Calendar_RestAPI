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

//	@Scheduled(cron="0 0 22 * * *") // �̱� ���� 9�� = �ѱ� ���� 10��
	@Scheduled(cron="0 * * * * *") // �׽�Ʈ
    public void scheduleRun() {
		
		System.out.println("Ǫ�� �˸�~!!");
		// To-Do :
		// �˸��� �ʿ��� ������ ��ȸ
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
	        // �׽�Ʈ ���̾�̽� ��ū
	        // ���� �ο����� ������ ���� registration_ids �� �迭�� ���� �����ߵ�.
	        jsonData.put("to", "fhXZ0WW5RhSnmXtXMgL_vx:APA91bEonEcMCplCLMJOiJ_hS0GTQ8sLLKqp-MHwkm1oo0FM9ix7NXJJONLTa38ne7xUQ_D-lIwxcIucqxZnBxGyMFhdDbG5x-mQgJx6NuH7we8quVz65Qbo89mOxCg-uFtXc9KOlc4K");
	        jsonData.put("priority", "high");
	        notiData.put("title", "�ָ��� �׽�Ʈ");
	        notiData.put("body", "�ָ��� �������� Ȯ�����ּ���.");
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
            
            // To-Do : ���� ���п� ���� �߰� ����?

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
