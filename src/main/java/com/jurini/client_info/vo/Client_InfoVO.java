package com.jurini.client_info.vo;


public class Client_InfoVO {
	
	private String firebase_token;
	private int alarm;
	public String getFirebase_token() {
		return firebase_token;
	}
	public void setFirebase_token(String firebase_token) {
		this.firebase_token = firebase_token;
	}
	public int getAlarm() {
		return alarm;
	}
	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}
	@Override
	public String toString() {
		return "Client_InfoVO [firebase_token=" + firebase_token + ", alarm=" + alarm + "]";
	}
	
	
	
	
}
