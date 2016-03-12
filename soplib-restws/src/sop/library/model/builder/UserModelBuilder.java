package sop.library.model.builder;

import sop.library.model.User;

public interface UserModelBuilder extends GetModelBuilder<User> {
	User get(Long id);
	void update(Long id, User userDto);
	void delete(Long id);
}