package com.gbettaglio.classroommanager.repository;

import com.gbettaglio.classroommanager.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course findByYearOfEdition(String yearOfEdition);
    Course findByNameContains(String name);
    Course findByNameContainsAndYearOfEdition(String name, String yearOfEdition);
}
