package jaeger.de.miel.exceptions;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class MielsExceptionMapper implements ExceptionMapper<MielsException> {

    @Override
    public Response toResponse(MielsException exception) {
        log.error(exception.toString());
        String result = exception.getMessage();
        return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }
}
