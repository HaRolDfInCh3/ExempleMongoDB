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

import com.test.microservices.pojos.Club_horaire;
import com.test.microservices.repositories.Club_horairesRepository;
@RestController
public class Club_horairesController {
	Club_horairesRepository club_horairesRepo;
	public Club_horairesController(Club_horairesRepository repo) {
		this.club_horairesRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClub_horairesByIdMongo/{id}")
public ResponseEntity<Club_horaire> getClub_horaires( @PathVariable String id) {
	if(club_horairesRepo.existsByIdMongo(id)) {
		Club_horaire ab=club_horairesRepo.findByIdMongo( id);
		return new ResponseEntity<Club_horaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_horaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClub_horairesById/{id}")
public ResponseEntity<Club_horaire> getClub_horaires( @PathVariable int id) {
	if(club_horairesRepo.existsById(id)) {
		Club_horaire ab=club_horairesRepo.findById( id);
		return new ResponseEntity<Club_horaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_horaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClub_horairess")
public ResponseEntity<List<Club_horaire>> getClub_horaires( ) {
	List<Club_horaire> lab=club_horairesRepo.findAll();
	return new ResponseEntity<List<Club_horaire>>(lab,HttpStatus.OK);
}
@PostMapping("/addClub_horaires")
public ResponseEntity<Club_horaire> addClub_horaires(@RequestBody Club_horaire ab) {
	if(!club_horairesRepo.existsById(ab.getId())) {
		club_horairesRepo.save(ab);
		return new ResponseEntity<Club_horaire>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Club_horaire>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub_horaires/{id}")
public ResponseEntity<Club_horaire> updateClub_horaires(@PathVariable int id,@RequestBody Club_horaire ab) {
	if(club_horairesRepo.existsById(id)) {
		club_horairesRepo.save(ab);
		return new ResponseEntity<Club_horaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_horaire>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub_horaires/{id}")
public ResponseEntity<Club_horaire> deleteClub_horaires(@PathVariable int id) {
	if(club_horairesRepo.existsById(id)) {
		Club_horaire ab=club_horairesRepo.deleteById(id);
		return new ResponseEntity<Club_horaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Club_horaire>(HttpStatus.NOT_FOUND);
}


}
