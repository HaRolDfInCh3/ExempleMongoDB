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

import com.test.microservices.pojos.Club_judoka;
import com.test.microservices.repositories.Club_JudokaRepository;
@RestController
public class Club_judokasController {
	Club_JudokaRepository club_judokasRepo;
	public Club_judokasController(Club_JudokaRepository repo) {
		this.club_judokasRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClub_judokasByIdMongo/{id}")
public ResponseEntity<Club_judoka> getClub_judokas( @PathVariable String id) {
	if(club_judokasRepo.existsByIdMongo(id)) {
		Club_judoka ab=club_judokasRepo.findByIdMongo( id);
		return new ResponseEntity<Club_judoka>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_judoka>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClub_judokasById/{id}")
public ResponseEntity<Club_judoka> getClub_judokas( @PathVariable int id) {
	if(club_judokasRepo.existsById(id)) {
		Club_judoka ab=club_judokasRepo.findById( id);
		return new ResponseEntity<Club_judoka>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_judoka>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClub_judokass")
public ResponseEntity<List<Club_judoka>> getClub_judokas( ) {
	List<Club_judoka> lab=club_judokasRepo.findAll();
	return new ResponseEntity<List<Club_judoka>>(lab,HttpStatus.OK);
}
@PostMapping("/addClub_judokas")
public ResponseEntity<Club_judoka> addClub_judokas(@RequestBody Club_judoka ab) {
	if(!club_judokasRepo.existsById(ab.getId())) {
		club_judokasRepo.save(ab);
		return new ResponseEntity<Club_judoka>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Club_judoka>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub_judokas/{id}")
public ResponseEntity<Club_judoka> updateClub_judokas(@PathVariable int id,@RequestBody Club_judoka ab) {
	if(club_judokasRepo.existsById(id)) {
		club_judokasRepo.save(ab);
		return new ResponseEntity<Club_judoka>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_judoka>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub_judokas/{id}")
public ResponseEntity<Club_judoka> deleteClub_judokas(@PathVariable int id) {
	if(club_judokasRepo.existsById(id)) {
		Club_judoka ab=club_judokasRepo.deleteById(id);
		return new ResponseEntity<Club_judoka>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_judoka>(HttpStatus.NOT_FOUND);
}


}
