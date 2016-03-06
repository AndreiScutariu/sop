package sop.lib.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import sop.lib.dto.RoleDto;
import sop.library.dal.entities.usermanagement.Role;

public class RoleMapper {
	public static RoleDto buildFromEntity(Role role) {
		return new RoleDto(role.getId(), role.getName());
	}
	
	public static List<RoleDto> buildFromEntities(List<Role> roles) {
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();
		for(Role role : roles) {
			rolesDtos.add(buildFromEntity(role));
		}
		return rolesDtos;
	}
	
	public static List<RoleDto> buildFromEntities(Set<Role> roles) {
		List<RoleDto> rolesDtos = new ArrayList<RoleDto>();
		for(Role role : roles) {
			rolesDtos.add(buildFromEntity(role));
		}
		return rolesDtos;
	}
}
