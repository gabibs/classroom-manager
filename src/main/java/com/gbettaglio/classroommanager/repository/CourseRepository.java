package com.gbettaglio.classroommanager.repository;

import java.util.List;

import com.gbettaglio.classroommanager.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findAllByNameContainsAndYearOfEditionContains(String name, String yearOfEdition);

    Course findByNameContainsAndYearOfEditionContains(String name, String yearOfEdition);
}
