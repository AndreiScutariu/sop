package sop.library.model.builder;

import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.User;

public interface UserModelBuilder extends BaseModelBuilder<User> {
	Long save(User userDto);
	void update(Long id, User userDto) throws ResourceNotFoundException;
	void delete(Long id) throws ResourceNotFoundException;
}