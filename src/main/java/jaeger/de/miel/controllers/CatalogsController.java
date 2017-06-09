package jaeger.de.miel.controllers;

import jaeger.de.miel.exceptions.MielsException;
import jaeger.de.miel.model.pojos.Catalog;
import jaeger.de.miel.model.pojos.Catalogs;
import jaeger.de.miel.model.pojos.Cd;
import jaeger.de.miel.model.pojos.Status;
import jaeger.de.miel.model.pojos.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Slf4j
@Path("/")
public class CatalogsController {

    @Autowired
    private Catalogs catalogs;

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("/catalogs/{catalog}")
    public Status addCdToCatalog(@NotNull @PathParam("catalog") String catalog, @Valid @NotNull Cd cd) {
        log.debug("Adding cd to catalog " + catalog);
        log.debug(cd.toString());

        Map<String, Catalog> myCatalogs = catalogs.getCatalogs();
        if (! myCatalogs.containsKey(catalog)) throw new MielsException("Catalog not found.");

        Catalog myCatalog = myCatalogs.get(catalog);
        myCatalog.addCd(cd);

        Status status = new Status();
        status.setCode(StatusCode.OK);
        status.setMessage(cd.getTitle() + " by " + cd.getArtist() + " successfully added to catalog.");
        return status;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/catalogs/{catalog}")
    public Catalog getCatalog(@PathParam("catalog") String catalog) {
        log.debug("Fetching catalog " + catalog);
        Map<String, Catalog> myCatalogs = catalogs.getCatalogs();
        if (! myCatalogs.containsKey(catalog)) throw new MielsException("Catalog not found.");
        return myCatalogs.get(catalog);
    }

}
