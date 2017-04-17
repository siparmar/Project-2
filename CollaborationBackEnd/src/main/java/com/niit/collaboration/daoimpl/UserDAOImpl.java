package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserDAOImpl implements UserDAO {

	public SessionFactory sessionFactory;

	public User get(String id) {

		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public boolean isvalidCredentials(String id, String password) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where id= ? and password =?");
		query.setString(1, id);
		query.setString(2, password);

		if (query.uniqueResult() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean save(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
}
