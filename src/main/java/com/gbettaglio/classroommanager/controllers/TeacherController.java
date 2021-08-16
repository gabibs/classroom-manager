package com.gbettaglio.classroommanager.controllers;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.services.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher") // html
    public String managerForm(@RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "dni", required = false) String dni, Model model) {
        if (dni != null && lastName != null) {
            model.addAttribute("teacher", teacherService.getTeacher(lastName, dni));
        } else {
            model.addAttribute("teacher", new Teacher());
        }
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher"; // template
    }

    // modificar/guardar nuevo
    @PostMapping("/teacher")
    public String teacherSubmit(@RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "dni", required = false) String dni, Model model,
            @RequestParam(value = "teacher", required = false) Teacher teacher,
            @RequestParam(value = "id", required = false) Integer id) {
        if (id != null) {
            teacher.setId(id);
        }
        teacherService.saveTeacher(teacher);
        model.addAttribute("teacher", new TeacherService());
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher";
    }

    // eliminar
    @PostMapping("/deleteTeacher/{dni}")
    public String deleteTeacher(@PathVariable Teacher teacher, Model model, String lastName, @PathVariable String dni) {
        teacherService.deleteTeacher(teacher);
        model.addAttribute("teacher", new Teacher()); // data
        List<Teacher> teachers = teacherService.getAllTeachers(lastName, dni);
        model.addAttribute("teachers", teachers);
        return "teacher";
    }

    // búsqueda
    @GetMapping("/searchTeacher/{dni}")
    public String teacherForm(@PathVariable String dni,
            @RequestParam(value = "lastName", required = false) String lastName, Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers(dni, lastName);
        model.addAttribute("teachers", teachers);
        return "teacher";

    }

}
