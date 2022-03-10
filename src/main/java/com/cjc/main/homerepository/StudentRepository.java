package com.cjc.main.homerepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Batch;
import com.cjc.main.model.Payment;
import com.cjc.main.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	

	List<Student> findAllByBatchId(int batchid);
	List<Student> findAllByBatch(Batch batch);
	
	Student findAllByMobileno(String mobileNo);
	Student findByMobileno(String mblno);
}
