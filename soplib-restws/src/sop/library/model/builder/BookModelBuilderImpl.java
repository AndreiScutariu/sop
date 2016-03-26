package sop.library.model.builder;

import java.util.List;

import sop.library.dal.dao.BookDao;
import sop.library.dal.dao.BookDaoImpl;
import sop.library.dal.entities.library.BookEntity;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Book;
import sop.library.model.mapper.BookMapper;

public class BookModelBuilderImpl implements BookModelBuilder, BaseModelBuilder<Book> {

	BookDao bookDao;
	BookMapper bookMapper = new BookMapper();
	
	public BookModelBuilderImpl() {
		bookDao = new BookDaoImpl();
	}
	
	@Override
	public List<Book> get() {
		List<BookEntity> booEntities = bookDao.findAll();
		List<Book> books = bookMapper.toModelList(booEntities);
		return books;
	}

	@Override
	public Book get(Long id) throws ResourceNotFoundException {
		return null;
	}

	@Override
	public Long save(Book userDto) {
		return null;
	}

	@Override
	public void update(Long id, Book userDto) throws ResourceNotFoundException {
		
	}

	@Override
	public void delete(Long id) throws ResourceNotFoundException {
	}

}
