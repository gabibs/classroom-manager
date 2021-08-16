package com.gbettaglio.classroommanager.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacher(String lastName, String dni) {
        return teacherRepository.findByPersonalInformationLastNameContainsAndPersonalInformationDniContains(lastName,
                dni);

    }

    public List<Teacher> getAllTeachers(String lastName, String dni) {
        return teacherRepository.findAllByPersonalInformationLastNameContainsAndPersonalInformationDniContains(lastName,
                dni);

    }

    public List<Teacher> getAllTeachers() {
        return StreamSupport.stream(teacherRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
