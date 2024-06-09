package com.itsvaske.shipping.multipart;

import com.itsvaske.shipping.model.Cornelian;
import com.itsvaske.shipping.model.Employee;
import com.itsvaske.shipping.model.EmployeeRole;
import com.itsvaske.shipping.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Path("/api/multipart")
public class MultipartClientResource {

    @Inject
    @RestClient
    MultipartService multipartService;

    @Inject
    EmployeeService em;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendFile(@MultipartForm MultipartBody body) throws Exception {
        String employee = new String(body.getFile().readAllBytes(), StandardCharsets.UTF_8);
        if(employee.contains("Employee")) {
            BufferedReader reader = new BufferedReader(new StringReader(employee));
            String firstName = "";
            String lastName = "";
            long JMBG = 0;
            int skillLevel = 0;
            int drivingTime = 0;
            int ship_id = 0;
            EmployeeRole employeeRole = new EmployeeRole();
            System.out.println(employee);
            while(reader.readLine() != null) {
                String line = reader.readLine();
                if(line.contains("First name")) {
                    firstName = line.split(":")[1];
                }else if(reader.readLine().contains("Last name")) {
                    lastName = line.split(":")[1];
                }else if(reader.readLine().contains("JMBG")) {
                    JMBG = Long.parseLong(line.split(":")[1]);
                }else if(reader.readLine().contains("Skill level")) {
                    skillLevel = Integer.parseInt(line.split(":")[1]);
                }else if(line.contains("Driving time")) {
                    drivingTime = Integer.parseInt(line.split(":")[1]);
                }else if(line.contains("ship_id")) {
                    ship_id = Integer.parseInt(line.split(":")[1]);
                }else if(line.contains("Role")) {
                    employeeRole.setDescription(line.split(":")[1]);
                }
            }
            Cornelian employee1 = em.addCornelianDB(new Cornelian(firstName, lastName, JMBG, skillLevel, drivingTime, employeeRole));
            if(employee1 != null) {
                return "New employee added";
            }
        }
        return "File is not valid";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String callSend() {
        final MultipartBody multipartBody = new MultipartBody();
        multipartBody.setFile(new ByteArrayInputStream("Hello World".getBytes()));
        multipartBody.setFileName("hello.txt");
        return multipartService.sendMultipartData(multipartBody);
    }
}
