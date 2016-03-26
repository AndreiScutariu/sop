package sop.library.model.builder;

import java.util.List;

import sop.library.exceptions.ResourceNotFoundException;
import sop.library.model.Role;
import sop.library.model.User;

public interface UserModelBuilder extends BaseModelBuilder<User> {
	List<Role> getUserRoles(Long idL) throws ResourceNotFoundException;
}