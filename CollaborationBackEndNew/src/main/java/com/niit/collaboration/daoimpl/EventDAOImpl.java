package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

@Transactional
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// LIST
	public List<Event> list() {
		return sessionFactory.getCurrentSession().createQuery("from event").list();
	}

	// SAVE
	public boolean save(Event event) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(event);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	// UPDATE
	public boolean update(Event event) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(event);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	// DELETE
	public boolean delete(Event event) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(event);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public Event getEventById(int event_id) {
		return (Event) sessionFactory.getCurrentSession().load(Event.class, event_id);
	}

}
