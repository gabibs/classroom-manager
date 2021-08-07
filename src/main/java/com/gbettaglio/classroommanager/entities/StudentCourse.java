package com.gbettaglio.classroommanager.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class StudentCourse {

    @Id
    private Integer id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private Float score;

    
}
