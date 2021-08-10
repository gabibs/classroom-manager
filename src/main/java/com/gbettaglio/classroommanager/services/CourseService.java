package com.gbettaglio.classroommanager.services;

import java.util.List;
import java.util.stream.Collectors;

import com.gbettaglio.classroommanager.entities.Course;
import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.entities.StudentCourse;
import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.UnexistingClassroom;
import com.gbettaglio.classroommanager.repository.CourseRepository;
import com.gbettaglio.classroommanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public void saveStudentToCourse(Student student, Course course) {
        try {
            course.saveStudent(student);
            courseRepository.save(course);
        } catch (FullClassException | UnexistingClassroom e) {

        }
    }

    public void deleteStudentFromCourse(Student student, Course course) {
        List<StudentCourse> filteredList = course.getStudentsList().stream()
                .filter(studentCourse -> studentCourse.getStudent().getId().equals(student.getId()))
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

    public List<Course> getAllCoursesByNameAndYear(String name, String yearOfEdition) {
        return courseRepository.findAllByNameContainsAndYearOfEditionContains(name, yearOfEdition);

    }

    public void addTeacher(Teacher teacher, Course course) {
        course.setTeachers(teacher);
        this.saveCourse(course);
    }

}
