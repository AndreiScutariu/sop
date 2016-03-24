package sop.library.dal.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

import sop.library.dal.entities.BaseEntity;
import sop.library.dal.utils.HibernateFactory;
import sop.library.exceptions.DataAccessLayerException;

public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
	
	protected Session session;
	protected Transaction tx;

    private Class<T> genericType;
    
    public BaseDaoImpl(Class<T> genericType) {
    	this.genericType = genericType;
        HibernateFactory.buildIfNeeded();
    }

    public Long saveOrUpdate(T obj) {
        try {
            startOperation();
            if(obj.getId() == null) {
            	obj.setCreatedDate(new Date());
            }
            obj.setLastModifiedDate(new Date());
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj.getId();
    }

    @SuppressWarnings("unchecked")
	public T find(Long id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(genericType, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        if(obj == null)
        	return null;
        return (T) obj;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List<T> objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + genericType.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }
    
    public void delete(T obj) {
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }
}
