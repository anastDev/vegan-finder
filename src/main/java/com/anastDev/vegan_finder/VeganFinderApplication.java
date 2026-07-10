package com.anastDev.vegan_finder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableJpaAuditing
public class VeganFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeganFinderApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		// Create an HTTP client engine with full packet sniffing (wiretap) enabled
		HttpClient httpClient = HttpClient.create()
				.wiretap(true);

		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.codecs(configurer -> configurer
						.defaultCodecs()
						.maxInMemorySize(5 * 1024 * 1024)) // Keeps your 5MB buffer size rule intact
				.build();
	}
}
