package com.example.survey.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="survey_storeName")
@Data

//店舗名のエンティティ
public class StoreNameEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String shopName;
	
	private Integer flag;
}
