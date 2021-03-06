package sop.library.api.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sop.library.api.base.GetApi;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Role;
import sop.library.model.User;
import sop.library.model.builder.UserModelBuilder;
import sop.library.model.builder.UserModelBuilderImpl;

@Path("users")
@PermitAll
public class Users extends GetApi<User>{

	UserModelBuilder userModelBuilder;
	
	public Users() {
		modelBuilder = new UserModelBuilderImpl();
		userModelBuilder = new UserModelBuilderImpl();
	}
	
	@POST	
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@PermitAll
	public Response create(User user) {
		Long id = modelBuilder.save(user);
		User savedUser = null;
		try {
			savedUser = modelBuilder.get(id);
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(savedUser).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@PermitAll
	public Response update(@PathParam ("id") String id, User user) {
		Long idL = Long.decode(id);
		User updatedUser = null;
		try {
			modelBuilder.update(idL, user);
			updatedUser = modelBuilder.get(idL);
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(updatedUser).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@PermitAll
	public Response delete(@PathParam ("id") String id) {
		Long idL = Long.decode(id);
		try {
			modelBuilder.delete(idL);
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}/roles")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@PermitAll
	public Response getRoles(@PathParam ("id") String id) {
		Long idL = Long.decode(id);
		List<Role> roles = null;
		try {
			roles = userModelBuilder.getUserRoles(idL);
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(roles).build();
	}
}