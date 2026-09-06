package com.example.survey.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="survey_purpose")
@Data

public class PurposeEntity {
	@Id
	private Integer id;
	
	private String purpose;
}
