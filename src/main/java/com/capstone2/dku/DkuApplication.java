package com.capstone2.dku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DkuApplication {
// test
	public static void main(String[] args) {
		SpringApplication.run(DkuApplication.class, args);
	}

}
