package com.kbaez.karinabaezch.services.impl;

import java.sql.Timestamp;
import java.util.Date;

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
		price.setCreateDate(new Timestamp((new Date()).getTime()));
		priceRepository.save(price);
	}

	@Override
	public Price getPrice() {
		return null;
	}

}
