package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
