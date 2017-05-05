package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Transactional
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public User get(String user_id) {

		return (User) sessionFactory.getCurrentSession().load(User.class, user_id);
	}

	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public boolean isvalidCredentials(String user_id, String password) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where user_id= ? and password =?");
		query.setString(1, user_id);
		query.setString(2, password);

		if (query.uniqueResult() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean save(User user) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
