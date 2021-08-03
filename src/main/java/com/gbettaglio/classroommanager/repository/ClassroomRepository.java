package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {
}
