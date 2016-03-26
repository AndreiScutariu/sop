package sop.library.dal.dao;

import sop.library.dal.entities.library.BookEntity;

public class BookDaoImpl extends BaseDaoImpl<BookEntity> implements BookDao {

	public BookDaoImpl() {
		super(BookEntity.class);
    }
	
}
