package com.example.survey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="survey_purpose")
@Data

public class PurposeEntity {
	@Id
	private Integer id;
	
	@Column(name="目的名")
	private String purpose;
}
