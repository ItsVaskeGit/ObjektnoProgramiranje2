package com.itsvaske.shipping.model;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Employee.GET_EMPLOYEE_ID_BY_SHIP, query = "select e.id from Employee e where e.ship.id =: ship_id"),
        @NamedQuery(name = Employee.GET_WORKERS_BY_SHIP, query = "select w from Worker w where w.employee.id =: id"),
        @NamedQuery(name = Employee.GET_OFFICERS_BY_SHIP, query = "select o from Officer o where o.employees.id =: id"),
        @NamedQuery(name = Employee.GET_MACHINISTS_BY_SHIP, query = "select m from Machinist m where m.employees.id = :id"),
        @NamedQuery(name = Employee.GET_ELECTRICIANS_BY_SHIP, query = "select e from Electirician e where e.employees.id = :id"),
        @NamedQuery(name = Employee.GET_CORNELIANS_BY_SHIP, query = "select c from Cornelian c where c.employees.id = :id"),
        @NamedQuery(name = Employee.GET_WORKERS, query = "select w from Employee e, Worker w where w.employee.id = e.id"),
        @NamedQuery(name = Employee.GET_OFFICERS, query = "select c from Employee e, Officer c where c.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_MACHINISTS, query = "select m from Employee e, Machinist m where m.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_ELECTRICIANS, query = "select el from Employee e, Electirician el where el.employees.id = e.id"),
        @NamedQuery(name = Employee.GET_CORNELIANS, query = "select c from Employee e, Cornelian c where c.employees.id = e.id")
})
public class Employee {

    public static final String GET_EMPLOYEE_ID_BY_SHIP = "getEmployeesByShip";
    public static final String GET_WORKERS_BY_SHIP = "getWorkersByShip";
    public static final String GET_OFFICERS_BY_SHIP = "getOfficersByShip";
    public static final String GET_MACHINISTS_BY_SHIP = "getMachinistsByShip";
    public static final String GET_ELECTRICIANS_BY_SHIP = "getElectriciansByShip";
    public static final String GET_CORNELIANS_BY_SHIP = "getCorneliansByShip";

    public static final String GET_WORKERS = "getWorkers";
    public static final String GET_OFFICERS = "getOfficers";
    public static final String GET_MACHINISTS = "getMachinists";
    public static final String GET_ELECTRICIANS = "getElectricians";
    public static final String GET_CORNELIANS = "getCornelians";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_seq")
    private Long id;

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

}
