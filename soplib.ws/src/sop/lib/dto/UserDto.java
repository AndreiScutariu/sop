package sop.lib.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
	
	private Long id;
	private String name;
	private List<RoleDto> roles = new ArrayList<RoleDto>(0);
	
	public UserDto() { }
	
	public UserDto(Long id, String name, List<RoleDto> roles) {
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
	public List<RoleDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}