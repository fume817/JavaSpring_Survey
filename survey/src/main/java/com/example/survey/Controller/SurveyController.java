package com.example.survey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.survey.Form.SurveyForm;
import com.example.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;


@Controller

@RequiredArgsConstructor

@RequestMapping("/survey")

public class SurveyController {

	private final SurveyService surveyService;

	@GetMapping
	public String survey(
			@RequestParam(required = true) Integer id, Model model) {

		boolean flag = surveyService.check(id);
		
		model.addAttribute("survey",new SurveyForm());
		model.addAttribute("id",id);
		model.addAttribute("flag",flag);
		return "survey";
	}
	
	@PostMapping("/check")
	public String check(){
		
		return "check";
	}
	
	@PostMapping("/submit")
	public String submit(
			) {
		
		return "thanks";
	}
	
}