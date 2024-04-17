package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Container;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Dependent
public class ContainerService {

    @Inject
    EntityManager em;

    @Transactional
    public Container addContainerDB(Container container) {
        return em.merge(container);
    }

    public List<Container> getAllContainersDB() {
        return em.createNamedQuery(Container.GET_ALL_CONTAINERS, Container.class).getResultList();
    }

    public List<Container> getAllContainersForShipDB(int id) {
        return em.createNamedQuery(Container.GET_CONTAINERS_FOR_SHIP, Container.class).setParameter("id", id).getResultList();
    }
}
