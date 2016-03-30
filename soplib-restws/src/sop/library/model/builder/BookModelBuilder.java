package sop.library.model.builder;

import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Book;

public interface BookModelBuilder {

	void publish(Book book, String token) throws ResourceNotFoundException;
	
}
