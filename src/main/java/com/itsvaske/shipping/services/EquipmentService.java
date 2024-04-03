package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Equipment;
import com.itsvaske.shipping.model.Ship;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/equipment")
public class EquipmentService {

    @Inject
    EntityManager em;

//    public List<Equipment> getEquipmentByShip(Ship s) {
//        return em.createNamedQuery(Equipment.GET_EQUIPMENT_BY_SHIP, Equipment.class);
//    }

    @GET
    @Path("/getEquipmentByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEquipmentByShip(Ship s) {
        return null;
    }
}
