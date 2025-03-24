package com.kidami.webapp;

import com.kidami.webapp.repository.CustomProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Data
@SpringBootApplication
public class WebappApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private CustomProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		System.out.println(properties.getApiUrl());
	}*/

}
