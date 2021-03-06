package sop.library.api.base;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.builder.BaseModelBuilder;

public abstract class GetApi<T> {
	protected BaseModelBuilder<T> modelBuilder;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@PermitAll //TODO Here
	public List<T> getAll() {
		List<T> list = modelBuilder.get();
		return list;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{id}")
	@PermitAll //TODO Here
	public Response get(@PathParam("id") String id) {
		Long idL = Long.decode(id);
		T obj;
		try {
			obj = modelBuilder.get(idL);
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity("Error on server. :(").build();
		}
		return Response
				.ok()
				.entity(obj)
				.build();
	}
}