package com.kbaez.karinabaezch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbaez.karinabaezch.dto.PriceDTO;
import com.kbaez.karinabaezch.services.PriceService;

@SpringBootApplication
@EnableScheduling
@RestController
public class KarinaBaezchApplication {
	
	@Autowired
	private PriceService priceService;

	public static void main(String[] args) {
		SpringApplication.run(KarinaBaezchApplication.class, args);
	}

	@Scheduled(fixedRate = 10000)
	public void getAndSavePriceBtc() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://cex.io/api/last_price/BTC/USD")).GET()
				.build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper objectMapper = new ObjectMapper();
			PriceDTO priceDTO = objectMapper.readValue(respuesta.body(), PriceDTO.class);
			priceService.savePrice(priceDTO);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
