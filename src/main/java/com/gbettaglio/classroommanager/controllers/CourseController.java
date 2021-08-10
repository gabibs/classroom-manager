package com.gbettaglio.classroommanager.controllers;

import org.springframework.stereotype.Controller;
import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.entities.Teacher;
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

    // mapear curso
    @GetMapping("/course")
    public String courseForm(Model model) {
        model.addAttribute("course", new Course()); // agregar nuevo objeto Course al template (html)
        return "course"; // devolver html + objeto pegado en el template
    }

    // modificar/guardar curso
    @PostMapping("/course")
    public String courseSubmit(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        model.addAttribute("course", new Course()); // nueva instancia para carga
        return "course";
    }

    // buscar curso
    @GetMapping("/courseSearch")
    public String courseForm(@RequestParam(value = "yearOfEdition", required = false) String yearOfEdition,
            @RequestParam(value = "name", required = false) String name, Model model) {
        List<Course> courseList = courseService.getAllCoursesByNameAndYear(name, yearOfEdition);
        model.addAttribute("courseList", courseList);
        return "course";

    }

    // eliminar curso
    @PostMapping("/course")
    public String courseDelete(@ModelAttribute Course course) {
        courseService.deleteCourse(course);
        return "course";
    }

    // eliminar estudiante de curso
    @PostMapping("/course")
    public String deleteStudentFromCourse(@ModelAttribute Course course, Student student) {
        courseService.deleteStudentFromCourse(student, course);
        return "course";
    }

    // agregar estudiante a curso
    @PostMapping("/course")
    public String saveStudentToCourse(@ModelAttribute Course course, Student student) {
        courseService.saveStudentToCourse(student, course);
        return "course";
    }

    // agregar profesor a curso
    @PostMapping("/course")
    public String addTeacher(@ModelAttribute Course course, Teacher teacher) {
        courseService.addTeacher(teacher, course);
        return "course";
    }
}
