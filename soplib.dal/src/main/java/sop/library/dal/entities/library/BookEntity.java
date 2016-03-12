package sop.library.dal.entities.library;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;
import sop.library.dal.entities.usermanagement.UserEntity;

@Entity
@Table(name = "books")
public class BookEntity implements BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(fetch = FetchType.EAGER)
	private UserEntity editor;
	
	public UserEntity getEditor() {
		return editor;
	}

	public void setEditor(UserEntity editor) {
		this.editor = editor;
	}

	@OneToMany(mappedBy="book")
	private Set<BookAuthorEntity> authors = new HashSet<BookAuthorEntity>(0);
	
	public Set<BookAuthorEntity> getAuthors() {
		return authors;
	}

	@OneToOne(fetch = FetchType.EAGER)
	private BookStatusEntity status;

	public void setAuthors(Set<BookAuthorEntity> authors) {
		this.authors = authors;
	}
	
	public BookStatusEntity getStatus() {
		return status;
	}

	public void setStatus(BookStatusEntity status) {
		this.status = status;
	}
}
