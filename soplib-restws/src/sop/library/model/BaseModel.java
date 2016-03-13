package sop.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String resourceRoot;
		
	protected Long id;

	private Date createdDate;

	private Date lastModifiedDate;

	protected List<Link> links;
	
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
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void buildLinks() {
		links = new ArrayList<Link>();
		Link link = new Link("self", "/soplib-restws/api/" + resourceRoot + "/" + id);
		links.add(link);
	}
}
