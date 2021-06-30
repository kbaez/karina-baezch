package com.kbaez.karinabaezch;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.kbaez.karinabaezch.repository.PriceRepository;
import com.kbaez.karinabaezch.services.PriceService;
import com.kbaez.karinabaezch.services.impl.PriceServiceImpl;

@SpringBootTest
class PriceServiceImplTests {

	private PriceService priceService;

	private PriceRepository priceRepository;

	@Before
	public void setUp() {
		priceRepository = Mockito.mock(PriceRepository.class);
//		priceService = new PriceServiceImpl(priceRepository);
	}

	@Test
	void savePrice() {
	}

}
