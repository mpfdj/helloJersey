package jaeger.de.miel.controllers;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/")
public class HelloWorldController {

    @Path("/helloworld")
    @GET
    public Response helloWorld() {
        log.debug("Fetching hello world");
        String result = "HelloWorld!";
        return Response.ok().entity(result).build();
    }

}
