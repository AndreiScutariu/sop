package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.UserEntity;

public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}
	
}
