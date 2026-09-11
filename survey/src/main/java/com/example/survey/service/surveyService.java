package com.example.survey.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.survey.DTO.SurveyDTO;
import com.example.survey.Entity.AnswerEntity;
import com.example.survey.Form.SurveyForm;
import com.example.survey.repository.AgeRepository;
import com.example.survey.repository.AnswerRepository;
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
	private final AnswerRepository answerRepository;

	//特別質問が必要な店舗かどうかの確認
	public boolean check(Integer id) {
		Integer tinyint;

		tinyint = storeNameRepository.checkFlag(id);
		
		if (tinyint == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "店舗が見つかりません");
	    }

		boolean flag;

		flag = (tinyint == 1 ? true : false);

		return flag;
	}

	//アンケートの質問選択肢をすべて格納
	public SurveyDTO putSurveyQuestion() {
		SurveyDTO survey = new SurveyDTO();
		survey.setAgeEntities(ageRepository.findAll());
		survey.setFrequencyEntities(frequencyRepository.findAll());
		survey.setPurposeEntities(purposeRepository.findAll());
		return survey;
	}

	//時刻の取得処理
	private String getTime() {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy'/'MM'/'dd' 'HH':'mm':'ss");
		String nowDate = format.format(date);

		return nowDate;
	}

	//目的をstringにする処理
	private String ListToString(SurveyForm survey) {
		List<Integer> purposeList = survey.getAnsPurpose();
		String result = purposeList.stream().map(String::valueOf).collect(Collectors.joining(","));
		return result;
	}
	//formをEntityにMappingする処理
	public AnswerEntity Mapping(SurveyForm survey) {
		
		String time = getTime();
		String purpose = ListToString(survey);
		AnswerEntity answer = new AnswerEntity();
		
		ModelMapper mapping = new ModelMapper();
		survey.checkEx();
		mapping.map(survey,answer);
		
		answer.setAnsDate(time);
		answer.setAnsStringPurpose(purpose);
		answer.setId(null);
		return answer;
		
	}
	//保存処理
	public void saveAnswer(AnswerEntity answer) {
		answerRepository.save(answer);
	}
}
