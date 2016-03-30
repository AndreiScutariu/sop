package sop.library.dal.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.dal.entities.usermanagement.UserToken;
import sop.library.dal.utils.HibernateFactory;

public class UserTokenDaoImpl extends BaseDaoImpl<UserToken> implements
		UserTokenDao {

	public UserTokenDaoImpl() {
		super(UserToken.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getByToken(String token) {
		UserEntity user = null;
		try {
			startOperation();
			Query query = session.createQuery("from " + UserToken.class.getName());
			List<UserToken> list = query.list();
			for (UserToken ut : list) {
				if (ut.getToken().equals(token)) {
					user = ut.getUser();
					break;
				}
			}
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateFactory.close(session);
		}

		return user;
	}
}
