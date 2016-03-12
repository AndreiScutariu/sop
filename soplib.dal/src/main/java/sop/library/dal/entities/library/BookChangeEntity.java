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
public class BookChangeEntity implements BaseEntity {
	
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
	private ChangeTypeEntity changeType;

	public ChangeTypeEntity getChangeType() {
		return changeType;
	}

	public void setChangeType(ChangeTypeEntity changeType) {
		this.changeType = changeType;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	private BookEntity oldBook;
	
	public BookEntity getOldBook() {
		return oldBook;
	}
	
	public void setOldBook(BookEntity oldBook) {
		this.oldBook = oldBook;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	private BookEntity newBook;

	public BookEntity getNewBook() {
		return newBook;
	}

	public void setNewBook(BookEntity newBook) {
		this.newBook = newBook;
	}
}