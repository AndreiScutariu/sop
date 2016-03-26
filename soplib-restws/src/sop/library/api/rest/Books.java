package sop.library.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sop.library.api.base.GetApi;
import sop.library.model.Book;
import sop.library.model.builder.BookModelBuilder;
import sop.library.model.builder.BookModelBuilderImpl;

@Path("books")
public class Books extends GetApi<Book> {
	
	BookModelBuilder bookModelBuilder;
	
	protected Books() {
		modelBuilder = new BookModelBuilderImpl();
		bookModelBuilder = new BookModelBuilderImpl();
	}
	
	//TODO GUEST
	@POST	
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/search")
	public void search() {
		
	}
	
	//TODO AUTHOR
	@POST	
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/publish")
	public void publish(Book book) {
		
	}
	
}
