package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
