package com.niit.collaboration.daoimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Transactional
@Repository("userDAO")
@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//LIST
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	//IS VALID CREDENTIALS
	public boolean validate(int user_id, String password) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where user_id= ? and password =?");
		query.setInteger(1, user_id);
		query.setString(2, password);

		if (query.uniqueResult() == null) {
			return false;
		} else {
			return true;
		}
	}

	//SAVE
	public User save(User user) {
		
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return user;

	}

	//UPDATE
	public boolean update(User user) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	//DELETE
	public boolean delete(User user) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	//GET USER BY ID
	public User getUserById(int user_id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, user_id);
	}

}
