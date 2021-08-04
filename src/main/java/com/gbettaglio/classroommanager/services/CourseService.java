package com.gbettaglio.classroommanager.services;

import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.StudentNotFoundException;
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
     *  TODO: delete student from course, create course
     *  find course, update course
     */
    public void deleteStudentFromCourse(Student student, Course course) {

            course.getStudents().remove(student);
            courseRepository.save(course);

    }
}
