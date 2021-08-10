package com.gbettaglio.classroommanager.controllers;

import java.util.List;

import javax.lang.model.element.Name;

import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.services.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	private StudentService studentService;
	private Model model;

	@GetMapping("/student") // html
	public String managerForm(Model model) {
		model.addAttribute("student"); // data
		return "student"; // templates
	}

	// modificar/guardar nuevo
	@PostMapping("/student")
	public String studentSubmit(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		model.addAttribute("student", new Student()); // nueva instancia para carga
		return "student";
	}

	// eliminar
	@PostMapping("/student")
	public String studentDelete(@ModelAttribute Student student) {
		studentService.deleteStudent(student);
		return "student";
	}

	// búsqueda
	@GetMapping("/studentSearch")
	public String studentForm(@RequestParam(value = "dni", required = false) String dni,
			@RequestParam(value = "lastName", required = false) String lastName, Model model) {
		List<Student> studentList = studentService.getStudent(dni, lastName);
		model.addAttribute("studentList", studentList);
		return "student";

	}

}