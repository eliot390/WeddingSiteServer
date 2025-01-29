package com.example.WeddingSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WeddingSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeddingSiteApplication.class, args);
	}
}
