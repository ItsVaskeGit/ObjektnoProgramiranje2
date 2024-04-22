package com.itsvaske.shipping.rest.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsvaske.shipping.logging.Loggable;
import com.itsvaske.shipping.model.*;
import com.itsvaske.shipping.proxies.IPClient;
import com.itsvaske.shipping.services.EmployeeRoleService;
import com.itsvaske.shipping.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Loggable
@Path("/api/employees")
public class EmployeeREST {

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmployeeRoleService employeeRoleService;

    @RestClient
    IPClient ipClient;

    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @GET
    @Path("/getEmployeesByShip")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeesByShip(@QueryParam(value = "id") int id) {
        List<Worker> workersForShip = employeeService.getWorkersByShipDB(id);
        List<Officer> officers = employeeService.getOfficersByShipDB(id);
        List<Machinist> machinists = employeeService.getMachinistsByShipDB(id);
        List<Electirician> electiricians = employeeService.getElectriciansByShipDB(id);
        List<Cornelian> cornelians = employeeService.getCorneliansByShipDB(id);

        return Response.ok().entity(workersForShip).entity(officers).entity(machinists).entity(electiricians).entity(cornelians).build();
    }

    @GET
    @Path("/getAllEmployees")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        List<Worker> workers = employeeService.getWorkersDB();
        List<Officer> officers = employeeService.getOfficersDB();
        List<Machinist> machinists = employeeService.getMachinistsDB();
        List<Electirician> electricians = employeeService.getElectriciansDB();
        List<Cornelian> cornelians = employeeService.getCorneliansDB();

        return Response.ok().entity(workers).entity(officers).entity(machinists).entity(electricians).entity(cornelians).build();
    }

    @GET
    @Path("/getWorkers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWorkers() {
        List<Worker> workers = employeeService.getWorkersDB();

        return Response.ok().entity(workers).build();
    }

    @GET
    @Path("/getOfficers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOfficers() {
        List<Officer> officers = employeeService.getOfficersDB();

        return Response.ok().entity(officers).build();
    }

    @GET
    @Path("/getMachinists")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMachinists() {
        List<Machinist> machinists = employeeService.getMachinistsDB();

        return Response.ok().entity(machinists).build();
    }

    @GET
    @Path("/getElectricians")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getElectricians() {
        List<Electirician> electiricians = employeeService.getElectriciansDB();

        return Response.ok().entity(electiricians).build();
    }

    @GET
    @Path("/getCornelians")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCornelians() {
        List<Cornelian> cornelians = employeeService.getCorneliansDB();

        return Response.ok().entity(cornelians).build();
    }

    @POST
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(String json) {
        try {
            JsonNode node = objectMapper.readTree(json);

            IPLog ipLog = ipClient.get();

            JsonNode roleNode = node.get("role");
            JsonNode shipNode = node.get("ship_id");
            System.out.println("Role: " + roleNode);

            if(roleNode != null && roleNode.isObject()) {
                JsonNode role = roleNode.get("description");
                if(role != null && role.isTextual() && shipNode != null && shipNode.isTextual()) {
                    String description = role.asText().toLowerCase();
                    String ship_id = shipNode.asText();
                    System.out.println("Description: " + description);
                    switch(description) {
                        case "cornelian":
                            Employee e = objectMapper.readValue(json, Employee.class);
                            e.setIpLog(ipLog);
                            Ship ship = new Ship();
                            ship.setId(Long.parseLong(ship_id));
                            e.setShip(ship);
                            Cornelian c = objectMapper.readValue(json, Cornelian.class);
                            c.setEmployees(e);
                            c.setEmployeeRole(employeeRoleService.getEmployeeRoleByDescriptionSingle(description));
                            employeeService.addCornelianDB(c);
                            employeeService.addEmployeeDB(e);
                            return Response.ok().entity(c).entity(e).build();
                        case "electrician":
                            Employee y = objectMapper.readValue(json, Employee.class);
                            y.setIpLog(ipLog);
                            Ship ship1 = new Ship();
                            ship1.setId(Long.parseLong(ship_id));
                            y.setShip(ship1);
                            employeeService.addEmployeeDB(y);
                            Electirician r = objectMapper.readValue(json, Electirician.class);
                            r.setEmployees(y);
                            r.setEmployeeRole(employeeRoleService.getEmployeeRoleByDescriptionSingle(description));
                            employeeService.addElectricianDB(r);
                            return Response.ok().entity(r).entity(y).build();
                        case "machinist":
                            Employee ye = objectMapper.readValue(json, Employee.class);
                            ye.setIpLog(ipLog);
                            Ship ship2 = new Ship();
                            ship2.setId(Long.parseLong(ship_id));
                            ye.setShip(ship2);
                            employeeService.addEmployeeDB(ye);
                            Machinist mac = objectMapper.readValue(json, Machinist.class);
                            mac.setEmployees(ye);
                            mac.setEmployeeRole(employeeRoleService.getEmployeeRoleByDescriptionSingle(description));
                            employeeService.addMachinistDB(mac);
                            return Response.ok().entity(mac).entity(ye).build();
                        case "officer":
                            Employee l = objectMapper.readValue(json, Employee.class);
                            l.setIpLog(ipLog);
                            Ship ship3 = new Ship();
                            ship3.setId(Long.parseLong(ship_id));
                            l.setShip(ship3);
                            employeeService.addEmployeeDB(l);
                            Officer off = objectMapper.readValue(json, Officer.class);
                            off.setEmployees(l);
                            off.setEmployeeRole(employeeRoleService.getEmployeeRoleByDescriptionSingle(description));
                            employeeService.addOfficerDB(off);
                            return Response.ok().entity(off).entity(l).build();
                        case "worker":
                            Employee lo = objectMapper.readValue(json, Employee.class);
                            lo.setIpLog(ipLog);
                            Ship ship4 = new Ship();
                            ship4.setId(Long.parseLong(ship_id));
                            lo.setShip(ship4);
                            employeeService.addEmployeeDB(lo);
                            Worker w = objectMapper.readValue(json, Worker.class);
                            w.setEmployee(lo);
                            w.setEmployeeRole(employeeRoleService.getEmployeeRoleByDescriptionSingle(description));
                            employeeService.addWorkerDB(w);
                            return Response.ok().entity(w).entity(lo).build();
                    }
                }
            }else {
                return Response.notModified().build();
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Response.notModified().build();
    }
}
