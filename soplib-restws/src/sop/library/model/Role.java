package sop.library.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Role {
	
	private Long id;
	private String name;
	
	public Role() {}
	
	public Role(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
