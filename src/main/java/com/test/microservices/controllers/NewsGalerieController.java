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

import com.test.microservices.pojos.News_galerie;
import com.test.microservices.repositories.News_galerieRepository;
@RestController
public class NewsGalerieController {
	News_galerieRepository newsgalerieRepo;
	public NewsGalerieController(News_galerieRepository repo) {
		this.newsgalerieRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNews_galerieByIdMongo/{id}")
public ResponseEntity<News_galerie> getNews_galerie( @PathVariable String id) {
	if(newsgalerieRepo.existsByIdMongo(id)) {
		News_galerie ab=newsgalerieRepo.findByIdMongo( id);
		return new ResponseEntity<News_galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNews_galerieById/{id}")
public ResponseEntity<News_galerie> getNews_galerie( @PathVariable int id) {
	if(newsgalerieRepo.existsById(id)) {
		News_galerie ab=newsgalerieRepo.findById( id);
		return new ResponseEntity<News_galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerie>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNews_galeries")
public ResponseEntity<List<News_galerie>> getNews_galerie( ) {
	List<News_galerie> lab=newsgalerieRepo.findAll();
	return new ResponseEntity<List<News_galerie>>(lab,HttpStatus.OK);
}
@PostMapping("/addNews_galerie")
public ResponseEntity<News_galerie> addNews_galerie(@RequestBody News_galerie ab) {
	if(!newsgalerieRepo.existsById(ab.getId())) {
		newsgalerieRepo.save(ab);
		return new ResponseEntity<News_galerie>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<News_galerie>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNews_galerie/{id}")
public ResponseEntity<News_galerie> updateNews_galerie(@PathVariable int id,@RequestBody News_galerie ab) {
	if(newsgalerieRepo.existsById(id)) {
		newsgalerieRepo.save(ab);
		return new ResponseEntity<News_galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerie>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNews_galerie/{id}")
public ResponseEntity<News_galerie> deleteNews_galerie(@PathVariable int id) {
	if(newsgalerieRepo.existsById(id)) {
		News_galerie ab=newsgalerieRepo.deleteById(id);
		return new ResponseEntity<News_galerie>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerie>(HttpStatus.NOT_FOUND);
}


}
