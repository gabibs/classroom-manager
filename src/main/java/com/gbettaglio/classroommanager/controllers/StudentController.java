package com.gbettaglio.classroommanager.controllers;

import javax.lang.model.element.Name;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	@GetMapping("/") // html
	public String managerForm(Model model) {
		model.addAttribute(""); // data
		return ""; // templates
	}
}