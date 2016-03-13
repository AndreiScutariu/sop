package sop.library.dal.entities.library;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;
import sop.library.dal.entities.usermanagement.UserEntity;

@Entity
@Table(name = "book_authors")
public class BookAuthorEntity implements BaseEntity  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	//@Type(type = "org.joda.time.contrib.hibernate.PersistentDate")
	private Date createdDate;

	//@Type(type = "org.joda.time.contrib.hibernate.PersistentDate")
	private Date lastModifiedDate;

	@OneToOne(fetch = FetchType.EAGER)
	private UserEntity autor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public UserEntity getAutor() {
		return autor;
	}

	public void setAutor(UserEntity autor) {
		this.autor = autor;
	}

	@OneToOne(fetch = FetchType.EAGER)
	private BookEntity book;
	
	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date date) {
		createdDate = date;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date date) {
		lastModifiedDate = date;
	}
}