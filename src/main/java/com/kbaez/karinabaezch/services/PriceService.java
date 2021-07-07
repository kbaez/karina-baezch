package com.kbaez.karinabaezch.services;

import java.time.LocalDateTime;
import java.util.List;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;

public interface PriceService {
	
	void savePrice(PriceDTO priceDTO);
	
	void savePrice(Price priceDTO);
	
	Price getPrice(LocalDateTime date);

	List<Price> getPriceBetween(LocalDateTime start, LocalDateTime end);

}
