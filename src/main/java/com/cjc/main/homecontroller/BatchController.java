package com.cjc.main.homecontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.homeservice.BatchService;
import com.cjc.main.homeservice.studentService;
import com.cjc.main.model.Batch;
import com.cjc.main.model.BatchResponseDto;
import com.cjc.main.model.Student;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/batch")
public class BatchController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	studentService studentservice;
	
	@Autowired
	BatchService batchservice;

	@PostMapping("/addBatch")
	public BatchResponseDto savedata(@RequestBody Batch batch) {
		logger.info("in add batch method");
		Batch newBatch = batchservice.findBatchUsingBatchName(batch.getBatchname());
		logger.info("Batch" + newBatch);
		if(newBatch==null) {
			batch = batchservice.createBatch(batch);
			return new BatchResponseDto(batch, "Batch Created Successfully", null, HttpStatus.CREATED);
		}else {
			return new BatchResponseDto(null, null, "Batch is already Present", HttpStatus.FORBIDDEN);
		}				
	}

	@GetMapping("/getBatch")
	public ResponseEntity<List<Batch>> getbatch() {
		List<Batch> lstbatch = batchservice.getbatchdata();

		return new ResponseEntity<List<Batch>>(lstbatch, HttpStatus.OK);
	}

	@PutMapping("/upadateBatch/{id}")
	public ResponseEntity<Batch> updatedata(@PathVariable int id, @RequestBody Batch batch) {
		batch = batchservice.upadatebatch(id, batch);

		return new ResponseEntity<Batch>(batch, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteBatch/{batchname}")
	public BatchResponseDto updatedata(@PathVariable String batchname) {
		
		logger.info("BatchName" + batchname);
		Batch batch = batchservice.findBatchUsingBatchName(batchname);
		logger.info("Batch" + batch);
		List<Student> studentList = studentservice.getallstudent(batch);
		if(studentList.isEmpty() || studentList==null) {
			boolean deleteFlag=batchservice.deletebatch(batch.getId());
			if(deleteFlag) {
				return new BatchResponseDto(batch, "Batch Deleted SuccessFully", null, HttpStatus.OK);
			}else {
				return new BatchResponseDto(null, null, "Issue With Batch Deletion", HttpStatus.NOT_MODIFIED);
			}
			
		}else {
			return new BatchResponseDto(null, null, "Students are present in batch, cant delete Batch", HttpStatus.NOT_MODIFIED);
		}
	}

}
