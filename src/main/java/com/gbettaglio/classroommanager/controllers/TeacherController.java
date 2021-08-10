package com.gbettaglio.classroommanager.controllers;

import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.services.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    private Model model;

    @GetMapping("/teacher") // html
    public String managerForm(Model model) {
        model.addAttribute("teacher"); // data
        return "teacher"; // templates
    }

    // modificar/guardar nuevo
    @PostMapping("/teacher")
    public String teacherSubmit(@ModelAttribute Teacher teacher) {
        teacherService.saveTeacher(teacher);
        model.addAttribute("teacher", new Teacher()); // nueva instancia para carga
        return "teacher";
    }

    // eliminar
    @PostMapping("/teacher")
    public String teacherDelete(@ModelAttribute Teacher teacher) {
        teacherService.deleteTeacher(teacher);
        return "teacher";
    }

}
