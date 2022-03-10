package com.cjc.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity

public class Payment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private long payment;
	    private String transactionNo;
	    private String currentdate;
	    private String beneficiaryName;
	    private String beneficiaryAc;
	   private String accountNo;
	   private  String paymentMode;
	   
	   

	   @ManyToOne(fetch = FetchType.EAGER)
	   private Student student;

	   
		public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getPayment() {
			return payment;
		}
		public void setPayment(long payment) {
			this.payment = payment;
		}
		public String getTransactionNo() {
			return transactionNo;
		}
		public void setTransactionNo(String transactionNo) {
			this.transactionNo = transactionNo;
		}
		public String getDate() {
			return currentdate;
		}
		public void setDate(String date) {
			currentdate = date;
		}
		
		public String getBeneficiaryName() {
			return beneficiaryName;
		}
		public void setBeneficiaryName(String beneficiaryName) {
			this.beneficiaryName = beneficiaryName;
		}
		public String getBeneficiaryAc() {
			return beneficiaryAc;
		}
		public void setBeneficiaryAc(String beneficiaryAc) {
			this.beneficiaryAc = beneficiaryAc;
		}
		public String getCurrentdate() {
			return currentdate;
		}
		public void setCurrentdate(String currentdate) {
			this.currentdate = currentdate;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		
	    
	

}
