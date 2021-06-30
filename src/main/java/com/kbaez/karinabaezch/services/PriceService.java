package com.kbaez.karinabaezch.services;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;

public interface PriceService {
	
	void savePrice(PriceDTO priceDTO);
	
	Price getPrice();

}
