package com.niit.collaboration.daoimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;


@Transactional
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//LIST
	public List<Friend> list() {
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

	//SAVE
	public boolean save(Friend friend) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(friend);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	//UPDATE
	public boolean update(Friend friend) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(friend);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	//DELETE
	public boolean delete(Friend friend) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(friend);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	//GET FRIEND BY ID
	public Friend getFriendById(int friend_id) {
		return (Friend) sessionFactory.getCurrentSession().load(Friend.class, friend_id);
	}
	
	

}
