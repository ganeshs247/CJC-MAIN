//package com.cjc.main.model;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//@Entity
//public class Student_Payment {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int stuPayId;
//	
//	 @JsonBackReference
//	@ManyToOne( fetch = FetchType.EAGER)
//	private Student student;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Payment payment;
//
//	
//	public int getStuPayId() {
//		return stuPayId;
//	}
//
//	public Student_Payment(int stuPayId, Student student, Payment payment) {
//		super();
//		this.stuPayId = stuPayId;
//		this.student = student;
//		this.payment = payment;
//	}
//  public Student_Payment() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Student_Payment [stuPayId=" + stuPayId + ", student=" + student + ", payment=" + payment + "]";
//	}
//
//	public void setStuPayId(int stuPayId) {
//		this.stuPayId = stuPayId;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public Payment getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}
//	
//	
//}
