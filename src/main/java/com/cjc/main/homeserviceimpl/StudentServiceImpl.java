package com.cjc.main.homeserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.homerepository.StudentRepository;
import com.cjc.main.homeservice.studentService;
import com.cjc.main.model.Batch;
import com.cjc.main.model.Payment;
import com.cjc.main.model.Student;

@Service
public class StudentServiceImpl implements studentService{
	
	@Autowired
	StudentRepository studentrepository;

	@Override
	public Student addstudent(Student student) {
		
		Student student1=studentrepository.save(student);
		System.out.println(student1);
		return student1;
	}

	@Override
	public List<Student> getallstudent(Batch batch) {
		
		List<Student> lst=studentrepository.findAllByBatchId(batch.getId());
		
		return lst;
	}

	@Override
	public Student updatedata( Student student) {
		
		Student student1=studentrepository.save(student);
		
		return student1;
	}

	@Override
	public void deletedstudent(int id) {
		
		studentrepository.deleteById(id);
	}


	@Override
	public List<Student> getbybatchid(int id) {
		List<Student> lst=studentrepository.findAllByBatchId(id);
		return lst;
	}

	@Override
	public Student fetchStudentByMobileNo(String mobileNo) {	
		return studentrepository.findAllByMobileno(mobileNo);
	}

	@Override
	public Student getStuPaymments(String mblno) {
		// TODO Auto-generated method stub
		return studentrepository.findAllByMobileno(mblno);
	}

	@Override
	public List<Payment> findAllPaymentListForStudent(String mobileNumber) {
		
		return null;
	}

}
