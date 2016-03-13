package sop.library.dal.entities.usermanagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;

@Entity
@Table(name = "roles")
public class RoleEntity implements BaseEntity {

	public RoleEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	private String name;

	//@Type(type = "org.joda.time.contrib.hibernate.PersistentDate")
	private Date createdDate;

	//@Type(type = "org.joda.time.contrib.hibernate.PersistentDate")
	private Date lastModifiedDate;

	public Long getId() {
		return id;
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
}