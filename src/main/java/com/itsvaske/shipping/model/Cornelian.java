package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
public class Cornelian {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cornelian_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;
    private int drivingTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeRole employeeRole;
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employees;

    public Cornelian(String firstName, String lastName, long JMBG, int skillLevel, int drivingTime, EmployeeRole employeeRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.JMBG = JMBG;
        this.skillLevel = skillLevel;
        this.drivingTime = drivingTime;
        this.employeeRole = employeeRole;
    }

    public Cornelian() {
    }

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

    public int getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }
}
