package sop.library.dal.entities.usermanagement;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;

@Entity
@Table(name = "roles")
public class Role implements BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "roles_rights", 
		joinColumns = { @JoinColumn(name = "roleid", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "rightId", nullable = false, updatable = false) }
	)
	private Set<Right> rights = new HashSet<Right>(0);
	
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
	public Set<Right> getRights() {
		return rights;
	}
	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}
}