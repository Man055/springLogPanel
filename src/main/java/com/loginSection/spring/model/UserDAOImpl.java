package com.loginSection.spring.model;

import java.util.List;

import org.hibernate.Query;
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
	
	public boolean verifyUser(User user){
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where Email=:Email");
		query.setParameter("Email", user.getEmail());
		List<?> list = query.list();
		User users = !list.isEmpty()?(User) list.get(0):null;
		if(users==null)
			return false;
		return true;
		
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
