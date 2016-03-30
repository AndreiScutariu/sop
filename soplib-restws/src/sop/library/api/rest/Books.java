package sop.library.api.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sop.library.api.base.GetApi;
import sop.library.api.security.utils.HeaderFieldsHelper;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Book;
import sop.library.model.builder.BookModelBuilder;
import sop.library.model.builder.BookModelBuilderImpl;
import sop.library.model.builder.UserModelBuilder;
import sop.library.model.builder.UserModelBuilderImpl;

@Path("books")
public class Books extends GetApi<Book> {

	BookModelBuilder bookModelBuilder;
	UserModelBuilder userModelBuilder;

	protected Books() {
		modelBuilder = new BookModelBuilderImpl();
		bookModelBuilder = new BookModelBuilderImpl();
		userModelBuilder = new UserModelBuilderImpl();
	}

	// TODO GUEST
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/search")
	public void search() {

	}

	// TODO AUTHOR
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/publish")
	@RolesAllowed("author")
	public Response publish(Book book,
			@HeaderParam("Authorization") String token) {
		try {
			bookModelBuilder.publish(book, HeaderFieldsHelper.getToken(token));
		} catch (ResourceNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity("Error on server. :(").build();
		}
		return Response.status(Status.OK).build();
	}
}
