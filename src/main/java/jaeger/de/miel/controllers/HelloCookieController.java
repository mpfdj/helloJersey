package jaeger.de.miel.controllers;

import jaeger.de.miel.model.pojos.HelloWorld;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;

@Slf4j
@Path("/")
public class HelloCookieController {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/hellocookie")
    public Response helloCoookie() {
        log.debug("Fetching cookies");

        String identifier = createRandomIdentifier();
        NewCookie cookie1 = new NewCookie("XSRF-TOKEN", identifier);

        String name = "USERNAME";
        String value = "Miel de Jaeger";
        String path = "/api/hellojersey/hellocookie";
        String domain = "";
        String comment = "This cookie store the username.";
        int maxAge = 60;  // in seconds
        boolean secure = false;
        NewCookie cookie2 = new NewCookie(name, value, path, domain, comment, maxAge, secure);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setGreeting("hello cookie");

        return Response
                .ok()
                .entity(helloWorld)
                .cookie(cookie1, cookie2)
                .build();
    }

    private String createRandomIdentifier() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
