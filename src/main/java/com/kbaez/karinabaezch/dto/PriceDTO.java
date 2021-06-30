package com.kbaez.karinabaezch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PriceDTO {
	@JsonProperty("lprice")
	private String lprice;
	@JsonProperty("curr1")
	private String curr1;
	@JsonProperty("curr2")
	private String curr2;	
	
	public PriceDTO() {}
}
