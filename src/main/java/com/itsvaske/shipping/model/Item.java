package com.itsvaske.shipping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {


    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    Container container;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
