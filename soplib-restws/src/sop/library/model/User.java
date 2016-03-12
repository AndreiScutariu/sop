package sop.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	private List<Role> roles = new ArrayList<Role>(0);
	
	public User() { }
	
	public User(Long id, String name, String description, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.roles = roles;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
}