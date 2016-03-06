package sop.lib.mappers;

import java.util.HashSet;
import java.util.Set;

import sop.lib.dto.RoleDto;
import sop.lib.dto.UserDto;
import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.entities.usermanagement.Role;
import sop.library.dal.entities.usermanagement.User;

public class UserMapper {
	public static User buildFromDto(UserDto userDto) {
		User user = new User(userDto.getId(), userDto.getName(), null);
		RoleDao roleDao = new RoleDaoImpl();
		Set<Role> roles = user.getRoles();
		if(roles == null) {
			roles = new HashSet<Role>();
		}
		for(RoleDto role : userDto.getRoles()) {
			roles.add(roleDao.find(role.getId()));
		}
		user.setRoles(roles);
		return user;
	}
	public static UserDto buildFromEntity(User user) {
		return new UserDto(user.getId(), user.getName(), RoleMapper.buildFromEntities(user.getRoles()));
	}
}
