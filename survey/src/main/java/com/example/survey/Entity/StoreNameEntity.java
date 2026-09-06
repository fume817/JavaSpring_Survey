package com.example.survey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="survey_storename")
@Data

//店舗名のエンティティ
public class StoreNameEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="店舗名")
	private String shopName;
	
	@Column(name="Exmenu")
	private Integer flag;
}
