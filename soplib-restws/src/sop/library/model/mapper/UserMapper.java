package sop.library.model.mapper;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import sop.library.model.*;

import sop.library.dal.dao.RoleDao;
import sop.library.dal.dao.RoleDaoImpl;
import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.entities.usermanagement.RoleEntity;
import sop.library.dal.entities.usermanagement.UserEntity;

public class UserMapper {

	public static UserEntity buildFromDto(User userDto) {
		UserEntity user = new UserEntity(userDto.getId(), userDto.getName(), userDto.getDescription(), null);
		RoleDao roleDao = new RoleDaoImpl();
		Set<RoleEntity> roles = user.getRoles();
		if(roles == null) {
			roles = new HashSet<RoleEntity>();
		}
		for(Role role : userDto.getRoles()) {
			roles.add(roleDao.find(role.getId()));
		}
		user.setRoles(roles);
		return user;
	}
	
	public static UserEntity mapUser(Long id, User userDto) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		user.setName(userDto.getName());
		user.setDescription(userDto.getDescription());

		return user;
	}
	
	public static User buildFromEntity(UserEntity user) {
		User userDto = new User(user.getId(), user.getName(), user.getDescription(), null);
		userDto.setRoles(new ArrayList<Role>(0));
		return userDto;
	}
}
