package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.Repair;
import com.itsvaske.shipping.services.RepairService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/repair")
public class RepairREST {

    @Inject
    private RepairService repairService;

    @GET
    @Path("/getAllRepairs")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRepairs() {
        List<Repair> allRepairs = repairService.getAllRepairs();

        return Response.ok().entity(allRepairs).build();
    }

    @GET
    @Path("/getRepairByID")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRepairByID(@QueryParam(value = "id")int id) {
        List<Repair> repairs = repairService.getRepairByID(id);

        return Response.ok().entity(repairs).build();
    }

    @GET
    @Path("/getRepairsByMachinist")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRepairsByMachinist(@QueryParam(value = "id")int id) {
        List<Repair> repairs = repairService.getRepairsByMachinist(id);

        return Response.ok().entity(repairs).build();
    }

    @POST
    @Path("/addRepair")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRepair(Repair r) {
        Repair repair = repairService.addRepair(r);

        return Response.ok().entity(repair).build();
    }
}
