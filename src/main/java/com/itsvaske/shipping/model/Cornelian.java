package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cornelian {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cornelian_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;
    private int drivingTime;
    @ManyToOne
    private EmployeeRole employeeRole;
    @ManyToOne
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
