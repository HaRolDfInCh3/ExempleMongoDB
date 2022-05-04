package com.test.microservices;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;







@EnableMongoRepositories
@SpringBootApplication

public class ExempleMongodbApplication implements CommandLineRunner{
	@Autowired
	MongoTemplate template;
	public static void main(String[] args) {
		SpringApplication.run(ExempleMongodbApplication.class, args);
	}
	
public void run(String... args) throws Exception{

	System.out.println("Tous les rest controllers ont étés exposés ...");
	//v.check();
    }


}
