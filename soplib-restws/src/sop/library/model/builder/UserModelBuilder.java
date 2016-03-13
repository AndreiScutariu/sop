package sop.library.model.builder;

import java.util.List;

import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Role;
import sop.library.model.User;

public interface UserModelBuilder extends BaseModelBuilder<User> {
	
	//TODO Refactor, extract to base model builder
	Long save(User userDto);
	void update(Long id, User userDto) throws ResourceNotFoundException;
	void delete(Long id) throws ResourceNotFoundException;
	
	List<Role> getUserRoles(Long idL) throws ResourceNotFoundException;
}