package com.cjc.main.homecontroller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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
import com.cjc.main.homeservice.PaymentService;
import com.cjc.main.homeservice.studentService;
import com.cjc.main.model.Batch;
import com.cjc.main.model.Payment;
import com.cjc.main.model.Student;
import com.cjc.main.model.StudentResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/enquiry")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	studentService studentservice;

	@Autowired
	BatchService batchService;

	@Autowired
	PaymentService paymentService;

	@PostMapping("/addStudentEnquiry")
	public StudentResponseDTO addstudent(@RequestBody Student student) {
		Student student1 = new Student();
		logger.info("AddStudent Method" + student);

		if (student != null) {
			Student presentEnquiry = studentservice.fetchStudentByMobileNo(student.getMobileno());
			if (presentEnquiry != null) {
				return new StudentResponseDTO(presentEnquiry, null, "Mobile Number is already present",
						HttpStatus.FOUND);
			}
		}
		if (student != null && student.getStudentbatchid() != null) {
			Batch batch = batchService.findBatchUsingBatchName(student.getStudentbatchid());
			student.setBatch(batch);
			student1 = studentservice.addstudent(student);
			if (student1 != null) {
				return new StudentResponseDTO(student1, "Enquiry Successfully Added", null, HttpStatus.CREATED);
			} else {
				return new StudentResponseDTO(student1, null, "Something went Wrong, Enquiry  in not added",
						HttpStatus.NOT_FOUND);
			}
		} else {
			return new StudentResponseDTO(student1, null, "Something went Wrong, Enquiry  in not added",
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getStudentEnquiry/{studentbatchid}")
	public ResponseEntity<List<Student>> getallstudent(@PathVariable String studentbatchid) {
		logger.info("BatchName" + studentbatchid);
		Batch batch = batchService.findBatchUsingBatchName(studentbatchid);
		logger.info("Batch" + batch);
		List<Student> lst = studentservice.getallstudent(batch);

		return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
	}

	@PutMapping("/updateStudentInformation")
	public StudentResponseDTO upadtestudent(@RequestBody Student student) {

		logger.info("Student Object" + student);

		Student student1 = studentservice.updatedata(student);

		logger.info("updated Student" + student1);
		if (student1 != null) {
			return new StudentResponseDTO(student1, "Student Information updated Successfully", null, HttpStatus.OK);
		} else {
			return new StudentResponseDTO(student1, null, "Not able to modify the data", HttpStatus.OK);
		}
	}

	@PutMapping("/updateStudentdetails")
	public StudentResponseDTO upadtestudent(@RequestBody Student student,
			@RequestParam(value = "payment") String Payment, @RequestParam(value = "accountNo") String accountNo,
			@RequestParam(value = "transactionNo") String transactionNo, @RequestParam(value = "date") String date,
			@RequestParam(value = "beneficiaryName") String beneficiaryName,
			@RequestParam(value = "beneficiaryAc") String beneficiaryAc,
			@RequestParam(value = "paymentMode") String paymentMode)
			throws JsonMappingException, JsonProcessingException {

		logger.info("Payment Object" + Payment + "accno" + accountNo + "" + transactionNo + "" + date + ""
				+ beneficiaryName + "" + beneficiaryAc + "" + paymentMode);
		logger.info("Student Object" + student);
		Payment payObj = new Payment();
		payObj.setAccountNo(accountNo);
		payObj.setBeneficiaryAc(beneficiaryAc);
		payObj.setBeneficiaryName(beneficiaryName);
		payObj.setDate(date);
		payObj.setPayment(Long.parseLong(Payment));
		payObj.setPaymentMode(paymentMode);
		payObj.setTransactionNo(transactionNo);

		Payment paymentNewlyAdded=paymentService.savePayment(payObj);
		Student  oldStudent= studentservice.fetchStudentByMobileNo(student.getMobileno());
		List<Payment> paymentList=oldStudent.getPaymentList();
		paymentList.add(paymentNewlyAdded);

		student.setPaymentList(paymentList);

		Student student1 = studentservice.updatedata(student);

		logger.info("updated Student" + student1);
		if (student1 != null) {
			return new StudentResponseDTO(student1, "Student Information updated Successfully", null, HttpStatus.OK);
		} else {
			return new StudentResponseDTO(student1, null, "Not able to modify the data", HttpStatus.OK);
		}
	}

	@GetMapping("/getPayment/{id}")
	public ResponseEntity<Student> getPaymentdata(@PathVariable(name = "id") String mblno) {
		logger.info("getPayment Mobile No" + mblno);
		Student stu = studentservice.getStuPaymments(mblno);
		logger.info("Student" + stu);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}

	@DeleteMapping("/deletes/{id}")
	public ResponseEntity<String> deletedata(@PathVariable int id) {
		studentservice.deletedstudent(id);

		return new ResponseEntity<String>("Deleted data Successfully", HttpStatus.OK);
	}

	@GetMapping("/getbatch/{id}")
	public ResponseEntity<List<Student>> getstudentbybatchid(@PathVariable int id) {
		System.out.println(id);
		List<Student> lst = studentservice.getbybatchid(id);

		return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<List<Student>> getstudentby(@PathVariable int id) {
		System.out.println(id);
		List<Student> lst = studentservice.getbybatchid(id);

		return new ResponseEntity<List<Student>>(lst, HttpStatus.OK);
	}

	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable int id) {
		
		Integer paymentDeleteId=paymentService.deletePayment(id);
		if(paymentDeleteId>0) {
			return new ResponseEntity<String>("Deleted data Successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Issue while deleting the Payment", HttpStatus.BAD_REQUEST);
		}
	}
//	@PutMapping("/updateStudentdetails")
//	public ResponseEntity<Student> upadtestudent(@RequestBody Student student,
//			@RequestParam(value = "payment") Long Payment, @RequestParam(value = "accountNo") String accountNo,
//			@RequestParam(value = "transactionNo") String transactionNo, @RequestParam(value = "date") String date,
//			@RequestParam(value = "beneficiaryName") String beneficiaryName,
//			@RequestParam(value = "beneficiaryAc") String beneficiaryAc,
//			@RequestParam(value = "paymentMode") String paymentMode)
//			throws JsonMappingException, JsonProcessingException {
//		System.out.println(student);
//		System.out.println(Payment);
//		System.out.println(accountNo);
//		System.out.println(transactionNo);
//		System.out.println(date);
//		System.out.println(beneficiaryName);
//		System.out.println(beneficiaryAc);
//		System.out.println(paymentMode);
//
//		Payment payObj = new Payment();
//		payObj.setAccountNo(accountNo);
//		payObj.setBeneficiaryAc(beneficiaryAc);
//		payObj.setBeneficiaryName(beneficiaryName);
//		payObj.setDate(date);
//		payObj.setPayment(Payment);
//		payObj.setPaymentMode(paymentMode);
//		payObj.setTransactionNo(transactionNo);
//
//		Payment pay = paymentSer.savePayment(payObj);
//		System.out.println(pay);
//		Student_Payment stuPay = new Student_Payment();
//		stuPay.setPayment(pay);
//		stuPay.setStudent(student);
//		List<Student_Payment> paymentList = new ArrayList<Student_Payment>();
//		paymentList.add(stuPay);
//
//		student.getPaymentList().addAll(paymentList);
//		// payObj.setStuPayments(stuPayments);
////		ObjectMapper ob=new ObjectMapper();
////		  Payment pay= ob.readValue(Payment,Payment.class);
////		  System.out.println(pay);
//		Student student1 = studentservice.updatedata(student);
//
//		System.out.println(student1);
//
//		return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
//		// return null;
//	}
}
