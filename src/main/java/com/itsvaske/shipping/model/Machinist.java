package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Machinist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Machinist_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;

    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeRole employeeRole;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "machinist_id")
    private Set<Repair> repairs;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getJMBG() {
        return JMBG;
    }

    public void setJMBG(long JMBG) {
        this.JMBG = JMBG;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }
}
