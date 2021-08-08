package com.gbettaglio.classroommanager.controllers;

import javax.lang.model.element.Name;

import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.services.CourseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

	@GetMapping("/search") // html
	public String managerForm(Model model) {
		model.addAttribute("search"); // data
		return "search"; // templates
	}
}