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

import com.test.microservices.pojos.Champion_popularite;
import com.test.microservices.repositories.Champion_populariteRepository;

@RestController
public class Champion_populariteController {
	Champion_populariteRepository champion_populariteRepo;
	public Champion_populariteController(Champion_populariteRepository repo) {
		this.champion_populariteRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampion_populariteByIdMongo/{id}")
public ResponseEntity<Champion_popularite> getChampion_popularite( @PathVariable String id) {
	if(champion_populariteRepo.existsByIdMongo(id)) {
		Champion_popularite ab=champion_populariteRepo.findByIdMongo( id);
		return new ResponseEntity<Champion_popularite>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampion_populariteById/{id}")
public ResponseEntity<Champion_popularite> getChampion_popularite( @PathVariable int id) {
	if(champion_populariteRepo.existsById(id)) {
		Champion_popularite ab=champion_populariteRepo.findById( id);
		return new ResponseEntity<Champion_popularite>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampion_popularites")
public ResponseEntity<List<Champion_popularite>> getChampion_popularite( ) {
	List<Champion_popularite> lab=champion_populariteRepo.findAll();
	return new ResponseEntity<List<Champion_popularite>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion_popularite")
public ResponseEntity<Champion_popularite> addChampion_popularite(@RequestBody Champion_popularite ab) {
	if(!champion_populariteRepo.existsById(ab.getId())) {
		champion_populariteRepo.save(ab);
		return new ResponseEntity<Champion_popularite>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion_popularite>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion_popularite/{id}")
public ResponseEntity<Champion_popularite> updateChampion_popularite(@PathVariable int id,@RequestBody Champion_popularite ab) {
	if(champion_populariteRepo.existsById(id)) {
		champion_populariteRepo.save(ab);
		return new ResponseEntity<Champion_popularite>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion_popularite/{id}")
public ResponseEntity<Champion_popularite> deleteChampion_popularite(@PathVariable int id) {
	if(champion_populariteRepo.existsById(id)) {
		Champion_popularite ab=champion_populariteRepo.deleteById(id);
		return new ResponseEntity<Champion_popularite>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_popularite>(HttpStatus.NOT_FOUND);
}


}
