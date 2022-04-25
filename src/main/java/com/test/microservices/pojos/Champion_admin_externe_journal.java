package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.test.microservices.enums.TypeChampionAdminExterneJournal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Document("champion_admin_externe_journal")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Champion_admin_externe_journal {
	@Id
	public String idMongo;
	@Field("ID")
	public int id;
	public TypeChampionAdminExterneJournal type;
	public java.util.Date date;
	public int user_id;
	public int champion_id;
	public int club_id;
}
