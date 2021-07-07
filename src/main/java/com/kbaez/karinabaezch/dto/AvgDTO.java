package com.kbaez.karinabaezch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvgDTO {
	@JsonProperty("avgprice")
	private String avgPrice;
	@JsonProperty("maxprice")
	private String maxPrice;
	@JsonProperty("percent")
	private String percent;
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}	
}
