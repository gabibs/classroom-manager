package com.gbettaglio.classroommanager.controllers;

import com.gbettaglio.classroommanager.entities.Classroom;
import com.gbettaglio.classroommanager.services.ClassroomService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClassroomController {

	private ClassroomService classroomService;
	private Model model;

	@GetMapping("/classroom") // html
	public String managerForm(Model model) {
		model.addAttribute("classroom"); // data
		return "classroom"; // template
	}

	// modificar/guardar nuevo
	@PostMapping("/classroom")
	public String classroomSubmit(@ModelAttribute Classroom classroom) {
		classroomService.saveClassroom(classroom);
		model.addAttribute("classroom", new ClassroomService());
		return "classroom";
	}

	// eliminar
	@PostMapping("/classroom")
	public String classroomDelete(@ModelAttribute Classroom classroom) {
		classroomService.deleteClassroom(classroom);
		return "classroom";
	}
}
