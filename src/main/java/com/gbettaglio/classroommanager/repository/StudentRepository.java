package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findByLastNameContains(String lastName);



}
