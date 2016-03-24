package sop.library.dal.dao;

import sop.library.dal.entities.usermanagement.UserToken;

public class UserTokenDaoImpl extends BaseDaoImpl<UserToken> implements UserTokenDao {

	public UserTokenDaoImpl() {
		super(UserToken.class);
	}

}
