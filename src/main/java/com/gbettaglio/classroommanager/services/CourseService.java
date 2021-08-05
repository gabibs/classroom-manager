package com.gbettaglio.classroommanager.services;

import java.util.List;
import java.util.stream.Collectors;

import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.entities.StudentCourse;
import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.repository.CourseRepository;
import com.gbettaglio.classroommanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public void addStudentToCourse(Student student, Course course) {
        try {
            course.addStudent(student);
            courseRepository.save(course);
        } catch (FullClassException e) {
            // TODO: Handle full class
        }
    }

    /**
     *  TODO: create course, find course, update course
     */
    public void deleteStudentFromCourse(Student student, Course course) {
            List<StudentCourse> filteredList = course.getStudentsList().stream()
                .filter(studentCourse -> studentCourse.getStudent().getId().equals(student.getId()))
                .collect(Collectors.toList());
            course.setStudentsList(filteredList);
            courseRepository.save(course);

    }
}
