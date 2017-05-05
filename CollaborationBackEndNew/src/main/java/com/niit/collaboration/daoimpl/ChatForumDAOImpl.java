package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;

@Transactional
@Repository("chatforumDAO")
public class ChatForumDAOImpl implements ChatForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	// LIST
	public List<ChatForum> list() {
		return sessionFactory.getCurrentSession().createQuery("from chat_forum").list();
	}

	// SAVE
	public boolean save(ChatForum chatForum) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(chatForum);
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
	public boolean update(ChatForum chatForum) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(chatForum);
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
	public boolean delete(ChatForum chatForum) {
		// TODO Auto-generated method stub
		return false;
	}

	// GET CHAT-FORUM BY ID
	public ChatForum getChatForumById(int chat_forum_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
