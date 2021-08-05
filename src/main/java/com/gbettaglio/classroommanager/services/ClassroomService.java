package com.gbettaglio.classroommanager.services;

import com.gbettaglio.classroommanager.entities.Classroom;
import com.gbettaglio.classroommanager.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

}
