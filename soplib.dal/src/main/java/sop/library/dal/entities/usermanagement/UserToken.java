package sop.library.dal.entities.usermanagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sop.library.dal.entities.BaseEntity;

@Entity
@Table(name = "usertoken")
public class UserToken implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UserEntity user;
	
	private String token;
	
	private Date expireAt;
	
	private Date createdDate;
	
	private Date lastModifiedDate;
	
	public UserToken() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity userEntity) {
		this.user = userEntity;
	}
}
