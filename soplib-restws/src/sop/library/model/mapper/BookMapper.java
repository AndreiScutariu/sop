package sop.library.model.mapper;

import java.util.ArrayList;
import java.util.List;

import sop.library.dal.entities.library.BookEntity;
import sop.library.dal.entities.library.BookStatusEntity;
import sop.library.model.Book;

public class BookMapper implements Mapper<Book, BookEntity> {

	UserMapper userMapper = new UserMapper();

	@Override
	public Book toModel(BookEntity entity) {
		return new Book(entity.getId(), entity.getCreatedDate(),
				entity.getLastModifiedDate(), entity.getName(),
				entity.getDescription(),
				userMapper.toModel(entity.getEditor()), userMapper.toModelList(entity.getAuthorsList()));
	}

	@Override
	public List<Book> toModelList(List<BookEntity> entities) {
		List<Book> list = new ArrayList<Book>();
		for (BookEntity b : entities) {
			list.add(toModel(b));
		}
		return list;
	}

	@Override
	public BookEntity toEntity(Book dto) {
		BookEntity book = new BookEntity();
		
		book.setDescription(dto.getDescription());
		book.setName(dto.getName());
		
		BookStatusEntity status = new BookStatusEntity();
		status.setId(2L);
		book.setStatus(status);
		
		return book;
	}

	@Override
	public List<BookEntity> toEntityList(List<Book> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
