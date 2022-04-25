package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("images")
@Data @NoArgsConstructor @AllArgsConstructor
public class Image {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Nom;
	public int Champion_id;
	public int Champion2_id;
	public int Evenement_id;
	public int News_id;
	public int Galerie_id;
	public int Technique_id;
	public String Description;
	public Boolean actif;
}
