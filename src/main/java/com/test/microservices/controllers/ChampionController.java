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

import com.test.microservices.pojos.Champion;
import com.test.microservices.repositories.ChampionRepository;

@RestController
public class ChampionController {
	ChampionRepository championRepo;
	public ChampionController(ChampionRepository repo) {
		this.championRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampionByIdMongo/{id}")
public ResponseEntity<Champion> getChampion( @PathVariable String id) {
	if(championRepo.existsByIdMongo(id)) {
		Champion ab=championRepo.findByIdMongo( id);
		return new ResponseEntity<Champion>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampionById/{id}")
public ResponseEntity<Champion> getChampion( @PathVariable int id) {
	if(championRepo.existsById(id)) {
		Champion ab=championRepo.findById( id);
		return new ResponseEntity<Champion>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampions")
public ResponseEntity<List<Champion>> getChampion( ) {
	List<Champion> lab=championRepo.findAll();
	return new ResponseEntity<List<Champion>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion")
public ResponseEntity<Champion> addChampion(@RequestBody Champion ab) {
	if(!championRepo.existsById(ab.getId())) {
		championRepo.save(ab);
		return new ResponseEntity<Champion>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion/{id}")
public ResponseEntity<Champion> updateChampion(@PathVariable int id,@RequestBody Champion ab) {
	if(championRepo.existsById(id)) {
		championRepo.save(ab);
		return new ResponseEntity<Champion>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion/{id}")
public ResponseEntity<Champion> deleteChampion(@PathVariable int id) {
	if(championRepo.existsById(id)) {
		Champion ab=championRepo.deleteById(id);
		return new ResponseEntity<Champion>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion>(HttpStatus.NOT_FOUND);
}


}
