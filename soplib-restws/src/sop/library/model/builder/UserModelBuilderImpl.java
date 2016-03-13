package sop.library.model.builder;

import java.util.ArrayList;
import java.util.List;

import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.User;
import sop.library.model.mapper.UserMapper;

public class UserModelBuilderImpl implements UserModelBuilder {
	
	public List<User> get() {
		List<User> users = new ArrayList<User>();
		UserDao userDao = new UserDaoImpl();
		for(UserEntity user : userDao.findAll()) {
			users.add(UserMapper.buildFromEntity(user));
		}
		return users;
	}
	
	public User get(Long id) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		if(user == null)
			throw new ResourceNotFoundException();
		User userDto = UserMapper.buildFromEntity(user);
		return userDto;
	}
	
	public Long save(User userDto) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = UserMapper.buildFromDto(userDto);
		userDao.saveOrUpdate(user);
		Long savedUserId = user.getId();
		return savedUserId;
	}
	
	public void update(Long id, User userDto) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = UserMapper.mapUser(id, userDto);
		userDao.saveOrUpdate(user);
	}
	
	public void delete(Long id) throws ResourceNotFoundException {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		if(user == null)
			throw new ResourceNotFoundException();
		userDao.delete(user);
	}
}
