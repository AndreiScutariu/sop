package sop.library.dal.dao;

import java.util.Date;

import org.hibernate.HibernateException;

import sop.library.dal.entities.library.BookAuthorEntity;
import sop.library.dal.entities.library.BookEntity;
import sop.library.dal.utils.HibernateFactory;

public class BookDaoImpl extends BaseDaoImpl<BookEntity> implements BookDao {

	public BookDaoImpl() {
		super(BookEntity.class);
    }
	
	public Long saveOrUpdate(BookEntity book) {
		
        try {
            startOperation();
            if(book.getId() == null) {
            	book.setCreatedDate(new Date());
            }
            book.setLastModifiedDate(new Date());
            session.saveOrUpdate(book);
            
            for(BookAuthorEntity e : book.getAuthors()) {
            	e.setBook(book);
            	session.saveOrUpdate(e);
            }
            
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
            HibernateFactory.close(session);
        }
        return book.getId();
    }
}
