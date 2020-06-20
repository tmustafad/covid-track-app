package com.turkmen.covidtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTrackApplication.class, args);
	}

}
