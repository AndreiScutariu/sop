package sop.library.dal.utils;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import sop.library.dal.entities.library.BookAuthorEntity;
import sop.library.dal.entities.library.BookChangeEntity;
import sop.library.dal.entities.library.BookEntity;
import sop.library.dal.entities.library.BookStatusEntity;
import sop.library.dal.entities.library.ChangeTypeEntity;
import sop.library.dal.entities.usermanagement.RoleEntity;
import sop.library.dal.entities.usermanagement.UserEntity;
import sop.library.exceptions.DataAccessLayerException;

public class HibernateFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() throws HibernateException {
        if (sessionFactory != null) {
            closeFactory();
        }
        return configureSessionFactory();
    }

    public static SessionFactory buildIfNeeded() throws DataAccessLayerException{
        if (sessionFactory != null) {
            return sessionFactory;
        }
        try {
            return configureSessionFactory();
        } catch (HibernateException e) {
            throw new DataAccessLayerException(e);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() throws HibernateException {
        buildIfNeeded();
        return sessionFactory.openSession();
    }

    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                System.out.println("Couldn't close SessionFactory. Exception: " + ignored.getMessage());
            }
        }
    }

    public static void close(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
            	 System.out.println("Couldn't close Session. Exception: " + ignored.getMessage());
            }
        }
    }

    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
        	System.out.println("Couldn't rollback Transaction. Exception: " + ignored.getMessage());
        }
    }
    
    @SuppressWarnings("deprecation")
	private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        
        File f = new File("D:\\Projects\\sop-library\\source\\soplib.dal\\src\\main\\java\\sop\\library\\dal\\utils\\hibernate.cfg.xml"); 
        configuration.configure(f);
        
        configuration.addAnnotatedClass(RoleEntity.class);
        configuration.addAnnotatedClass(UserEntity.class);
        
        configuration.addAnnotatedClass(BookEntity.class);
        configuration.addAnnotatedClass(BookAuthorEntity.class);
        configuration.addAnnotatedClass(BookChangeEntity.class);
        configuration.addAnnotatedClass(BookStatusEntity.class);
        configuration.addAnnotatedClass(ChangeTypeEntity.class);
        
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}

