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

import com.test.microservices.pojos.Club_admin_externe;
import com.test.microservices.repositories.Club_admin_externeRepository;
@RestController
public class Club_admin_externeController {
	Club_admin_externeRepository club_admin_externeRepo;
	public Club_admin_externeController(Club_admin_externeRepository repo) {
		this.club_admin_externeRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClub_admin_externeByIdMongo/{id}")
public ResponseEntity<Club_admin_externe> getClub_admin_externe( @PathVariable String id) {
	if(club_admin_externeRepo.existsByIdMongo(id)) {
		Club_admin_externe ab=club_admin_externeRepo.findByIdMongo( id);
		return new ResponseEntity<Club_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClub_admin_externeById/{id}")
public ResponseEntity<Club_admin_externe> getClub_admin_externe( @PathVariable int id) {
	if(club_admin_externeRepo.existsById(id)) {
		Club_admin_externe ab=club_admin_externeRepo.findById( id);
		return new ResponseEntity<Club_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClub_admin_externes")
public ResponseEntity<List<Club_admin_externe>> getClub_admin_externe( ) {
	List<Club_admin_externe> lab=club_admin_externeRepo.findAll();
	return new ResponseEntity<List<Club_admin_externe>>(lab,HttpStatus.OK);
}
@PostMapping("/addClub_admin_externe")
public ResponseEntity<Club_admin_externe> addClub_admin_externe(@RequestBody Club_admin_externe ab) {
	if(!club_admin_externeRepo.existsById(ab.getId())) {
		club_admin_externeRepo.save(ab);
		return new ResponseEntity<Club_admin_externe>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Club_admin_externe>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub_admin_externe/{id}")
public ResponseEntity<Club_admin_externe> updateClub_admin_externe(@PathVariable int id,@RequestBody Club_admin_externe ab) {
	if(club_admin_externeRepo.existsById(id)) {
		club_admin_externeRepo.save(ab);
		return new ResponseEntity<Club_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub_admin_externe/{id}")
public ResponseEntity<Club_admin_externe> deleteClub_admin_externe(@PathVariable int id) {
	if(club_admin_externeRepo.existsById(id)) {
		Club_admin_externe ab=club_admin_externeRepo.deleteById(id);
		return new ResponseEntity<Club_admin_externe>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_admin_externe>(HttpStatus.NOT_FOUND);
}


}
