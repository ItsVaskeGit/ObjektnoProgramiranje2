package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.EmployeeRole;
import com.itsvaske.shipping.model.Equipment;
import com.itsvaske.shipping.services.EquipmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/equipment")
public class EquipmentREST {

    @Inject
    private EquipmentService equipmentService;

    @GET
    @Path("/getEquipmentByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEquipmentByShip(@QueryParam(value = "id") int id) {
        List<Equipment> equipment = equipmentService.getEquipmentByShipDB(id);

        return Response.ok().entity(equipment).build();
    }

    @GET
    @Path("/getAllEquipment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEquipment() {
        List<Equipment> allEquipment = equipmentService.getAllEquipmentDB();

        return Response.ok().entity(allEquipment).build();
    }
}
