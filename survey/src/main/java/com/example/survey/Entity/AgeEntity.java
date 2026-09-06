package com.example.survey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "survey_age")
@Data

public class AgeEntity {
	@Id
	@Column(name="表示順")
	private Integer id;

	@Column(name="ラベル")
	private String age;

}
