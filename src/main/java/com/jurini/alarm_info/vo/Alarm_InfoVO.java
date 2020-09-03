package com.jurini.alarm_info.vo;


public class Alarm_InfoVO {
	
	private String client_id;
	private String alarm_data;
	private double volume;
	private int have_dividends;
	
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
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public int getHave_dividends() {
		return have_dividends;
	}
	public void setHave_dividends(int have_dividends) {
		this.have_dividends = have_dividends;
	}
	@Override
	public String toString() {
		return "Alarm_InfoVO [client_id=" + client_id + ", alarm_data=" + alarm_data
				+ ", volume=" + volume + ", have_dividends=" + have_dividends + "]";
	}

}
