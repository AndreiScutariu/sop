package sop.library.dal.entities.library;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;

@Entity
@Table(name = "book_changes")
public class BookChange implements BaseEntity {
	
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
	private ChangeType changeType;

	public ChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	private Book oldBook;
	
	public Book getOldBook() {
		return oldBook;
	}
	
	public void setOldBook(Book oldBook) {
		this.oldBook = oldBook;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	private Book newBook;

	public Book getNewBook() {
		return newBook;
	}

	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}
}