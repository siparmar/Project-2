package com.niit.collaboration.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "job_application")
@Component

public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobApplication_id;
	
	private Date dateApplied;

	private String remarks;

	private char status; // S-> Select , R->Reject , C->Call for interview

	
	//getters and setters
	
	public Long getJobApplication_id() {
		return jobApplication_id;
	}

	public void setJobApplication_id(Long jobApplication_id) {
		this.jobApplication_id = jobApplication_id;
	}

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
