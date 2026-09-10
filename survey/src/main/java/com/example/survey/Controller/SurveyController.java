package com.example.survey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.survey.DTO.SurveyDTO;
import com.example.survey.Form.SurveyForm;
import com.example.survey.service.SurveyService;

import jakarta.validation.Valid;
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

		//店舗IDだけ先に詰めておく
		SurveyForm form = new SurveyForm();
		form.setAnsStoreID(id);

		model.addAttribute("survey", form);
		model.addAttribute("Lists", surveyQuestion());
		model.addAttribute("id", id);
		model.addAttribute("flag", flag);
		return "survey";
	}

	@PostMapping("/check")
	public String check(@Valid @ModelAttribute("survey") SurveyForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("survey",form);
			model.addAttribute("Lists",surveyQuestion());
			return "survey";
		}
		return "check";
	}

	@PostMapping("/submit")
	public String submit() {

		return "thanks";
	}
	
	//質問の選択肢をすべて格納
	public SurveyDTO surveyQuestion() {
		SurveyDTO surveyQuestion = surveyService.putSurveyQuestion();
		return surveyQuestion;
	}

}