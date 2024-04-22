package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.*;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Dependent
public class EmployeeService {

    @Inject
    EntityManager em;


    public List<Worker> getWorkersByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_WORKERS_BY_SHIP, Worker.class).setParameter("id", id).getResultList();
    }

    public List<Officer> getOfficersByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_OFFICERS_BY_SHIP, Officer.class).setParameter("id", id).getResultList();
    }

    public List<Machinist> getMachinistsByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_MACHINISTS_BY_SHIP, Machinist.class).setParameter("id", id).getResultList();
    }

    public List<Electirician> getElectriciansByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_ELECTRICIANS_BY_SHIP, Electirician.class).setParameter("id", id).getResultList();
    }

    public List<Cornelian> getCorneliansByShipDB(int id) {
        return em.createNamedQuery(Employee.GET_CORNELIANS_BY_SHIP, Cornelian.class).setParameter("id", id).getResultList();
    }

    public List<Worker> getWorkersDB() {
        return em.createNamedQuery(Employee.GET_WORKERS, Worker.class).getResultList();
    }

    public List<Officer> getOfficersDB() {
        return em.createNamedQuery(Employee.GET_OFFICERS, Officer.class).getResultList();
    }

    public List<Machinist> getMachinistsDB() {
        return em.createNamedQuery(Employee.GET_MACHINISTS, Machinist.class).getResultList();
    }

    public List<Electirician> getElectriciansDB() {
        return em.createNamedQuery(Employee.GET_ELECTRICIANS, Electirician.class).getResultList();
    }

    public List<Cornelian> getCorneliansDB() {
        return em.createNamedQuery(Employee.GET_CORNELIANS, Cornelian.class).getResultList();
    }

    @Transactional
    public Cornelian addCornelianDB(Cornelian c) {
        return em.merge(c);
    }

    @Transactional
    public Electirician addElectricianDB(Electirician e) {
        return em.merge(e);
    }

    @Transactional
    public Machinist addMachinistDB(Machinist m) {
        return em.merge(m);
    }

    @Transactional
    public Officer addOfficerDB(Officer o) {
        return em.merge(o);
    }

    @Transactional
    public Worker addWorkerDB(Worker w) {
        return em.merge(w);
    }

    @Transactional
    public Employee addEmployeeDB(Employee e) {
        return em.merge(e);
    }
}
