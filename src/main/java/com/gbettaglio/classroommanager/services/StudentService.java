package com.gbettaglio.classroommanager.services;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public List<Student> getStudent(String lastName, String dni) {
        return studentRepository.findByPersonalInformationLastNameContainsAndPersonalInformationDniContains(lastName,
                dni);
    }

}
