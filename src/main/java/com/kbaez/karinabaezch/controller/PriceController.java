package com.kbaez.karinabaezch.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.AvgDTO;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.services.PriceService;

@RestController
@RequestMapping("/btc")
public class PriceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

	@Autowired
	private PriceService priceService;

	@GetMapping("/price")
	public ResponseEntity<PriceDTO> getPriceByTimestamp(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
		Price price = priceService.getPrice(date);
		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setLprice(String.valueOf(price.getLprice()));
		priceDTO.setCurr1(price.getCurr1());
		priceDTO.setCurr2(price.getCurr2());
		return new ResponseEntity<PriceDTO>(priceDTO, HttpStatus.OK);
	}

	@GetMapping("/pricebetween")
	public ResponseEntity<AvgDTO> getPriceBetweenTwoTimestamp(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime start,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime end) {
		Double price = priceService.getPriceBetween(start,end);
		Double maxPrice = priceService.getMaxPrice();
		
		AvgDTO avg = new AvgDTO();
		avg.setAvgPrice(String.valueOf(price));
		avg.setMaxPrice(String.valueOf(maxPrice));
		avg.setPercent(calculatePercent(maxPrice, price));
		return new ResponseEntity<AvgDTO>(avg, HttpStatus.OK);
	}

	private String calculatePercent(Double maxPrice, Double price) {
		Double result = ((price - maxPrice) / maxPrice ) * 100;
		return String.valueOf(result);
	}
}
