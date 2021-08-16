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
	public String managerForm(@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "dni", required = false) String dni, Model model) {
		if (dni != null && lastName != null) {
			model.addAttribute("student", studentService.getStudent(lastName, dni));
		} else {
			model.addAttribute("student", new Student());
		}
		model.addAttribute("students", studentService.getAllStudents());
		return "student"; // template
	}

	// modificar/guardar nuevo
	@PostMapping("/student")
	public String studentSubmit(@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "dni", required = false) String dni, Model model, Student student) {
		studentService.saveStudent(student);
		model.addAttribute("student", new StudentService());
		List<Student> students = studentService.getAllStudents(lastName, dni);
		model.addAttribute("students", students);
		return "student"; // Added admissionDate as @RequestParam
	}

	// eliminar
	@PostMapping("/deleteStudent/{dni}/{lastName}")
	public String deleteStudent(Student student, Model model, @PathVariable String lastName, @PathVariable String dni) {
		studentService.deleteStudent(student);
		model.addAttribute("student", new Student()); // data
		List<Student> students = studentService.getAllStudents(lastName, dni);
		model.addAttribute("students", students);
		return "student";
	}

	// búsqueda
	@GetMapping("/searchStudent")
	public String studentForm(@RequestParam(value = "dni", required = false) String dni,
			@RequestParam(value = "lastName", required = false) String lastName, Model model) {
		List<Student> students = studentService.getAllStudents(dni, lastName);
		model.addAttribute("students", students);
		return "student";

	}

}