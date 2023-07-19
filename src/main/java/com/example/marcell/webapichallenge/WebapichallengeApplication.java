package com.example.marcell.webapichallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) // We dont have a DB and I wanted to run the app.
public class WebapichallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapichallengeApplication.class, args);
	}

}
