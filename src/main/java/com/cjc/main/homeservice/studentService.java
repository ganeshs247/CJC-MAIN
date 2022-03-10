package com.cjc.main.homeservice;

import java.util.List;

import com.cjc.main.model.Batch;
import com.cjc.main.model.Payment;
import com.cjc.main.model.Student;

public interface studentService {

	Student addstudent(Student student);

	List<Student> getallstudent(Batch batchId);

	Student updatedata( Student student);

	void deletedstudent(int id);

	List<Student> getbybatchid(int id);

	Student fetchStudentByMobileNo(String mobileNo);

	Student getStuPaymments(String mblno);
	
	public List<Payment> findAllPaymentListForStudent(String mobileNumber);

}
