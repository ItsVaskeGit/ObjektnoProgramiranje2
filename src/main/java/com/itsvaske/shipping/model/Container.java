package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Container.GET_ALL_CONTAINERS, query = "SELECT c FROM Container c"),
        @NamedQuery(name = Container.GET_CONTAINERS_FOR_SHIP, query = "Select c from Container c where c.ship.id =: id")
})
public class Container {

    public static final String GET_ALL_CONTAINERS = "getAllContainers";
    public static final String GET_CONTAINERS_FOR_SHIP = "getContainersForShip";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Container_seq")
    private Long id;

    private int weight;
    private String company;

    @ManyToOne(cascade = CascadeType.ALL)
    private Ship ship;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Set<Item> items;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
