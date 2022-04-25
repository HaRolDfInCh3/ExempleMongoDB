package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;
@Document("departements")
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String CP;
	public String NomDepartement;
	public String PaysID;
}
