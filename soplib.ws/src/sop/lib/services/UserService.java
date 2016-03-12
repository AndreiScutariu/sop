package sop.lib.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import sop.library.bll.UserHandler;
import sop.library.bll.UserHandlerImpl;
import sop.library.bll.dto.UserDto;

@WebService
public class UserService {
	
	UserHandler handler;
	public UserService() { 
		handler = new UserHandlerImpl();
	}
	
	@WebMethod
	public Long add(UserDto userDto) {
		Long savedUserId = handler.saveUser(userDto);
		return savedUserId;
	}

	@WebMethod
	public UserDto get(Long id) {
		UserDto userDto = handler.getUser(id);
		return userDto;
	}
	
	@WebMethod
	public void update(Long id, UserDto userDto) {
		handler.updateUser(id, userDto);
	}
	
	@WebMethod
	public void delete(Long id) {
		handler.deleteUser(id);
	}
}