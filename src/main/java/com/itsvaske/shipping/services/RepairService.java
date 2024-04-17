package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Repair;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class RepairService {

    @Inject
    EntityManager entityManager;

    public List<Repair> getAllRepairs() {
        return entityManager.createNamedQuery(Repair.GET_ALL_REPAIRS, Repair.class).getResultList();
    }

    public List<Repair> getRepairByID(int id) {
        return entityManager.createNamedQuery(Repair.GET_REPAIR_BY_ID, Repair.class).setParameter("id", id).getResultList();
    }

    public List<Repair> getRepairsByMachinist(int id) {
        return entityManager.createNamedQuery(Repair.GET_REPAIR_BY_MACHINIST, Repair.class).setParameter("id", id).getResultList();
    }

    public Repair addRepair(Repair r) {
        return entityManager.merge(r);
    }
}
