package com.jurini.finance_history_info.vo;

import java.util.Date;

public class Finance_History_InfoVO {
	
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
	@Override
	public String toString() {
		return "Finance_History_InfoVO [symbol=" + symbol + ", dividends_date=" + dividends_date + ", dividends="
				+ dividends + "]";
	}

	
}
