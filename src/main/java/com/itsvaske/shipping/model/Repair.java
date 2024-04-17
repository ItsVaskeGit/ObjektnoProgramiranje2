package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Repair.GET_ALL_REPAIRS, query = "select r from Repair r"),
        @NamedQuery(name = Repair.GET_REPAIR_BY_ID, query = "select r from Repair r where r.id = :id"),
        @NamedQuery(name = Repair.GET_REPAIR_BY_MACHINIST, query = "select r from Repair r where r.machinist.id = :id")
})
public class Repair {

    public static final String GET_ALL_REPAIRS = "getAllRepairs";
    public static final String GET_REPAIR_BY_ID = "getRepairByID";
    public static final String GET_REPAIR_BY_MACHINIST = "getRepairByMachinist";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Repair_seq")
    private Long id;

    private String description;

    @ManyToOne
    private Machinist machinist;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
