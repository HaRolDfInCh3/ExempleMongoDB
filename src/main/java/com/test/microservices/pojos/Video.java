package com.test.microservices.pojos;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.test.microservices.enums.Sexe;

import com.test.microservices.enums.VideoCategorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Document("videos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Video {
	@Id
	private String idMongo;
	@Field("ID")
	public int id;
	public String Titre;
	public java.util.Date date;
	public String Duree;
	public String Objet;
	public VideoCategorie Categorie;
	public String Vignette;
	public Boolean A_la_une;
	public int Champion_id;
	public int Technique_id;
	public int Technique2_id;
	public int Evenement_id;
	public String PoidID;
	public Sexe Sexe;
	public Boolean top_ippon;

}