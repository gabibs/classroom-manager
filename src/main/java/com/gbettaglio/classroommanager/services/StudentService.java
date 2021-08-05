package com.gbettaglio.classroommanager.services;

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

    

}
