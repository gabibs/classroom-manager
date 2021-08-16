package com.gbettaglio.classroommanager.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.StudentCourse;
import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.UnexistingClassroom;
import com.gbettaglio.classroommanager.repository.CourseRepository;
import com.gbettaglio.classroommanager.repository.StudentRepository;
import com.gbettaglio.classroommanager.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public void saveStudentToCourse(Integer studentId, Course course) {
        try {
            course.saveStudent(studentRepository.findById(studentId).orElseThrow());
            courseRepository.save(course);
        } catch (FullClassException | UnexistingClassroom e) {

        }
    }

    public void deleteStudentFromCourse(Integer studentId, Course course) {
        List<StudentCourse> filteredList = course.getStudentsList().stream()
                .filter(studentCourse -> studentCourse.getStudent().getId().equals(studentId))
                .collect(Collectors.toList());
        course.setStudentsList(filteredList);
        courseRepository.save(course);
    }

    public CourseService saveCourse(Course course) {
        courseRepository.save(course);
        return null;

    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);

    }

    public List<Course> findAllCourses(String name, String yearOfEdition) {
        return courseRepository.findAllByNameContainsAndYearOfEditionContains(name, yearOfEdition);

    }

    public List<Course> findAllCourses() {
        return StreamSupport.stream(courseRepository.findAll().spliterator(), false).collect(Collectors.toList());

    }

    public Course findCourse(String name, String yearOfEdition) {
        return courseRepository.findByNameContainsAndYearOfEditionContains(name, yearOfEdition);

    }

    public void addTeacher(Teacher teacher, Course course) {
        course.setTeacher(teacher);
        this.saveCourse(course);
    }

}
