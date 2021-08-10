package com.gbettaglio.classroommanager.controllers;

import org.springframework.stereotype.Controller;
import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.services.CourseService;

import java.util.List;

import javax.lang.model.element.Name;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    private CourseService courseService;
    private Model model;

    @GetMapping("/course") // mapear Course.html
    public String courseForm(Model model) {
        model.addAttribute("course", new Course()); // agregar nuevo objeto Course al template (html)
        return "course"; // devolver html + objeto pegado en el template
    }

    // modificar/guardar nuevo
    @PostMapping("/course")
    public String courseSubmit(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        model.addAttribute("course", new Course()); // nueva instancia para carga
        return "course";
    }

    // búsqueda
    @GetMapping("/courseSearch")
    public String courseForm(@RequestParam(value = "yearOfEdition", required = false) String yearOfEdition,
            @RequestParam(value = "name", required = false) String name, Model model) {
        List<Course> courseList = courseService.getAllCoursesByNameAndYear(name, yearOfEdition);
        model.addAttribute("courseList", courseList);
        return "course";

    }

    // eliminar
    @PostMapping("/course")
    public String courseDelete(@ModelAttribute Course course) {
        courseService.deleteCourse(course);
        return "course";
    }
}
