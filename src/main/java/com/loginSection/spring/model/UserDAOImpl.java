package com.loginSection.spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAOImpl implements UserDAO {
	
	
	private SessionFactory sessionFactory;
	public String saveUser(User user){
		Session session = this.sessionFactory.openSession();
		session.persist(user);
		session.close();
		return null;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
