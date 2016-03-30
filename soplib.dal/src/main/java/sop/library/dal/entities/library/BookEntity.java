package sop.library.dal.entities.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

	private String name;
	
	private String description;

	@OneToOne(fetch = FetchType.EAGER)
	private BookStatusEntity status;

	@OneToOne(fetch = FetchType.EAGER)
	private UserEntity editor;
	
	@OneToMany(mappedBy="book", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<BookAuthorEntity> authors = new HashSet<BookAuthorEntity>(0);
	
	private Date createdDate;

	private Date lastModifiedDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public UserEntity getEditor() {
		return editor;
	}

	public void setEditor(UserEntity editor) {
		this.editor = editor;
	}
	
	public Set<BookAuthorEntity> getAuthors() {
		return authors;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setAuthors(Set<BookAuthorEntity> authors) {
		this.authors = authors;
	}
	
	public BookStatusEntity getStatus() {
		return status;
	}

	public void setStatus(BookStatusEntity status) {
		this.status = status;
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

	public List<UserEntity> getAuthorsList() {
		List<UserEntity> users = new ArrayList<UserEntity>();
		for(BookAuthorEntity e : getAuthors()) {
			users.add(e.getAutor());
		}
		return users;
	}
}
