package sop.library.model.builder;

import java.util.List;

import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Role;
import sop.library.model.User;
import sop.library.model.mapper.RoleMapper;
import sop.library.model.mapper.UserMapper;

public class UserModelBuilderImpl implements UserModelBuilder {
	
	UserMapper userMapper = new UserMapper();
	RoleMapper roleMapper = new RoleMapper();
	
	public List<User> get() {
		UserDao userDao = new UserDaoImpl();
		List<User> users = userMapper.toModelList(userDao.findAll());
		return users;
	}
	
	public User get(Long id) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		if(user == null)
			throw new ResourceNotFoundException();
		User userDto = userMapper.toModel(user);
		return userDto;
	}
	
	public Long save(User userDto) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userMapper.toEntity(userDto);
		userDao.saveOrUpdate(user);
		Long savedUserId = user.getId();
		return savedUserId;
	}
	
	public void update(Long id, User userDto) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userMapper.mapUser(id, userDto);
		userDao.saveOrUpdate(user);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		if(user == null)
			throw new ResourceNotFoundException();
		userDao.delete(user);
	}

	public List<Role> getUserRoles(Long idL) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(idL);
		if(user == null)
			throw new ResourceNotFoundException();
		List<Role> roles = roleMapper.toEntityList(user.getRoles());
		return roles;
	}
}
