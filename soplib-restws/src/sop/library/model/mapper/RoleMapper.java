package sop.library.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import sop.library.model.*;
import sop.library.dal.entities.usermanagement.RoleEntity;

public class RoleMapper {
	public static Role buildFromEntity(RoleEntity role) {
		return new Role(role.getId(), role.getCreatedDate(), role.getLastModifiedDate(), role.getName());
	}
	
	public static List<Role> buildFromEntities(List<RoleEntity> roles) {
		List<Role> rolesDtos = new ArrayList<Role>();
		for(RoleEntity role : roles) {
			rolesDtos.add(buildFromEntity(role));
		}
		return rolesDtos;
	}
	
	public static List<Role> buildFromEntities(Set<RoleEntity> roles) {
		List<Role> rolesDtos = new ArrayList<Role>();
		for(RoleEntity role : roles) {
			rolesDtos.add(buildFromEntity(role));
		}
		return rolesDtos;
	}
}
