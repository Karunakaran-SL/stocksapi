package com.test.stock.stockservice;

import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.repo.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
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

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.test.stock.stockservice"))
				.paths(PathSelectors.any())
				.build();
	}
}
