package com.kbaez.karinabaezch.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.exception.PriceNotFoundException;
import com.kbaez.karinabaezch.repository.PriceRepository;
import com.kbaez.karinabaezch.services.PriceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public void savePrice(Price price) {
		price.setCreateDate(LocalDateTime.now().withNano(0));
		priceRepository.save(price);
	}

	@Override
	public Price getPrice(LocalDateTime date) {
		return priceRepository.findByCreateDate(date);
//				.orElseThrow(() -> new PriceNotFoundException(
//				String.format("The price with timestamp %d does not exists", date)));
	}

	@Override
	public Double getPriceBetween(LocalDateTime start, LocalDateTime end) {
		return priceRepository.findByAvg(start, end);
	}

	public PriceServiceImpl(PriceRepository priceRepository2) {
		this.priceRepository = priceRepository2;
	}

	@Override
	public Double getMaxPrice() {
		return priceRepository.getMaxPrice();
	}

}
