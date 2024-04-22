package com.itsvaske.shipping.model;

import jakarta.persistence.*;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Worker_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;
    private int workTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeRole employeeRole;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

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

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
