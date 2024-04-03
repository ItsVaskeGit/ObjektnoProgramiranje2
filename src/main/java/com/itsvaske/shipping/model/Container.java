package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Container.GET_ALL_CONTAINERS, query = "SELECT c FROM Container c"),
        @NamedQuery(name = "getContainersForShip", query = "Select c from Container c")
})
public class Container {

    public static final String GET_ALL_CONTAINERS = "getAllContainers";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Container_seq")
    private Long id;

    private int weight;
    private String company;

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
