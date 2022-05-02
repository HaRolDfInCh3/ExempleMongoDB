package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Departement;

public interface DepartementsRepository extends MongoRepository<Departement, String> {
	public Departement findById(int id2);
	public Boolean existsByNomDepartement(String nom);
	public Boolean existsByCp(String cp);
	public Boolean existsById(int id2);
	public Departement findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Departement deleteById(int id2);
}
