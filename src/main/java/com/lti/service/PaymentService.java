package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.PaymentRepository;
import com.lti.model.BookingDetails;
import com.lti.model.Payment;
import com.lti.model.Registeration;

@Service
public class PaymentService {

	
	@Autowired
	private PaymentRepository paymentDao;
	
public void addPaymentDetails(Payment payment) {
		
	paymentDao.addPayment(payment);
	}
}
