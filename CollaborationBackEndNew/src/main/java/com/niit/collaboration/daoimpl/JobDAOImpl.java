package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.User;

@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//LIST
	public List<Job> list() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}
	
	//SAVE
	public boolean save(Job job) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(job);
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
	public boolean update(Job job) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(job);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//DELETE
	public boolean delete(Job job) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(job);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch(HibernateException e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	//GET JOB BY ID
	public Job getJobById(int job_id) {
		return (Job) sessionFactory.getCurrentSession().load(Job.class, job_id);
	}
	

}
