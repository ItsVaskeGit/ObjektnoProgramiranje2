package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Ship;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/ship")
public class ShipService {

    @Inject
    private EntityManager em;

    @Transactional
    public Ship addShipDB(Ship ship){
        return em.merge(ship);
    }

    public List<Ship> getAllShipsDB() {
        return em.createNamedQuery(Ship.GET_ALL_SHIPS, Ship.class).getResultList();
    }

    @GET
    @Path("/getAllShips")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShips(){
        List<Ship> ships = getAllShipsDB();

        return Response.ok().entity(ships).build();
    }

    @POST
    @Path("/addShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addShip(Ship ship) {
        Ship s = addShipDB(ship);
        return Response.ok().entity(s).build();
    }
}
