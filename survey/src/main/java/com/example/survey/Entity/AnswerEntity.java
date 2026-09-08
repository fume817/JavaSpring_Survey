package com.example.survey.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "answer")
@Data

public class AnswerEntity {
	@Id
	private Integer id;

	private String name;

	private String mail;

	@Column(name = "age")
	private Integer ansAge;

	@Column(name = "店舗名")
	private Integer ansStoreID;

	@Column(name = "頻度")
	private Integer ansFrequency;

	@Column(name = "目的")
	private Integer ansPorpose;

	@Column(name = "料理")
	private Integer ansDish;

	@Column(name = "接客")
	private Integer ansService;

	@Column(name = "店内")
	private Integer ansClean;

	@Column(name = "おすすめ")
	private String ansReccomend;

	@Column(name = "意見")
	private String ansOpnion;

	@Column(name = "特別メニュー")
	private Integer ansExMenu;

	@Column(name = "満足度")
	private Integer ansExImpress;

	@Column(name = "取得日時")
	private String ansDate;

}
