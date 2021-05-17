package com.cg.admissionsystem.service;

import java.util.List;

import com.cg.admissionsystem.module.Payment;

public interface IPaymentService {

	Payment addPayment(Payment payment);

	List<Payment> viewAllPaymentDetails();

	Payment getPaymentDetailsByPaymentId(int paymentId);
	
	Payment deletePaymentById(int paymentId);
	
	Payment updatePaymentDetails(int id, Payment payment);
	
	List<Payment> findByEmailIdOfStudent(String emailIdOfStudent);

	List<Payment> findByPaymentStatus(String paymentStatus);

	List<Payment> findByApplicationId(int applicationId);


}
