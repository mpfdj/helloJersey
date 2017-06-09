package jaeger.de.miel.controllers;

import jaeger.de.miel.model.pojos.HelloWorld;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/")
public class HelloJsonController {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/hellojson")
    public HelloWorld helloJson() {
        log.debug("Fetching json");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setGreeting("Hello Json");
        return helloWorld;
    }
}
