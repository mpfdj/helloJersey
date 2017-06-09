package jaeger.de.miel.controllers;

import jaeger.de.miel.model.pojos.Catalog;
import jaeger.de.miel.model.pojos.Cd;
import jaeger.de.miel.model.pojos.Status;
import jaeger.de.miel.model.pojos.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Path("/")
public class TestCatalogController {

    @Autowired
    private Catalog catalog;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/catalogs/test")
    public Status addCdToCatalog(@Valid @NotNull Cd cd) {
        log.debug("Adding cd to test catalog");
        log.debug(cd.toString());

        catalog.addCd(cd);

        Status status = new Status();
        status.setCode(StatusCode.OK);
        status.setMessage(cd.getTitle() + " by " + cd.getArtist() + " successfully added to catalog.");
        return status;
    }

}
