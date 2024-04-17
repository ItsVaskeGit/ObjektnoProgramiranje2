package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Equipment;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Dependent
public class EquipmentService {

    @Inject
    EntityManager em;

    public List<Equipment> getEquipmentByShipDB(int id) {
        return em.createNamedQuery(Equipment.GET_EQUIPMENT_BY_SHIP, Equipment.class).setParameter("id", id).getResultList();
    }

    public List<Equipment> getAllEquipmentDB() {
        return em.createNamedQuery(Equipment.GET_ALL_EQUIPMENT, Equipment.class).getResultList();
    }
}
