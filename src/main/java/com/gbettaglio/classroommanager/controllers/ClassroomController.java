package com.gbettaglio.classroommanager.controllers;

import com.gbettaglio.classroommanager.entities.Classroom;
import com.gbettaglio.classroommanager.services.ClassroomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClassroomController {

	@Autowired
	ClassroomService classroomService;
	private Model model;

	@GetMapping("/classroom") // html
	public String managerForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
		if (id != null) {
			model.addAttribute("classroom", classroomService.findClassroom(id));
		} else {
			model.addAttribute("classroom", new Classroom());
		}
		model.addAttribute("classrooms", classroomService.findAllClassrooms());
		return "classroom"; // template
	}

	// modificar/guardar nuevo
	@PostMapping("/classroom")
	public String classroomSubmit(@ModelAttribute Classroom classroom) {
		classroomService.saveClassroom(classroom);
		model.addAttribute("classroom", new ClassroomService());
		List<Classroom> allClassrooms = classroomService.findAllClassrooms();
		model.addAttribute("classrooms", allClassrooms);
		return "classroom";
	}

	// eliminar
	@PostMapping("/deleteClassroom/{id}")
	public String classroomDelete(@PathVariable Integer id, Model model) {
		classroomService.deleteClassroom(id);
		model.addAttribute("classroom", new Classroom()); // data
		List<Classroom> allClassrooms = classroomService.findAllClassrooms();
		model.addAttribute("classrooms", allClassrooms);
		return "classroom";
	}
}
