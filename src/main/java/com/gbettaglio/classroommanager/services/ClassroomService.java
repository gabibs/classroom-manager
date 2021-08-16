package com.gbettaglio.classroommanager.services;

import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import com.gbettaglio.classroommanager.entities.Classroom;
import com.gbettaglio.classroommanager.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(Integer id) {
        classroomRepository.deleteById(id);
    }

    public void saveCapacity(Classroom capacity) {
        classroomRepository.save(capacity);
    }

    public Classroom findClassroom(Integer id) {
        return classroomRepository.findById(id).orElse(new Classroom());
    }

    public List<Classroom> findAllClassrooms() {
        return StreamSupport.stream(classroomRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}
