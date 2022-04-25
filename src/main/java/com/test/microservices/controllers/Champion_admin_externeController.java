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

import com.test.microservices.pojos.Champion_admin_externe;
import com.test.microservices.repositories.ChampionAdminExterneRepository;
@RestController
public class Champion_admin_externeController {
	ChampionAdminExterneRepository cAERepo;
	public Champion_admin_externeController(ChampionAdminExterneRepository repo) {
		this.cAERepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampion_admin_externeByIdMongo/{id}")
public ResponseEntity<Champion_admin_externe> getChampion_admin_externe( @PathVariable String id) {
	if(cAERepo.existsByIdMongo(id)) {
		Champion_admin_externe ab=cAERepo.findByIdMongo( id);
		return new ResponseEntity<Champion_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampion_admin_externeById/{id}")
public ResponseEntity<Champion_admin_externe> getChampion_admin_externe( @PathVariable int id) {
	if(cAERepo.existsById(id)) {
		Champion_admin_externe ab=cAERepo.findById( id);
		return new ResponseEntity<Champion_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampion_admin_externes")
public ResponseEntity<List<Champion_admin_externe>> getChampion_admin_externe( ) {
	List<Champion_admin_externe> lab=cAERepo.findAll();
	return new ResponseEntity<List<Champion_admin_externe>>(lab,HttpStatus.OK);
}
@PostMapping("/addChampion_admin_externe")
public ResponseEntity<Champion_admin_externe> addChampion_admin_externe(@RequestBody Champion_admin_externe ab) {
	if(!cAERepo.existsById(ab.getId())) {
		cAERepo.save(ab);
		return new ResponseEntity<Champion_admin_externe>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Champion_admin_externe>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion_admin_externe/{id}")
public ResponseEntity<Champion_admin_externe> updateChampion_admin_externe(@PathVariable int id,@RequestBody Champion_admin_externe ab) {
	if(cAERepo.existsById(id)) {
		cAERepo.save(ab);
		return new ResponseEntity<Champion_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion_admin_externe/{id}")
public ResponseEntity<Champion_admin_externe> deleteChampion_admin_externe(@PathVariable int id) {
	if(cAERepo.existsById(id)) {
		Champion_admin_externe ab=cAERepo.deleteById(id);
		return new ResponseEntity<Champion_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Champion_admin_externe>(HttpStatus.NOT_FOUND);
}


}
