package com.gbettaglio.classroommanager.controllers;


import com.gbettaglio.classroommanager.entities.Classroom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClassroomController {
	
	@GetMapping("/classroom") //html
	public String managerForm(Model model) {
		model.addAttribute("classroom"); //data
		return "classroom"; //templates
	}

    @PostMapping("/classroom")
	public Integer classroomSubmit(@ModelAttribute Classroom classroom, Integer id, Integer capacity) {

        Classroom.setCapacity(capacity);
        return null;
		
	}
}

