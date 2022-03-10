package com.cjc.main.homeservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cjc.main.model.Payment;

public interface PaymentService {
    
	public Payment savePayment(Payment payment);
	public Integer deletePayment(int paymentId);
}
