package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("evenementimportantdirect")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evenementimportantdirect {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public java.util.Date date;
	public String admin;
	public String titre;
	public String texte;
	public int evenement_important_id;
	public Boolean une;
}
