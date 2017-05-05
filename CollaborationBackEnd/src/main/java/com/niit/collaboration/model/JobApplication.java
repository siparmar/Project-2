package com.niit.collaboration.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "job_application")
@Component
public class JobApplication extends BaseDomain {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long jobApplication_id;
/*
	@OneToMany(mappedBy = "job_application", fetch = FetchType.EAGER)
	private List<User> user;

	private Long jobId;
*/
	private Date dateApplied;

	private String remarks;

	private char status; // S-> Select , R->Reject , C->Call for interview

	
	
	// getters and setters

	public Long getJobApplication_id() {
		return jobApplication_id;
	}

	public void setJobApplication_id(Long jobApplication_id) {
		this.jobApplication_id = jobApplication_id;
	}

	/*public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
*/
	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
