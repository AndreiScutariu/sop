package sop.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Role extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public Role() {
	}

	public Role(Long id, Date created, Date modified, String name) {
		super(id, created, modified);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
