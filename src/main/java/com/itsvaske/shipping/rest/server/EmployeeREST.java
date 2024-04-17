package com.itsvaske.shipping.rest.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsvaske.shipping.model.*;
import com.itsvaske.shipping.proxies.IPClient;
import com.itsvaske.shipping.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/api/employees")
public class EmployeeREST {

    @Inject
    private EmployeeService employeeService;

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

    @GET
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(String json) {
        try {
            JsonNode node = objectMapper.readTree(json);

            IPLog ipLog = ipClient.get();

            JsonNode roleNode = node.get("role");
            System.out.println("Role: " + roleNode);

            if(roleNode != null && roleNode.isObject()) {
                JsonNode role = roleNode.get("description");
                if(role != null && role.isTextual()) {
                    String description = role.asText().toLowerCase();
                    System.out.println("Description: " + description);
                    switch(description) {
                        case "cornelian":
                            Employee e = objectMapper.readValue(json, Employee.class);
                            e.setIpLog(ipLog);
                            employeeService.addEmployeeDB(e);
                            Cornelian c = employeeService.addCornelianDB(objectMapper.readValue(json, Cornelian.class));
                            return Response.ok().entity(c).entity(e).build();
                        case "electrician":
                            Electirician r = employeeService.addElectricianDB(objectMapper.readValue(json, Electirician.class));
                            Employee y = objectMapper.readValue(json, Employee.class);
                            y.setIpLog(ipLog);
                            employeeService.addEmployeeDB(y);
                            return Response.ok().entity(r).entity(y).build();
                        case "machinist":
                            Machinist mac = employeeService.addMachinistDB(objectMapper.readValue(json, Machinist.class));
                            Employee ye = objectMapper.readValue(json, Employee.class);
                            ye.setIpLog(ipLog);
                            employeeService.addEmployeeDB(ye);
                            return Response.ok().entity(mac).entity(ye).build();
                        case "officer":
                            Officer off = employeeService.addOfficerDB(objectMapper.readValue(json, Officer.class));
                            Employee l = objectMapper.readValue(json, Employee.class);
                            l.setIpLog(ipLog);
                            employeeService.addEmployeeDB(l);
                            return Response.ok().entity(off).entity(l).build();
                        case "worker":
                            Worker w = employeeService.addWorkerDB(objectMapper.readValue(json, Worker.class));
                            Employee lo = objectMapper.readValue(json, Employee.class);
                            lo.setIpLog(ipLog);
                            employeeService.addEmployeeDB(lo);
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
