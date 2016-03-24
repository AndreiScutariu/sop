package sop.library.dal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.dal.utils.HibernateFactory;

public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@SuppressWarnings("unchecked")
	public UserEntity getByEmail(String email) {
		UserEntity user = null;
		try {
			startOperation();
			Criteria criteria = session.createCriteria(UserEntity.class);
			criteria.add(Restrictions.eq("email", email));
			List<UserEntity> list = criteria.list();
			if (list != null && list.size() > 0) {
				user = list.get(0);
			}
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			HibernateFactory.close(session);
		}
		return user;
	}
}
