package com.kbaez.karinabaezch.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.repository.PriceRepository;
import com.kbaez.karinabaezch.services.PriceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public void savePrice(PriceDTO priceDTO) {
		Price price = new Price();
		price.setLprice(priceDTO.getLprice());
		price.setCurr1(priceDTO.getCurr1());
		price.setCurr2(priceDTO.getCurr2());
		price.setCreateDate(LocalDateTime.now().withNano(0));
		priceRepository.save(price);
	}

	@Override
	public Price getPrice(LocalDateTime date) {
		return priceRepository.findByCreateDate(date);				
//				.orElseThrow(() -> new PriceNotFoundException(
//				String.format("The price with timestamp %d does not exists", timestamp)));
	}

	@Override
	public List<Price> getPriceBetween(LocalDateTime start, LocalDateTime end) {
		return priceRepository.findByCreateDateGreaterThanEqualAndCreateDateLessThanEqual(start, end);
	}

	@Override
	public void savePrice(Price price) {
		priceRepository.save(price);
		
	}

}
