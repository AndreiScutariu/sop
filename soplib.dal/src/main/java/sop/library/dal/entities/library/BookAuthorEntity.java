package sop.library.dal.entities.library;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	private UserEntity autor;
	
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
}