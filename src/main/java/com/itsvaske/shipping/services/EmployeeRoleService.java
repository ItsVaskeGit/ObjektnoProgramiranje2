package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.EmployeeRole;
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
@Path("/roles")
public class EmployeeRoleService {

    @Inject
    private EntityManager em;

    private List<EmployeeRole> getAllEmployeeRoles() {
        return em.createNamedQuery(EmployeeRole.GET_ALL_EMPLOYEE_ROLES, EmployeeRole.class).getResultList();
    }

    private List<EmployeeRole> getEmployeeRoleByID(int id) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("id", id).getResultList();
    }

    private List<EmployeeRole> getEmployeeRoleByDescription(String description) {
        return em.createNamedQuery(EmployeeRole.GET_EMPLOYEE_ROLE_BY_DESCRIPTION, EmployeeRole.class).setParameter("description", description).getResultList();
    }

    @GET
    @Path("/getAllRoles")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRoles() {
        List<EmployeeRole> allRoles = getAllEmployeeRoles();

        return Response.ok().entity(allRoles).build();
    }

    @GET
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRolesByID(@QueryParam(value = "id")int id) {
        List<EmployeeRole> roles = getEmployeeRoleByID(id);

        return Response.ok().entity(roles).build();
    }

    @GET
    @Path("/getByDescription")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRolesByDescription(@QueryParam(value = "description")String description) {
        List<EmployeeRole> roles = getEmployeeRoleByDescription(description);

        return Response.ok().entity(roles).build();
    }
}
