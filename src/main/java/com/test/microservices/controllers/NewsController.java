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

import com.test.microservices.pojos.News;
import com.test.microservices.repositories.NewsRepository;
@RestController
public class NewsController {
	NewsRepository newsRepo;
	public NewsController(NewsRepository repo) {
		this.newsRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNewsByIdMongo/{id}")
public ResponseEntity<News> getNews( @PathVariable String id) {
	if(newsRepo.existsByIdMongo(id)) {
		News ab=newsRepo.findByIdMongo( id);
		return new ResponseEntity<News>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNewsById/{id}")
public ResponseEntity<News> getNews( @PathVariable int id) {
	if(newsRepo.existsById(id)) {
		News ab=newsRepo.findById( id);
		return new ResponseEntity<News>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNewss")
public ResponseEntity<List<News>> getNews( ) {
	List<News> lab=newsRepo.findAll();
	return new ResponseEntity<List<News>>(lab,HttpStatus.OK);
}
@PostMapping("/addNews")
public ResponseEntity<News> addNews(@RequestBody News ab) {
	if(!newsRepo.existsById(ab.getId())) {
		newsRepo.save(ab);
		return new ResponseEntity<News>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<News>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNews/{id}")
public ResponseEntity<News> updateNews(@PathVariable int id,@RequestBody News ab) {
	if(newsRepo.existsById(id)) {
		newsRepo.save(ab);
		return new ResponseEntity<News>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNews/{id}")
public ResponseEntity<News> deleteNews(@PathVariable int id) {
	if(newsRepo.existsById(id)) {
		News ab=newsRepo.deleteById(id);
		return new ResponseEntity<News>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
}


}
