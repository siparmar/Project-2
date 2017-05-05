package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.JobApplication;

public interface JobApplicationDAO {

	public List<JobApplication> list();
	
	public boolean save(JobApplication jobApplication);
	
	public boolean update(JobApplication jobApplication);
	
	public boolean delete(JobApplication jobApplication);
	
	public JobApplication getJobApplicationById(int jobApplication_id);
	
}
