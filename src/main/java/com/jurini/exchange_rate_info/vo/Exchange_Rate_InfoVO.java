package com.jurini.exchange_rate_info.vo;

import java.util.Date;

public class Exchange_Rate_InfoVO {
	
	private Double exchange_rate;

	public Double getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(Double exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	@Override
	public String toString() {
		return "Exchange_Rate_InfoVO [exchange_rate=" + exchange_rate + "]";
	}
	
	
	
}
