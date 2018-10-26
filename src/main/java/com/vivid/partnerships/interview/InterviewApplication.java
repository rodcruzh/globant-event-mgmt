package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@SpringBootApplication
public class InterviewApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		LOGGER.info("Creating events table");

		jdbcTemplate.execute("CREATE TABLE venue(" +
				"id SERIAL, name VARCHAR(255), city VARCHAR(100), state VARCHAR(100))");

		jdbcTemplate.update("INSERT INTO venue(id, name, city, state) VALUES (?, ?, ?, ?)",
				1, "Wrigley Field", "Chicago", "IL");

		jdbcTemplate.execute("CREATE TABLE events(" +
				"id SERIAL, name VARCHAR(255), date DATE, id_venue INTEGER)");

		jdbcTemplate.update("INSERT INTO events(name, date, id_venue) VALUES (?, ?, ?)",
				"Chicago White Sox vs. Chicago Cubs", new Date(), 1);
	}

}
