package com.anastDev.vegan_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VeganFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeganFinderApplication.class, args);
	}

}
