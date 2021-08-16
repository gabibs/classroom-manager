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
    public String managerForm(@RequestParam(name = "dni", required = false) String lastName, String dni, Model model) {
        if (dni != null) {
            model.addAttribute("teacher", teacherService.getTeacher(lastName, dni));
        } else {
            model.addAttribute("teacher", new Teacher());
        }
        model.addAttribute("teacher", teacherService.getAllTeachers(lastName, dni));
        return "teacher"; // template
    }

    // modificar/guardar nuevo
    @PostMapping("/teacher")
    public String classroomSubmit(@RequestParam(value = "dni", required = false) String lastName, String dni,
            Model model, Teacher teacher) {
        teacherService.saveTeacher(teacher);
        model.addAttribute("teacher", new TeacherService());
        List<Teacher> allTeachers = teacherService.getAllTeachers(lastName, dni);
        model.addAttribute("allTeachers", allTeachers);
        return "teacher";
    }

    // eliminar
    @PostMapping("/deleteTeacher/{dni}")
    public String deleteTeacher(@PathVariable Teacher teacher, Model model, String lastName, String dni) {
        teacherService.deleteTeacher(teacher);
        model.addAttribute("teacher", new Teacher()); // data
        List<Teacher> allTeachers = teacherService.getAllTeachers(lastName, dni);
        model.addAttribute("teacher", allTeachers);
        return "teacher";
    }

    // búsqueda
    @GetMapping("/teacherSearch")
    public String teacherForm(@RequestParam(value = "dni", required = false) String dni,
            @RequestParam(value = "lastName", required = false) String lastName, Model model) {
        List<Teacher> teacherList = teacherService.getAllTeachers(dni, lastName);
        model.addAttribute("teacherList", teacherList);
        return "teacher";

    }

}
