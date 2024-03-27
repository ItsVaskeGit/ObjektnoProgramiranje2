package com.itsvaske.shipping;

import com.itsvaske.shipping.model.Container;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.services.ContainerService;
import com.itsvaske.shipping.services.ShipService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ship")
public class GreetingResource {

    @Inject
    ShipService shipService;
    @Inject
    ContainerService containerService;

   @POST
   @Path("/addContainer")
   @Consumes(MediaType.APPLICATION_JSON)
   public Response addContainer(Container container) {
        Container c = containerService.addContainer(container);

        return Response.ok().entity(c).build();
   }

   @GET
    @Path("/getAllContainers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllContainers() {
        List<Container> containers = containerService.getAllContainers();

        return Response.ok().entity(containers).build();
   }
}
