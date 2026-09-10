package com.example.survey.service;

import org.springframework.stereotype.Service;

import com.example.survey.DTO.SurveyDTO;
import com.example.survey.repository.AgeRepository;
import com.example.survey.repository.FrequencyRepository;
import com.example.survey.repository.PurposeRepository;
import com.example.survey.repository.StoreNameRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class SurveyService {
	private final StoreNameRepository storeNameRepository;
	private final AgeRepository ageRepository;
	private final FrequencyRepository frequencyRepository;
	private final PurposeRepository purposeRepository;
	
	
	//特別質問が必要な店舗かどうかの確認
	public boolean check(Integer id) {
		Integer tinyint;
		
		tinyint = storeNameRepository.checkFlag(id);
		
		boolean flag;
		
		flag =( tinyint == 1 ?true:false);
		
		return flag;
	}
	
	//アンケートの質問選択肢をすべて格納
	public SurveyDTO putSurveyQuestion(){
		SurveyDTO survey = new SurveyDTO();
		survey.setAgeEntities(ageRepository.findAll());
		survey.setFrequencyEntities(frequencyRepository.findAll());
		survey.setPurposeEntities(purposeRepository.findAll());
		return survey;
	}

	//AnswerEntityの目的にAnswer_Purposeのidを格納する処理
	//Answer_Purposeのカラムに0と1を格納する処理
	//formをEntityにMappingする処理



}
