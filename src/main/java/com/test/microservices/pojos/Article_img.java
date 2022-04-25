package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("article_img")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Article_img {
	@Id
	private String idMongo;
	@Field("id")
	public int id;
	public int id_art;
	public String nom;
}
