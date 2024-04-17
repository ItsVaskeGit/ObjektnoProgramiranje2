package com.itsvaske.shipping.model;

import jakarta.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    private IPLog ipLog;

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public IPLog getIpLog() {
        return ipLog;
    }

    public void setIpLog(IPLog ipLog) {
        this.ipLog = ipLog;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Officer> getOfficers() {
        return officers;
    }

    public void setOfficers(Set<Officer> officers) {
        this.officers = officers;
    }

    public Set<Machinist> getMachinists() {
        return machinists;
    }

    public void setMachinists(Set<Machinist> machinists) {
        this.machinists = machinists;
    }

    public Set<Electirician> getElectiricians() {
        return electiricians;
    }

    public void setElectiricians(Set<Electirician> electiricians) {
        this.electiricians = electiricians;
    }

    public Set<Cornelian> getCornelians() {
        return cornelians;
    }

    public void setCornelians(Set<Cornelian> cornelians) {
        this.cornelians = cornelians;
    }
}
