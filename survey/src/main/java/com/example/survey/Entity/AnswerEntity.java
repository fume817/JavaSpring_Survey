package com.example.survey.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="answer")
@Data

public class AnswerEntity {
@Id
private Integer id;

private String mail;

private Integer ansAge;

private Integer ansStoreName;

private Integer ansFrequency;

private Integer ansPorpose;

private Integer ansDish;

private Integer ansService;

private Integer ansClean;

private String ansReccomend;

private String ansOpnion;

private Integer ansExMenu;

private Integer ansExImpress;

private String ansDate;

}
