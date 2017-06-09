package jaeger.de.miel.controllers;

import jaeger.de.miel.exceptions.MielsException;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/")
public class HelloExceptionController {

    @Path("/users/{id}")
    @GET
    public Response getUserBId(@PathParam("id") String id) throws MielsException {
        log.debug("Fetching user with id " + id);
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new MielsException("id is not a number !!");
        }
        //Process the request
        return Response.ok().entity("User with ID " + id + " found !!").build();
    }


    @Path("/exception")
    @GET
    public Response throwException() throws MielsException {
        log.debug("Throw an excpetion");
        throw new MielsException("id is not a number !!");
    }
}
