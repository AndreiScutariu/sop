package sop.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private User editor;

	private List<User> authors;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public Book(Long id, Date created, Date modified, String name,
			String description, User editor, List<User> authors) {
		super(id, created, modified);
		this.name = name;
		this.description = description;
		this.editor = editor;
		this.authors = authors;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public User getEditor() {
		return editor;
	}

	public void setEditor(User editor) {
		this.editor = editor;
	}

	public List<User> getAuthors() {
		return authors;
	}

	public void setAuthors(List<User> authors) {
		this.authors = authors;
	}
}
