package sop.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdDate;

	private Date lastModifiedDate;

	public BaseModel() {}
	
	public BaseModel(Long id, Date created, Date modified) {
		this.id = id;
		this.createdDate = created;
		this.lastModifiedDate = modified;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
