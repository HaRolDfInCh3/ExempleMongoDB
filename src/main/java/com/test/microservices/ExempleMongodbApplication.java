package com.test.microservices;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
@SpringBootApplication

public class ExempleMongodbApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(ExempleMongodbApplication.class, args);
	}
	
public void run(String... args) throws ParseException {
		
		
	System.out.println("Tous les rest controllers ont étés exposés !");
    }

}
