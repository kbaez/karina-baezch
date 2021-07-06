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
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.services.PriceService;

@RestController
@RequestMapping("/btc")
public class PriceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

	@Autowired
	private PriceService userService;

	@GetMapping("/price")
	public ResponseEntity<PriceDTO> getPriceByTimestamp(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
		Price price = userService.getPrice(date);
		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setLprice(price.getLprice());
		priceDTO.setCurr1(price.getCurr1());
		priceDTO.setCurr2(price.getCurr2());
		return new ResponseEntity<PriceDTO>(priceDTO, HttpStatus.OK);
	}

	@GetMapping("/pricebetween")
	public ResponseEntity<List<PriceDTO>> getPriceBetweenTwoTimestamp(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime start,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime end) {
		List<Price> prices = userService.getPriceBetween(start,end);
		//List<PriceDTO> pricesDtoList = prices.stream().map(p -> new PriceDTO(p.getLprice(),p.getCurr1(),p.getCurr2())).collect(Collectors.toCollection(ArrayList::new));
		List<PriceDTO> pricesDTOList = new ArrayList<>();
		for (Price price : prices) {
			pricesDTOList.add(new PriceDTO(price.getLprice(), price.getCurr1(), price.getCurr2()));
		}
		return new ResponseEntity<List<PriceDTO>>(pricesDTOList, HttpStatus.OK);
	}
}
