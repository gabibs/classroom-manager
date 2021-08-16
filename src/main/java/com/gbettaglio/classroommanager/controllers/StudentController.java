package com.gbettaglio.classroommanager.controllers;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/student") // html
	public String managerForm(@RequestParam(name = "dni", required = false) String lastName, String dni, Model model) {
		if (dni != null) {
			model.addAttribute("student", studentService.getStudent(lastName, dni));
		} else {
			model.addAttribute("student", new Student());
		}
		model.addAttribute("student", studentService.getStudent(lastName, dni));
		return "classroom"; // template
	}

	// modificar/guardar nuevo
	@PostMapping("/student")
	public String studentSubmit(@RequestParam(value = "dni", required = false) String lastName, String dni, Model model,
			Student student) {
		studentService.saveStudent(student);
		model.addAttribute("student", new StudentService());
		List<Student> allStudents = studentService.getAllStudents(lastName, dni);
		model.addAttribute("allStudents", allStudents);
		return "student";
	}

	// eliminar
	@PostMapping("/deleteStudent/{dni}")
	public String deleteStudent(@PathVariable Student student, Model model, String lastName, String dni) {
		studentService.deleteStudent(student);
		model.addAttribute("student", new Student()); // data
		List<Student> allStudents = studentService.getAllStudents(lastName, dni);
		model.addAttribute("student", allStudents);
		return "student";
	}

	// búsqueda
	@GetMapping("/studentSearch")
	public String studentForm(@RequestParam(value = "dni", required = false) String dni,
			@RequestParam(value = "lastName", required = false) String lastName, Model model) {
		List<Student> studentList = studentService.getAllStudents(dni, lastName);
		model.addAttribute("studentList", studentList);
		return "student";

	}

}