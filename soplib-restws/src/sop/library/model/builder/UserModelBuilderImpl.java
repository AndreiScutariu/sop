package sop.library.model.builder;

import java.util.ArrayList;
import java.util.List;

import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.model.User;
import sop.library.model.mapper.UserMapper;

public class UserModelBuilderImpl implements UserModelBuilder {
	
	public Long save(User userDto) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = UserMapper.buildFromDto(userDto);
		userDao.saveOrUpdate(user);
		Long savedUserId = user.getId();
		return savedUserId;
	}
	
	public List<User> get() {
		List<User> users = new ArrayList<User>();
		UserDao userDao = new UserDaoImpl();
		for(UserEntity user : userDao.findAll()) {
			users.add(UserMapper.buildFromEntity(user));
		}
		return users;
	}
	
	public User get(Long id) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		if(user == null)
			return null;
		User userDto = UserMapper.buildFromEntity(user);
		return userDto;
	}

	public void update(Long id, User userDto) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = UserMapper.mapUser(id, userDto);
		userDao.saveOrUpdate(user);
	}
	
	public void delete(Long id) {
		UserDao userDao = new UserDaoImpl();
		UserEntity user = userDao.find(id);
		userDao.delete(user);
	}

	
}
