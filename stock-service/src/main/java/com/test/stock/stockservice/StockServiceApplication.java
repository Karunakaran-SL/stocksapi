package com.test.stock.stockservice;

import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.repo.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(StockRepository stockRepository) {
		stockRepository.saveAll(Arrays.asList(new Stock("NSE",300),
				new Stock("GOOL",600),
				new Stock("MSDN",500)));
		return event -> stockRepository.findAll();
	}
}
