package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Grade;

public interface GradesRepository extends MongoRepository<Grade, String> {
	public Grade findById(int id2);
	public Boolean existsById(int id2);
	public Grade findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Grade deleteById(int id2);
}
