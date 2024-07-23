package com.dev.BookPlace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookPlaceApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookPlaceApplication.class);

	public static void main(String[] args) {
		logger.info("Aplicação iniciada");
		SpringApplication.run(BookPlaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Teste de log INFO - Enviando log para Logstash.");
		logger.error("Teste de log ERROR - Enviando log para Logstash.");


	}
}
