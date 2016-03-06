package sop.library.dal.entities.usermanagement;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;

@Entity
@Table(name = "users")
public class User implements BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
		joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "roleId", nullable = false, updatable = false) }
	)
	private Set<Role> roles = new HashSet<Role>(0);
	
	public User(Long id, String name, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
	}
	
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addNewRole(Role role) {
		if(this.roles == null) {
			this.roles = new HashSet<Role>(0);
		}
		this.roles.add(role);
	}
}