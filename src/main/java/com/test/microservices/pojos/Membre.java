package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("membre")
@Data @NoArgsConstructor @AllArgsConstructor
public class Membre {
	@Id
	private String idMongo;
	@Field("user_id")
	public int id;
	public String date_naissance;
	public java.util.Date date_naissance2;
	public String grade;
	public String ville;
	public String CP;
	public String pays;
	public String gcoo1;
	public String gcoo2;
	public String gaddress;
}
