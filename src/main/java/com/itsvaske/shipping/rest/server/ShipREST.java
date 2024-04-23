package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.Ship;
import com.itsvaske.shipping.services.ShipService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/ship")
public class ShipREST {

    @Inject
    private ShipService shipService;

    @GET
    @Path("/getAllShips")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShips(){
        List<Ship> ships = shipService.getAllShipsDB();

        return Response.ok().entity(ships).build();
    }

    @POST
    @Path("/addShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShip(Ship ship) {
        Ship s = shipService.addShipDB(ship);
        return Response.ok().entity(s).build();
    }

    @GET
    @Path("/getAllShipsByCountryOfRegistration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShipsByCountryOfRegistration(@QueryParam("name")String name) {
        List<Ship> ships = shipService.getAllShipsByCountryOfRegistration(name);

        return Response.ok().entity(ships).build();
    }
}
