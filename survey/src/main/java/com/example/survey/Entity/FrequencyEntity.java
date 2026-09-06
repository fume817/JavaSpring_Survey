package com.example.survey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="survey_frequency")
@Data

public class FrequencyEntity {
	@Id
	private Integer id;
	
	@Column(name="ラベル")
	private String frequency;
}
