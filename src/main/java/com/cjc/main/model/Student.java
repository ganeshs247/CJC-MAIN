package com.cjc.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {

	private String firstname;
	private String lastname;
	private String qualification;
	private String college;
	
	@Id	
	private String mobileno;
	private String email; 
	private String refname;
	private String refmobno;
	private String studentbatchid;
	
	@ElementCollection(targetClass=String.class)
	private List<String> courses;
	private String coursemode;
	private String batchshift;
	private String enquirydate;
	private String comment;
	private String coursetype;
	
	private String enquiryTakenBy;
	private String enquiryHandledOn;
	
//	@Lob
//	private byte[] photo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
		 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Payment> paymentList=new ArrayList<Payment>();

	
	public List<Payment> getPaymentList()
	{		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRefname() {
		return refname;
	}
	public void setRefname(String refname) {
		this.refname = refname;
	}
	public String getRefmobno() {
		return refmobno;
	}
	public void setRefmobno(String refmobno) {
		this.refmobno = refmobno;
	}
	public String getStudentbatchid() {
		return studentbatchid;
	}
	public void setStudentbatchid(String studentbatchid) {
		this.studentbatchid = studentbatchid;
	}

	public String getCoursemode() {
		return coursemode;
	}
	public void setCoursemode(String coursemode) {
		this.coursemode = coursemode;
	}
	public String getBatchshift() {
		return batchshift;
	}
	public void setBatchshift(String batchshift) {
		this.batchshift = batchshift;
	}
	public String getEnquirydate() {
		return enquirydate;
	}
	public void setEnquirydate(String enquirydate) {
		this.enquirydate = enquirydate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", qualification=" + qualification
				+ ", college=" + college + ", mobileno=" + mobileno + ", email=" + email + ", refname=" + refname
				+ ", refmobno=" + refmobno + ", studentbatchid=" + studentbatchid + ", courses=" + courses
				+ ", coursemode=" + coursemode + ", batchshift=" + batchshift + ", enquirydate=" + enquirydate
				+ ", comment=" + comment + ", coursetype=" + coursetype + ", enquiryTakenBy=" + enquiryTakenBy
				+ ", enquiryHandledOn=" + enquiryHandledOn + ", batch=" + batch + ", paymentList=" + paymentList + "]";
	}
	public String getEnquiryTakenBy() {
		return enquiryTakenBy;
	}
	public void setEnquiryTakenBy(String enquiryTakenBy) {
		this.enquiryTakenBy = enquiryTakenBy;
	}
	public String getEnquiryHandledOn() {
		return enquiryHandledOn;
	}
	public void setEnquiryHandledOn(String enquiryHandledOn) {
		this.enquiryHandledOn = enquiryHandledOn;
	}
	
	
	
//	public byte[] getPhoto() {
//		return photo;
//	}
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}

	
	
	
	
}
