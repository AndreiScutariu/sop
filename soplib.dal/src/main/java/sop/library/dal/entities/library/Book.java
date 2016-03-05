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
import sop.library.dal.entities.usermanagement.User;

@Entity
@Table(name = "books")
public class Book implements BaseEntity{
	
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
	private User editor;
	
	public User getEditor() {
		return editor;
	}

	public void setEditor(User editor) {
		this.editor = editor;
	}

	@OneToMany(mappedBy="book")
	private Set<BookAuthor> authors = new HashSet<BookAuthor>(0);
	
	public Set<BookAuthor> getAuthors() {
		return authors;
	}

	@OneToOne(fetch = FetchType.LAZY)
	private BookStatus status;

	public void setAuthors(Set<BookAuthor> authors) {
		this.authors = authors;
	}
	
	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}
}
