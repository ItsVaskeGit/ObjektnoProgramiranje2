package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Repair_seq")
    private Long id;

    private String description;

    @ManyToOne
    private Repair repairs;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
