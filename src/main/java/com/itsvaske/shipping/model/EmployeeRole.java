package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Country.GET_ALL_COUNTRIES, query = "select e from EmployeeRole e"),
        @NamedQuery(name = Country.GET_COUNTRY_BY_CODE, query = "select e from EmployeeRole e where e.description =: description"),
        @NamedQuery(name = EmployeeRole.GET_EMPLOYEE_ROLE_BY_ID, query = "select e from EmployeeRole e where e.id = :id")
})
public class EmployeeRole {

    public static final String GET_ALL_EMPLOYEE_ROLES = "getAllEmployeeRoles";
    public static final String GET_EMPLOYEE_ROLE_BY_DESCRIPTION = "getEmployeeRoleByDescription";
    public static final String GET_EMPLOYEE_ROLE_BY_ID = "getEmployeeRoleByID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Equipment_seq")
    private Long id;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerole_id")
    private Set<Cornelian> cornelianRoles;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerole_id")
    private Set<Electirician> electriciansRoles;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerole_id")
    private Set<Machinist> machinistRoles;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerole_id")
    private Set<Officer> officerRoles;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employeerole_id")
    private Set<Worker> workerRoles;

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
