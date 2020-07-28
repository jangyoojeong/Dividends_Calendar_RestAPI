package com.jurini.finance_info.vo;

import java.util.Date;

public class Finance_InfoVO {
	private String symbol;
	private String name;
	private Double dividends;
	private Double dividends_rate;
	private Date dividends_date;
	private Date payment_date;
	private int hot_dividends;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDividends() {
		return dividends;
	}
	public void setDividends(Double dividends) {
		this.dividends = dividends;
	}
	public Double getDividends_rate() {
		return dividends_rate;
	}
	public void setDividends_rate(Double dividends_rate) {
		this.dividends_rate = dividends_rate;
	}
	public Date getDividends_date() {
		return dividends_date;
	}
	public void setDividends_date(Date dividends_date) {
		this.dividends_date = dividends_date;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public int getHot_dividends() {
		return hot_dividends;
	}
	public void setHot_dividends(int hot_dividends) {
		this.hot_dividends = hot_dividends;
	}
	@Override
	public String toString() {
		return "finance_infoVO [symbol=" + symbol + ", name=" + name + ", dividends=" + dividends + ", dividends_rate="
				+ dividends_rate + ", dividends_date=" + dividends_date + ", payment_date=" + payment_date
				+ ", hot_dividends=" + hot_dividends + "]";
	}
	
	
}
