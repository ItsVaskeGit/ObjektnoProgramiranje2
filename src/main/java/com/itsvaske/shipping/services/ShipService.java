package com.itsvaske.shipping.services;

import com.itsvaske.shipping.model.Ship;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Dependent
@Path("/ship")
@OpenAPIDefinition(
        tags = {
                @Tag(name="widget", description="Widget operations."),
                @Tag(name="gasket", description="Operations related to gaskets")
        },
        info = @Info(
                title="Ship API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Software Api",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ShipService {

    @Inject
    EntityManager em;

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
