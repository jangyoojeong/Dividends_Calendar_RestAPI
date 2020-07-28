package com.jurini.restful.vo;

public class Dividend_HistoryVO {

	private String ticker;
	private String start_year;
	private String end_year;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getStart_year() {
		return start_year;
	}
	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}
	public String getEnd_year() {
		return end_year;
	}
	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}
	@Override
	public String toString() {
		return "Dividend_HistoryVO [ticker=" + ticker + ", start_year=" + start_year + ", end_year=" + end_year + "]";
	}
	
	
	
}
