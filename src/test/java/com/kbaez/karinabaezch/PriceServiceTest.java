package com.kbaez.karinabaezch;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;

import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.AvgDTO;
import com.kbaez.karinabaezch.repository.PriceRepository;
import com.kbaez.karinabaezch.services.PriceService;
import com.kbaez.karinabaezch.services.impl.PriceServiceImpl;

public class PriceServiceTest {
	private PriceService priceService;

	private PriceRepository priceRepository;

	@BeforeEach
	public void setUp() {
		priceRepository = Mockito.mock(PriceRepository.class);
		priceService = new PriceServiceImpl(priceRepository);
	}

	@Test
	public void testGetPriceByTimestampThenReturnPriceDTO() {
		Price expectedPrice = buildNewPrice(34324.6, "BTC", "USD", "2021-07-06 20:35:50");

		Mockito.when(priceRepository.findByCreateDate(Mockito.any())).thenReturn(expectedPrice);

		Price response = priceService.getPrice(getLocalDateTime("2021-07-06 20:35:50"));

		assertEquals(expectedPrice, response);
	}

	@Test
	public void testGetPriceBetweenTimestampsThenReturnListPriceDTO() {
//		AvgDTO expectedAvg = buildNewAvg();
//
//		Mockito.when(priceRepository.findByAvg(Mockito.any(),
//				Mockito.any())).thenReturn(expectedAvg);
//
//		AvgDTO response = priceService.getPriceBetween(getLocalDateTime("2021-07-06 10:30:20"),
//				getLocalDateTime("2021-07-06 10:31:20"));
//
//		assertEquals(expectedPrice, response);
	}

	@Test
	public void testGetPriceByTimestampThenThrowsPriceNotFoundException() {
		doThrow(EmptyResultDataAccessException.class).when(priceRepository).findByCreateDate(Mockito.any());

		assertThrows(EmptyResultDataAccessException.class, () -> {
			priceService.getPrice(getLocalDateTime("2021-07-06 20:35:50"));
		});
	}

	private Price buildNewPrice(Double lp, String curr1, String curr2, String date) {
		Price price = new Price();
		price.setId(1L);
		price.setLprice(lp);
		price.setCurr1(curr1);
		price.setCurr2(curr2);
		price.setCreateDate(getLocalDateTime(date));
		return price;
	}	

	private LocalDateTime getLocalDateTime(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		return dateTime;
	}

}
