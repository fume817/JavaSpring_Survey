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
import com.example.survey.Entity.AnswerEntity;
import com.example.survey.Form.SurveyForm;
import com.example.survey.service.SurveyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor

@RequestMapping("/survey")

public class SurveyController {

	private final SurveyService surveyService;

	//アンケートフォーム
	@GetMapping
	public String survey(
			@RequestParam(required = true) Integer id, Model model) {

		boolean flag = surveyService.check(id);

		//店舗IDだけ先に詰めておく
		SurveyForm form = new SurveyForm();
		form.setAnsStoreID(id);
		form.setFlag(flag);

		model.addAttribute("survey", form);
		model.addAttribute("Lists", surveyQuestion());

		return "survey";
	}

	//確認画面
	@PostMapping("/check")
	public String check(@Valid @ModelAttribute("survey") SurveyForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			String alert = "入力内容に誤りがあります";
			System.out.println(result.getAllErrors());
			model.addAttribute("survey", form);
			model.addAttribute("Lists", surveyQuestion());
			model.addAttribute("alert", alert);
			return "survey";
		} else if (surveyService.mailCheck(form)) {
			String alert ="本日は回答済みです";
			model.addAttribute("Lists", surveyQuestion());
			model.addAttribute("alert", alert);
			return "survey";
		}
		model.addAttribute("survey", form);
		model.addAttribute("Lists", surveyQuestion());
		return "check";
	}

	//書き直し画面への遷移
	@PostMapping("/reInput")
	public String reInput(@ModelAttribute("survey") SurveyForm form, Model model) {
		model.addAttribute("survey", form);
		model.addAttribute("Lists", surveyQuestion());
		return "survey";
	}

	//送信処理
	@PostMapping("/submit")
	public String submit(@Valid @ModelAttribute("survey") SurveyForm form,
			BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			String alert = "入力内容に誤りがあります";
			System.out.println(result.getAllErrors());
			model.addAttribute("survey", form);
			model.addAttribute("Lists", surveyQuestion());
			model.addAttribute("alert", alert);
			return "survey";
		} else if (surveyService.mailCheck(form)) {
			String alert ="本日は回答済みです";
			model.addAttribute("Lists", surveyQuestion());
			model.addAttribute("alert", alert);
			return "survey";
		}
		AnswerEntity answer = surveyService.Mapping(form);
		surveyService.saveAnswer(answer);

		return "redirect:/survey/done";
	}

	//アンケート完了後にページ更新を入れると再度投稿されてしまう不具合の解決
	@GetMapping("/done")
	public String done() {
		return "thanks";
	}

	//質問の選択肢をすべて格納
	public SurveyDTO surveyQuestion() {
		SurveyDTO surveyQuestion = surveyService.putSurveyQuestion();
		return surveyQuestion;
	}

}