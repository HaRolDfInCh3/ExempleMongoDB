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

import com.test.microservices.pojos.Formulaire;
import com.test.microservices.repositories.FormulaireRepository;
@RestController
public class FormulaireController {
	FormulaireRepository formulaireRepo;
	public FormulaireController(FormulaireRepository repo) {
		this.formulaireRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getFormulaireByIdMongo/{id}")
public ResponseEntity<Formulaire> getFormulaire( @PathVariable String id) {
	if(formulaireRepo.existsByIdMongo(id)) {
		Formulaire ab=formulaireRepo.findByIdMongo( id);
		return new ResponseEntity<Formulaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Formulaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getFormulaireById/{id}")
public ResponseEntity<Formulaire> getFormulaire( @PathVariable int id) {
	if(formulaireRepo.existsById(id)) {
		Formulaire ab=formulaireRepo.findById( id);
		return new ResponseEntity<Formulaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Formulaire>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllFormulaires")
public ResponseEntity<List<Formulaire>> getFormulaire( ) {
	List<Formulaire> lab=formulaireRepo.findAll();
	return new ResponseEntity<List<Formulaire>>(lab,HttpStatus.OK);
}
@PostMapping("/addFormulaire")
public ResponseEntity<Formulaire> addFormulaire(@RequestBody Formulaire ab) {
	if(!formulaireRepo.existsById(ab.getId())) {
		formulaireRepo.save(ab);
		return new ResponseEntity<Formulaire>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Formulaire>(HttpStatus.CONFLICT);
}
@PutMapping("/updateFormulaire/{id}")
public ResponseEntity<Formulaire> updateFormulaire(@PathVariable int id,@RequestBody Formulaire ab) {
	if(formulaireRepo.existsById(id)) {
		formulaireRepo.save(ab);
		return new ResponseEntity<Formulaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Formulaire>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteFormulaire/{id}")
public ResponseEntity<Formulaire> deleteFormulaire(@PathVariable int id) {
	if(formulaireRepo.existsById(id)) {
		Formulaire ab=formulaireRepo.deleteById(id);
		return new ResponseEntity<Formulaire>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Formulaire>(HttpStatus.NOT_FOUND);
}


}
