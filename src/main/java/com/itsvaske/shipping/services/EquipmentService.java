package com.itsvaske.shipping.services;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@Dependent
public class EquipmentService {

    @Inject
    EntityManager em;


}
