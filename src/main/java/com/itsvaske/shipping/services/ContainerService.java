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
    private EntityManager em;

    @Transactional
    public Container addContainer(Container container) {
        return em.merge(container);
    }

    public List<Container> getAllContainers() {
        return em.createNamedQuery(Container.GET_ALL_CONTAINERS, Container.class).getResultList();
    }
}
