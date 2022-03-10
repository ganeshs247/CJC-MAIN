package com.cjc.main.homeserviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.homerepository.PaymentRepo;
import com.cjc.main.homeservice.PaymentService;
import com.cjc.main.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	PaymentRepo paymentRepo;
	@Override
	public Payment savePayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepo.save(payment);
	}
	@Override
	public Integer deletePayment(int paymentId) {
		// TODO Auto-generated method stub
		try {
			paymentRepo.deleteById(paymentId);
			return 1;
		}catch(Exception e) {
			logger.info("Exception while deleting payment"+e.getMessage());
			return 0;
		}
	}
}
