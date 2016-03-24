package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.UserEntity;

public interface UserDao extends BaseDao<UserEntity> {
	UserEntity getByEmail(String email);
}
