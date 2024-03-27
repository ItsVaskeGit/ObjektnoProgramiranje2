package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
public class Equipment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Equipment_seq")
    private Long id;

    private String description;
    @ManyToOne
    Ship ship;
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
