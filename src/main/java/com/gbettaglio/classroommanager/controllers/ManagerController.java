package com.gbettaglio.classroommanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
	
	@GetMapping("/manager")
	public String managerForm(Model model) {
		model.addAttribute("manager");
		return "manager";
	}
}