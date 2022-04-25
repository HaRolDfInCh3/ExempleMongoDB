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

@Document("abonnement")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Abonnement {
	@Id
	public String idMongo;
	@Field("id")
	private int id;
	public int user;
	public int champion;
	public java.util.Date date_creation;
}
