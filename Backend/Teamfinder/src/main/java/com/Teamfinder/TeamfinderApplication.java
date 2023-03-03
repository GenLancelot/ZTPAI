package com.Teamfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TeamfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamfinderApplication.class, args);
	}

}
