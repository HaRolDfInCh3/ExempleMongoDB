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

import com.test.microservices.pojos.Grade;
import com.test.microservices.repositories.GradesRepository;

@RestController
public class GradeController {
	GradesRepository gradeRepo;
	public GradeController(GradesRepository repo) {
		this.gradeRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getGradeByIdMongo/{id}")
public ResponseEntity<Grade> getGrade( @PathVariable String id) {
	if(gradeRepo.existsByIdMongo(id)) {
		Grade ab=gradeRepo.findByIdMongo( id);
		return new ResponseEntity<Grade>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getGradeById/{id}")
public ResponseEntity<Grade> getGrade( @PathVariable int id) {
	if(gradeRepo.existsById(id)) {
		Grade ab=gradeRepo.findById( id);
		return new ResponseEntity<Grade>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllGrades")
public ResponseEntity<List<Grade>> getGrade( ) {
	List<Grade> lab=gradeRepo.findAll();
	return new ResponseEntity<List<Grade>>(lab,HttpStatus.OK);
}
@PostMapping("/addGrade")
public ResponseEntity<Grade> addGrade(@RequestBody Grade ab) {
	if(!gradeRepo.existsById(ab.getId())) {
		gradeRepo.save(ab);
		return new ResponseEntity<Grade>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Grade>(HttpStatus.CONFLICT);
}
@PutMapping("/updateGrade/{id}")
public ResponseEntity<Grade> updateGrade(@PathVariable int id,@RequestBody Grade ab) {
	if(gradeRepo.existsById(id)) {
		gradeRepo.save(ab);
		return new ResponseEntity<Grade>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteGrade/{id}")
public ResponseEntity<Grade> deleteGrade(@PathVariable int id) {
	if(gradeRepo.existsById(id)) {
		Grade ab=gradeRepo.deleteById(id);
		return new ResponseEntity<Grade>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
}
}

