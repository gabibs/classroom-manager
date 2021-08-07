package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    
}
