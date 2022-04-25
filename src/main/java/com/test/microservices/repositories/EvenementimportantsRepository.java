package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evenementimportants;

public interface EvenementimportantsRepository extends MongoRepository<Evenementimportants, String> {
	public Evenementimportants findById(int id2);
	public Boolean existsById(int id2);
	public Evenementimportants findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evenementimportants deleteById(int id2);
}
