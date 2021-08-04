package com.gbettaglio.classroommanager.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private int id;
    @OneToOne
    private PersonalInformation personalInformation;
    private Boolean approved;
    private Float score;

    public Object getCurrent() {
        return null;
    }

}
