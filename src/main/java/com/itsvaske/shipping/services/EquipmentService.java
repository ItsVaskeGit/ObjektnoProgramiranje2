package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Equipment;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
@Path("/equipment")
public class EquipmentService {

    @Inject
    EntityManager em;

    public List<Equipment> getEquipmentByShipDB(int id) {
        return em.createNamedQuery(Equipment.GET_EQUIPMENT_BY_SHIP, Equipment.class).setParameter("id", id).getResultList();
    }

    public List<Equipment> getAllEquipmentDB() {
        return em.createNamedQuery(Equipment.GET_ALL_EQUIPMENT, Equipment.class).getResultList();
    }

    @GET
    @Path("/getEquipmentByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEquipmentByShip(@QueryParam(value = "id") int id) {
        List<Equipment> equipment = getEquipmentByShipDB(id);

        return Response.ok().entity(equipment).build();
    }

    @GET
    @Path("/getAllEquipment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEquipment() {
        List<Equipment> allEquipment = getAllEquipmentDB();

        return Response.ok().entity(allEquipment).build();
    }
}
