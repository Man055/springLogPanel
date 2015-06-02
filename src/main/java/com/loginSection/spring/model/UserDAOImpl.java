package com.loginSection.spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAOImpl implements UserDAO {
	
	
	private SessionFactory sessionFactory;
	public String saveUser(User user){
		System.out.println("------");
		Session session = this.sessionFactory.openSession();
		session.save(user);
		session.close();
		return null;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
