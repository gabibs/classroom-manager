package com.gbettaglio.classroommanager.entities;

import com.gbettaglio.classroommanager.exceptions.FullClassException;
import com.gbettaglio.classroommanager.exceptions.StudentNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {

    @Id
    private Integer id;
    private String name;
    private LocalDate startDate;
    private String yearOfEdition;
    private Double price = 0.00d;
    private String schedule;
    @OneToOne
    private Classroom classroom;
    @OneToMany
    private List<Student> students;
    @ManyToOne
    private Teacher teachers;

    public LocalDate getEndDate() {
        return startDate.plusMonths(6);
    }

    public void addStudent(Student student) throws FullClassException {
        if (this.students.size() == classroom.getCapacity()) {
            throw new FullClassException();
        } else {
            this.students.add(student);
        }
    }
}
