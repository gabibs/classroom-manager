package com.gbettaglio.classroommanager.entities;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

// @Data decorator auto-generates all getters and setters that do not exist with the name get/set<Attribute>
// @NoArgsConstructor decorator auto-generates a constructor with no arguments
@ToString
@NoArgsConstructor
@Entity
public class Classroom {
    @Id
    private Integer id;
    private Integer capacity;

    public static void saveCapacity(Integer capacity) {
    }

    public int getCapacity() {
        return 0;
    }

}
