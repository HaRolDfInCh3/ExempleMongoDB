package com.test.microservices.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.pojos.Champion_popularite1;
import com.test.microservices.repositories.Champion_popularite1Repository;

@RestController
public class Champion_popularite1Controller {
	Champion_popularite1Repository champion_popularite1Repo;
	public Champion_popularite1Controller(Champion_popularite1Repository repo) {
		this.champion_popularite1Repo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampion_popularite1ByIdMongo/{id}")
public ResponseEntity<Champion_popularite1> getChampion_popularite1( @PathVariable String id) {
	if(champion_popularite1Repo.existsByIdMongo(id)) {
		Champion_popularite1 ab=champion_popularite1Repo.findByIdMongo( id);
		return new ResponseEntity<Champion_popularite1>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite1>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampion_popularite1ById/{id}")
public ResponseEntity<Champion_popularite1> getChampion_popularite1( @PathVariable int id) {
	if(champion_popularite1Repo.existsById(id)) {
		Champion_popularite1 ab=champion_popularite1Repo.findById( id);
		return new ResponseEntity<Champion_popularite1>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite1>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampion_popularite1s")
public ResponseEntity<List<Champion_popularite1>> getChampion_popularite1( ) {
	List<Champion_popularite1> lab=champion_popularite1Repo.findAll();
	return new ResponseEntity<List<Champion_popularite1>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion_popularite1")
public ResponseEntity<Champion_popularite1> addChampion_popularite1(@RequestBody Champion_popularite1 ab) {
	if(!champion_popularite1Repo.existsById(ab.getId())) {
		champion_popularite1Repo.save(ab);
		return new ResponseEntity<Champion_popularite1>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion_popularite1>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion_popularite1/{id}")
public ResponseEntity<Champion_popularite1> updateChampion_popularite1(@PathVariable int id,@RequestBody Champion_popularite1 ab) {
	if(champion_popularite1Repo.existsById(id)) {
		champion_popularite1Repo.save(ab);
		return new ResponseEntity<Champion_popularite1>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite1>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion_popularite1/{id}")
public ResponseEntity<Champion_popularite1> deleteChampion_popularite1(@PathVariable int id) {
	if(champion_popularite1Repo.existsById(id)) {
		Champion_popularite1 ab=champion_popularite1Repo.deleteById(id);
		return new ResponseEntity<Champion_popularite1>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite1>(HttpStatus.NOT_FOUND);
}

}
