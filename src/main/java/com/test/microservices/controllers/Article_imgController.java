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

import com.test.microservices.pojos.Article_img;
import com.test.microservices.repositories.Article_imgRepository;

@RestController
public class Article_imgController {
	Article_imgRepository article_imgRepo;
	public Article_imgController(Article_imgRepository repo) {
		this.article_imgRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getArticle_imgByIdMongo/{id}")
public ResponseEntity<Article_img> getArticle_img( @PathVariable String id) {
	if(article_imgRepo.existsByIdMongo(id)) {
		Article_img ab=article_imgRepo.findByIdMongo( id);
		return new ResponseEntity<Article_img>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article_img>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getArticle_imgById/{id}")
public ResponseEntity<Article_img> getArticle_img( @PathVariable int id) {
	if(article_imgRepo.existsById(id)) {
		Article_img ab=article_imgRepo.findById( id);
		return new ResponseEntity<Article_img>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article_img>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllArticle_imgs")
public ResponseEntity<List<Article_img>> getArticle_img( ) {
	List<Article_img> lab=article_imgRepo.findAll();
	return new ResponseEntity<List<Article_img>>(lab,HttpStatus.OK);
}
@PostMapping("/addArticle_img")
public ResponseEntity<Article_img> addArticle_img(@RequestBody Article_img ab) {
	if(!article_imgRepo.existsById(ab.getId())) {
		article_imgRepo.save(ab);
		return new ResponseEntity<Article_img>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Article_img>(HttpStatus.CONFLICT);
}
@PutMapping("/updateArticle_img/{id}")
public ResponseEntity<Article_img> updateArticle_img(@PathVariable int id,@RequestBody Article_img ab) {
	if(article_imgRepo.existsById(id)) {
		article_imgRepo.save(ab);
		return new ResponseEntity<Article_img>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article_img>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteArticle_img/{id}")
public ResponseEntity<Article_img> deleteArticle_img(@PathVariable int id) {
	if(article_imgRepo.existsById(id)) {
		Article_img ab=article_imgRepo.deleteById(id);
		return new ResponseEntity<Article_img>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article_img>(HttpStatus.NOT_FOUND);
}


}
