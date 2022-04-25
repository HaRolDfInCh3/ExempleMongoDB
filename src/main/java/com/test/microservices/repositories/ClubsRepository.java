package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Club;

public interface ClubsRepository extends MongoRepository<Club, String> {
	public Club findById(int id2);
	public Boolean existsById(int id2);
	public Club findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Club deleteById(int id2);
}
