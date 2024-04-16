package com.itsvaske.shipping.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Employee.GET_ALL_EMPLOYEES, query = "select e from Employee e"),
        @NamedQuery(name = Employee.GET_EMPLOYEES_BY_SHIP, query = "select e from Employee e where e.ship.id =: ship_id"),
        @NamedQuery(name = Employee.GET_WORKERS, query = "select e from Employee e, Worker w where w.employee.id = e.id"),
        @NamedQuery(name = Employee.GET_OFFICERS, query = "select e from Employee e, Officer c where c.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_MACHINISTS, query = "select e from Employee e, Machinist m where m.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_ELECTRICIANS, query = "select e from Employee e, Electirician el where el.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_CORNELIANS, query = "select e from Employee e, Cornelian c where c.employees.id = e.id")
})
public class Employee {

    public static final String GET_ALL_EMPLOYEES = "getAllEmployees";
    public static final String GET_EMPLOYEES_BY_SHIP = "getEmployeesByShip";
    public static final String GET_WORKERS = "getWorkers";
    public static final String GET_OFFICERS = "getOfficers";
    public static final String GET_MACHINISTS = "getMachinists";
    public static final String GET_ELECTRICIANS = "getElectricians";
    public static final String GET_CORNELIANS = "getCornelians";

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private long JMBG;
    private int skillLevel;

    @ManyToOne
    Ship ship;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Worker> workers;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Officer> officers;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Machinist> machinists;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Electirician> electiricians;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Cornelian> cornelians;

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
