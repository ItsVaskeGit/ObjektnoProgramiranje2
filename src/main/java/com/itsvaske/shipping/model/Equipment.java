package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Equipment.GET_ALL_EQUIPMENT, query = "select e from Equipment e"),
        @NamedQuery(name = Equipment.GET_EQUIPMENT_BY_SHIP, query = "select e from Equipment e where e.ship =: id")
})
public class Equipment {

    public static final String GET_ALL_EQUIPMENT = "getAllEquipment";
    public static final String GET_EQUIPMENT_BY_SHIP = "getEquipmentByShip";

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
