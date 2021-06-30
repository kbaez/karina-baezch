package com.kbaez.karinabaezch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.services.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService userService;
    
    @GetMapping("/{timestamp}")
    public ResponseEntity<PriceDTO> getPriceByTimestamp(@PathVariable String timestamp){
    	Price price = userService.getPrice(timestamp);
    	PriceDTO priceDTO = new PriceDTO();
    	priceDTO.setLprice(price.getLprice());
    	priceDTO.setCurr1(price.getCurr1());
    	priceDTO.setCurr2(price.getCurr2());
    	
    	return new ResponseEntity<PriceDTO>(priceDTO, HttpStatus.OK);
    }
}
