package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Container;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/container")
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

    @POST
    @Path("/addContainer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContainer(Container container) {
        Container c = addContainerDB(container);

        return Response.ok().entity(c).build();
    }

    @GET
    @Path("/getAllContainers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContainers() {
        List<Container> containers = getAllContainersDB();

        return Response.ok().entity(containers).build();
    }

    @GET
    @Path("/getContainersForShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContainersForShip(@QueryParam(value = "id") int id) {
        List<Container> containersForShip = getAllContainersForShipDB(id);

        return Response.ok().entity(containersForShip).build();
    }
}
