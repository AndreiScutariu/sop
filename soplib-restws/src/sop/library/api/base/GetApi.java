package sop.library.api.base;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sop.library.model.builder.GetModelBuilder;

public abstract class GetApi<T> {
	protected GetModelBuilder<T> modelBuilder;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> getAll() {
		return modelBuilder.get();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public T get(@PathParam ("id") String id) {
		Long idL = Long.decode(id);
		return modelBuilder.get(idL);
	}
}
