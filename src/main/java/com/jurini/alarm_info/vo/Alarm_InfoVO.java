package com.jurini.alarm_info.vo;


public class Alarm_InfoVO {
	
	private String client_id;
	private String alarm_data;
	private int alarm_id;
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getAlarm_data() {
		return alarm_data;
	}
	public void setAlarm_data(String alarm_data) {
		this.alarm_data = alarm_data;
	}
	public int getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}
	@Override
	public String toString() {
		return "Alarm_InfoVO [client_id=" + client_id + ", alarm_data=" + alarm_data + ", alarm_id=" + alarm_id + "]";
	}
	
}
