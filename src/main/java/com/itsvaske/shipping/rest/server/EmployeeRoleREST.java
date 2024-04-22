package com.itsvaske.shipping.rest.server;

import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.EmployeeRole;
import com.itsvaske.shipping.services.EmployeeRoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Loggable
@Path("/api/employeeroles")
public class EmployeeRoleREST {

    @Inject
    private EmployeeRoleService employeeRoleService;

    @GET
    @Path("/getAllRoles")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRoles() {
        List<EmployeeRole> allRoles = employeeRoleService.getAllEmployeeRoles();

        return Response.ok().entity(allRoles).build();
    }

    @GET
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRolesByID(@QueryParam(value = "id")int id) {
        List<EmployeeRole> roles = employeeRoleService.getEmployeeRoleByID(id);

        return Response.ok().entity(roles).build();
    }

    @GET
    @Path("/getByDescription")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRolesByDescription(@QueryParam(value = "description")String description) {
        List<EmployeeRole> roles = employeeRoleService.getEmployeeRoleByDescription(description.toLowerCase());

        return Response.ok().entity(roles).build();
    }
}
