package com.kbaez.karinabaezch;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.kbaez.karinabaezch.controller.PriceController;
import com.kbaez.karinabaezch.domain.Price;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.services.PriceService;

@WebMvcTest(controllers = PriceController.class)
class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService priceService;

	@BeforeEach
	void setUp() {
		Price price = new Price();
		price.setLprice("34324.6");
		price.setCurr1("BTC");
		price.setCurr2("USD");
		price.setCreateDate(LocalDateTime.parse("2021-07-06T09:49:03"));
		
		priceService.savePrice(price);
	}

	@Test
	void shouldGetAPrice() throws Exception{
		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setLprice("34324.6");
		priceDTO.setCurr1("BTC");
		priceDTO.setCurr2("USD");
				
		doReturn(priceDTO.toString()).when(priceService).getPrice(any());
		
		mockMvc.perform(get("/price/btc")
	                .contentType("application/json")
	                .param("date", "2021-07-06T09:49:03"))
	                .andExpect(status().isOk());
	}

}
