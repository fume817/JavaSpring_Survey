package com.example.survey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

//@RequiredArgsConstructor

public class SurveyController{
	
	@GetMapping("/survey")
	public String survey(
			@RequestParam(required = true) Integer id,
			Model model
			) {
		
		return null;
	}
}