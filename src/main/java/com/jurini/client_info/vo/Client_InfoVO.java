package com.jurini.client_info.vo;


public class Client_InfoVO {
	
	private String client_id;
	private String firebase_token;
	private int alarm;
	private int have_dividends_alarm;
	private int like_dividends_alarm;
	private int have_payment_alarm;
	private int like_payment_alarm;
	private int monthly_alarm;
	
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
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public int getHave_dividends_alarm() {
		return have_dividends_alarm;
	}
	public void setHave_dividends_alarm(int have_dividends_alarm) {
		this.have_dividends_alarm = have_dividends_alarm;
	}
	public int getLike_dividends_alarm() {
		return like_dividends_alarm;
	}
	public void setLike_dividends_alarm(int like_dividends_alarm) {
		this.like_dividends_alarm = like_dividends_alarm;
	}
	public int getHave_payment_alarm() {
		return have_payment_alarm;
	}
	public void setHave_payment_alarm(int have_payment_alarm) {
		this.have_payment_alarm = have_payment_alarm;
	}
	public int getLike_payment_alarm() {
		return like_payment_alarm;
	}
	public void setLike_payment_alarm(int like_payment_alarm) {
		this.like_payment_alarm = like_payment_alarm;
	}
	public int getMonthly_alarm() {
		return monthly_alarm;
	}
	public void setMonthly_alarm(int monthly_alarm) {
		this.monthly_alarm = monthly_alarm;
	}
	
	@Override
	public String toString() {
		return "Client_InfoVO [client_id=" + client_id + ", firebase_token=" + firebase_token + ", alarm=" + alarm
				+ ", have_dividends_alarm=" + have_dividends_alarm + ", like_dividends_alarm=" + like_dividends_alarm
				+ ", have_payment_alarm=" + have_payment_alarm + ", like_payment_alarm=" + like_payment_alarm
				+ ", monthly_alarm=" + monthly_alarm + "]";
	}
	
}
