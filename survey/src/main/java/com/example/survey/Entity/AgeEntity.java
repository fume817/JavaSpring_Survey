package com.example.survey.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "survey_age")
@Data

public class AgeEntity {
	@Id
	private Integer id;

	private String age;

}
