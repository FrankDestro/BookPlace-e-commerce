package com.dev.BookPlace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookPlaceApplication{

	public static void main(String[] args) {
		SpringApplication.run(BookPlaceApplication.class, args);
	}
}
