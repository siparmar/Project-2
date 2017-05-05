package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.collaboration.dao.JobApplicationDAO;
import com.niit.collaboration.model.JobApplication;


@Transactional
@Repository("JobApplicationDAO")
public class JobApplicationDAOImpl implements JobApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<JobApplication> list() {
		return sessionFactory.getCurrentSession().createQuery("from job_application").list();
	}

	public boolean save(JobApplication jobApplication) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(jobApplication);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(JobApplication jobApplication) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(jobApplication);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(JobApplication jobApplication) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(jobApplication);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public JobApplication getJobApplicationById(int jobApplication_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
