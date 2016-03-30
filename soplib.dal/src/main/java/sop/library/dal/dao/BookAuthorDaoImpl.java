package sop.library.dal.dao;

import sop.library.dal.entities.library.BookAuthorEntity;

public class BookAuthorDaoImpl extends BaseDaoImpl<BookAuthorEntity> implements BookAuthorDao {

	public BookAuthorDaoImpl() {
		super(BookAuthorEntity.class);
    }
	
}
