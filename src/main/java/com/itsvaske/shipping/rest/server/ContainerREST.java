package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.Container;
import com.itsvaske.shipping.services.ContainerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/container")
public class ContainerREST {

    @Inject
    private ContainerService containerService;

    @GET
    @Path("/getAllContainers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContainers() {
        List<Container> containers = containerService.getAllContainersDB();

        return Response.ok().entity(containers).build();
    }

    @GET
    @Path("/getContainersForShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getContainersForShip(@QueryParam(value = "id")int id) {
        List<Container> containers = containerService.getAllContainersForShipDB(id);

        return Response.ok().entity(containers).build();
    }

    @POST
    @Path("/addRepair")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRepair(Container container) {
        Container c = containerService.addContainerDB(container);

        return Response.ok().entity(c).build();
    }
}
