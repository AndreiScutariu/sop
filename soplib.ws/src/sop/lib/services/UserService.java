package sop.lib.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sop.lib.dto.UserDto;
import sop.lib.mappers.UserMapper;
import sop.library.dal.dao.UserDao;
import sop.library.dal.dao.UserDaoImpl;
import sop.library.dal.entities.usermanagement.User;

@WebService
public class UserService {
	
	public UserService() { }
	
	@WebMethod
	public Long add(UserDto userDto) {
		UserDao userDao = new UserDaoImpl();
		User user = UserMapper.buildFromDto(userDto);
		userDao.saveOrUpdate(user);
		return user.getId();
	}
	
	@WebMethod
	public UserDto get(Long id) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.find(id);
		if(user == null)
			return null;
		return UserMapper.buildFromEntity(user);
	}
	
	@WebMethod
	public void update(Long id, UserDto userDto) {
		UserDao userDao = new UserDaoImpl();
		User user = UserMapper.mapUser(id, userDto);
		userDao.saveOrUpdate(user);
	}
	
	@WebMethod
	public void delete(Long id) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.find(id);
		userDao.delete(user);
	}
}