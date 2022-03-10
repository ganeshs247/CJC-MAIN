package com.cjc.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String batchname;
    private String session;
    private String batchdate;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getBatchdate() {
		return batchdate;
	}
	public void setBatchdate(String batchdate) {
		this.batchdate = batchdate;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchname=" + batchname + ", session=" + session + ", batchdate=" + batchdate
				+ "]";
	}
	
	

}
