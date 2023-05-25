package com.amaris.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PruebaTecnicaAmarisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaAmarisApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
