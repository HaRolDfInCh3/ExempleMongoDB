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

@Document("champion_popularite")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Champion_popularite {
	@Id
	public String idMongo;
	@Field("id")
	public int id;
	public int champion_id;
	public int user_id;
	public java.util.Date date;
	public String ip;
	public String user_agent;
	public String host;
}
