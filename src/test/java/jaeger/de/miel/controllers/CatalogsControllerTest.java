package jaeger.de.miel.controllers;

import jaeger.de.miel.model.pojos.Status;
import jaeger.de.miel.model.pojos.Cd;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CatalogsControllerTest {

    private WebTarget target;

    @Test
    public void test() {

        Cd cd = new Cd();
        cd.setTitle("In Utero");
        cd.setArtist("Nirvana");
        cd.setGenre("Grunge");

        WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:9292/api/hellojersey");

        final Response response = webTarget
                .path("/catalogs/miel")
                .request()
                .buildPut(Entity.json(cd))
                .invoke();

        Status status = response.readEntity(Status.class);
        System.out.println(status.toString());
        assertThat(status.getCode().name(), is("OK"));
        assertThat(status.getMessage(), is("In Utero by Nirvana successfully added to catalog."));
    }

}
