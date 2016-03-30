package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.dal.entities.usermanagement.UserToken;

public interface UserTokenDao extends BaseDao<UserToken>   {

	UserEntity getByToken(String token);

}
