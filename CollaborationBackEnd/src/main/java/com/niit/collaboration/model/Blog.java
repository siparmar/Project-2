package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="blog")
@Component
public class Blog extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Blog_id;
	private String title;
	private String descritpion;
	
	/*@ManyToOne
	private String userId;
	*/
	private Date dateTime;
	private char status;
	private String reason;
	
	
	
	//getters and setters
	
	public int getBlog_id() {
		return Blog_id;
	}
	public void setBlog_id(int blog_id) {
		Blog_id = blog_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	/*public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}*/
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
