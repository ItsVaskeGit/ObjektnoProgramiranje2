package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cornelian {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cornelian_seq")
    private Long id;

    private int drivingTime;

    @ManyToOne
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
