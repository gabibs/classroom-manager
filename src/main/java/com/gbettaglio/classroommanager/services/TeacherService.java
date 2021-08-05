package com.gbettaglio.classroommanager.services;

import com.gbettaglio.classroommanager.entities.Student;
import com.gbettaglio.classroommanager.entities.Teacher;
import com.gbettaglio.classroommanager.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

}
