package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    private Integer id;
    @OneToOne
    private PersonalInformation personalInformation;
    @OneToMany
    private List<Course> courses;
}
