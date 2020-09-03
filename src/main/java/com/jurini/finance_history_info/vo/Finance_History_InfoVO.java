package com.jurini.finance_history_info.vo;

import java.util.Date;

public class Finance_History_InfoVO {
	
	private Integer history_id;
	private String symbol;
	private Date dividends_date;
	private Double dividends;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getDividends_date() {
		return dividends_date;
	}
	public void setDividends_date(Date dividends_date) {
		this.dividends_date = dividends_date;
	}
	public Double getDividends() {
		return dividends;
	}
	public void setDividends(Double dividends) {
		this.dividends = dividends;
	}
	public Integer getHistory_id() {
		return history_id;
	}
	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}
	@Override
	public String toString() {
		return "Finance_History_InfoVO [history_id=" + history_id + ", symbol=" + symbol + ", dividends_date="
				+ dividends_date + ", dividends=" + dividends + "]";
	}
}
