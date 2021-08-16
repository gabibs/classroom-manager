package com.gbettaglio.classroommanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.services.CourseService;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    private Model model;

    // mapear curso
    @GetMapping("/course") // html
    public String managerForm(@RequestParam(name = "id", required = false) Integer id, Model model,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "yearOfEdition", required = false) String yearOfEdition) {
        if (id != null && name != null && yearOfEdition != null) {
            model.addAttribute("course", courseService.findCourse(name, yearOfEdition));
        } else {
            model.addAttribute("course", new Course());
        }
        model.addAttribute("courses", courseService.findAllCourses(name, yearOfEdition));
        return "course"; // template
    }

    // modificar/guardar curso
    @PostMapping("/course")
    public String classroomSubmit(@ModelAttribute Course course, String name, String yearOfEdition, Integer id) {
        if (id != null) {
            course.setId(id);
        }
        courseService.saveCourse(course);
        model.addAttribute("course", new CourseService());
        List<Course> allCourses = courseService.findAllCourses(name, yearOfEdition);
        model.addAttribute("course", allCourses);
        return "classroom";
    }

    // buscar curso
    @GetMapping("/courseSearch")
    public String courseForm(@RequestParam(value = "yearOfEdition", required = false) String yearOfEdition,
            @RequestParam(value = "name", required = false) String name, Model model) {
        List<Course> courseList = courseService.findAllCourses(name, yearOfEdition);
        model.addAttribute("courseList", courseList);
        return "course";

    }

    // eliminar curso
    @PostMapping("/deleteCourse/{id}")
    public String courseDelete(@ModelAttribute Course course, @PathVariable Integer id) {
        courseService.deleteCourse(course);
        return "course";
    }

    // eliminar estudiante de curso
    @PostMapping("/deleteStudentFromCourse/{studentId}")
    public String deleteStudentFromCourse(@ModelAttribute Course course, @PathVariable Integer studentId) {
        courseService.deleteStudentFromCourse(studentId, course);
        return "course";
    }

    // agregar estudiante a curso
    @PostMapping("/saveStudentToCourse/{id}")
    public String saveStudentToCourse(@ModelAttribute Course course, @PathVariable Integer studentId, Student student) {
        courseService.saveStudentToCourse(studentId, course);
        return "course";
    }

    @PostMapping("/addTeacherToCourse")
    public String addTeacher(@ModelAttribute Course course, Teacher teacher) {
        courseService.addTeacher(teacher, course);
        return "course";
    }
}
