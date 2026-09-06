package com.example.survey.service;

import org.springframework.stereotype.Service;

import com.example.survey.repository.StoreNameRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class SurveyService {
	private final StoreNameRepository storeNameRepository;
	
	public boolean check(Integer id) {
		Integer tinyint;
		
		tinyint = storeNameRepository.checkFlag(id);
		
		boolean flag;
		
		flag =( tinyint == 1 ?true:false);
		
		return flag;
	}
}
