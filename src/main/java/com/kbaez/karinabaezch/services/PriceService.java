package com.kbaez.karinabaezch.services;

import java.time.LocalDateTime;
import java.util.List;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;

public interface PriceService {
	
	void savePrice(Price price);
	
	Price getPrice(LocalDateTime date);

	Double getPriceBetween(LocalDateTime start, LocalDateTime end);

	Double getMaxPrice();

}
