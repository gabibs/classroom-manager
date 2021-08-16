package com.gbettaglio.classroommanager.controllers;

import com.gbettaglio.classroommanager.entities.Classroom;
import com.gbettaglio.classroommanager.services.ClassroomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassroomController {

	@Autowired
	ClassroomService classroomService;

	@GetMapping("/classroom") // html
	public String managerForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
		if (id != null) {
			model.addAttribute("classroom", classroomService.findClassroom(id));
		} else {
			model.addAttribute("classroom", new Classroom()); // data
		}
		model.addAttribute("classrooms", classroomService.findAllClassrooms());
		return "classroom"; // template
	}

	// modificar/guardar nuevo
	@PostMapping("/classroom")
	public String classroomSubmit(@RequestParam(name = "id", required = false) Integer id,
			@ModelAttribute Classroom classroom, Model model) {
		if (id != null) {
			classroom.setId(id);
		}
		classroomService.saveClassroom(classroom);
		model.addAttribute("classroom", new Classroom()); // data
		List<Classroom> allClassrooms = classroomService.findAllClassrooms();
		model.addAttribute("classrooms", allClassrooms);
		return "classroom";
	}

	// eliminar
	@GetMapping("/deleteClassroom/{id}")
	public String classroomDelete(@PathVariable Integer id, Model model) {
		classroomService.deleteClassroom(id);
		model.addAttribute("classroom", new Classroom()); // data
		List<Classroom> allClassrooms = classroomService.findAllClassrooms();
		model.addAttribute("classrooms", allClassrooms);
		return "classroom";
	}
}
