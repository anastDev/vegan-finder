package com.anastDev.vegan_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaAuditing
public class VeganFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeganFinderApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				.codecs(configurer -> configurer
						.defaultCodecs()
						.maxInMemorySize(5 * 1024 * 1024))
				.build();
	}
}
