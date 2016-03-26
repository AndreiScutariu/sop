package sop.library.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import sop.library.model.*;
import sop.library.dal.entities.usermanagement.RoleEntity;

public class RoleMapper implements Mapper<Role, RoleEntity> {
	
	public Role toModel(RoleEntity role) {
		return new Role(role.getId(), role.getCreatedDate(), role.getLastModifiedDate(), role.getName());
	}
	
	public List<Role> toModelList(List<RoleEntity> roles) {
		List<Role> rolesDtos = new ArrayList<Role>();
		for(RoleEntity role : roles) {
			rolesDtos.add(toModel(role));
		}
		return rolesDtos;
	}
	
	public List<Role> toEntityList(Set<RoleEntity> roles) {
		List<Role> rolesDtos = new ArrayList<Role>();
		for(RoleEntity role : roles) {
			rolesDtos.add(toModel(role));
		}
		return rolesDtos;
	}

	@Override
	public RoleEntity toEntity(Role dto) {
		return null;
	}

	@Override
	public List<RoleEntity> toEntityList(List<Role> dtos) {
		return null;
	}
}
