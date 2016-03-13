package sop.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	public User() {
	}

	public User(Long id, Date created, Date modified, String name, String description, List<Role> roles) {
		super(id, created, modified);
		resourceRoot = "users";
		buildLinks();
		this.name = name;
		this.description = description;
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
	
	public void buildLinks() {
		super.buildLinks();
		Link link = new Link("roles", "/soplib-restws/api/" + resourceRoot + "/" + id + "/roles");
		links.add(link);
	}
}