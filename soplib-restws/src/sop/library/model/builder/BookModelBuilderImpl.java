package sop.library.model.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sop.library.dal.dao.BookAuthorDaoImpl;
import sop.library.dal.dao.BookDao;
import sop.library.dal.dao.BookDaoImpl;
import sop.library.dal.dao.UserTokenDao;
import sop.library.dal.dao.UserTokenDaoImpl;
import sop.library.dal.entities.library.BookAuthorEntity;
import sop.library.dal.entities.library.BookEntity;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Book;
import sop.library.model.mapper.BookMapper;

public class BookModelBuilderImpl implements BookModelBuilder,
		BaseModelBuilder<Book> {

	BookDao bookDao;
	BookAuthorDaoImpl bookAuthorDaoImpl;
	BookMapper bookMapper;

	public BookModelBuilderImpl() {
		bookDao = new BookDaoImpl();
		bookAuthorDaoImpl = new BookAuthorDaoImpl();
		bookMapper = new BookMapper();
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

	@Override
	public void publish(Book book, String userToken) throws ResourceNotFoundException {

		UserTokenDao userDao = new UserTokenDaoImpl();
		UserEntity user = userDao.getByToken(userToken);
		if (user == null) {
			throw new ResourceNotFoundException();
		}
				
		BookEntity bookEntity = bookMapper.toEntity(book);

		Set<BookAuthorEntity> authors = buildAuthorList(user, bookEntity);
		bookEntity.setAuthors(authors);
		
		bookDao.saveOrUpdate(bookEntity);
	}

	private Set<BookAuthorEntity> buildAuthorList(UserEntity userEntity,
			BookEntity bookEntity) {

		Set<BookAuthorEntity> authors = new HashSet<BookAuthorEntity>();
		BookAuthorEntity author = new BookAuthorEntity();

		author.setBook(bookEntity);
		author.setAutor(userEntity);
		authors.add(author);

		return authors;
	}

}
