package business;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable e) {
		return Response.status(Status.NOT_FOUND).entity("Error: " + e.getMessage()).build();
	}
}
