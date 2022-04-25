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

import com.test.microservices.pojos.Article;
import com.test.microservices.repositories.ArticleRepository;

@RestController
public class ArticleController {
	ArticleRepository articleRepo;
	public ArticleController(ArticleRepository repo) {
		this.articleRepo=repo;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getArticleByIdMongo/{id}")
public ResponseEntity<Article> getArticle( @PathVariable String id) {
	if(articleRepo.existsByIdMongo(id)) {
		Article ab=articleRepo.findByIdMongo( id);
		return new ResponseEntity<Article>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getArticleById/{id}")
public ResponseEntity<Article> getArticle( @PathVariable int id) {
	if(articleRepo.existsById(id)) {
		Article ab=articleRepo.findById( id);
		return new ResponseEntity<Article>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllArticles")
public ResponseEntity<List<Article>> getArticle( ) {
	List<Article> lab=articleRepo.findAll();
	return new ResponseEntity<List<Article>>(lab,HttpStatus.OK);
}
@PostMapping("/addArticle")
public ResponseEntity<Article> addArticle(@RequestBody Article ab) {
	if(!articleRepo.existsById(ab.getId())) {
		articleRepo.save(ab);
		return new ResponseEntity<Article>(ab,HttpStatus.CREATED);
	}
	return new ResponseEntity<Article>(HttpStatus.CONFLICT);
}
@PutMapping("/updateArticle/{id}")
public ResponseEntity<Article> updateArticle(@PathVariable int id,@RequestBody Article ab) {
	if(articleRepo.existsById(id)) {
		articleRepo.save(ab);
		return new ResponseEntity<Article>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteArticle/{id}")
public ResponseEntity<Article> deleteArticle(@PathVariable int id) {
	if(articleRepo.existsById(id)) {
		Article ab=articleRepo.deleteById(id);
		return new ResponseEntity<Article>(ab,HttpStatus.OK);
	}
	return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
}

}
