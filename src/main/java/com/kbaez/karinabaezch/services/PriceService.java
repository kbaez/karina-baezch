package com.kbaez.karinabaezch.services;

import java.time.LocalDateTime;
import java.util.Date;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;

public interface PriceService {
	
	void savePrice(PriceDTO priceDTO);
	
	Price getPrice(LocalDateTime date);

}
