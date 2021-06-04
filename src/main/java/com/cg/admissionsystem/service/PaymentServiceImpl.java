package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.admissionsystem.module.Payment;
import com.cg.admissionsystem.repository.IPaymentRepository;

/**
 * Payment Service
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository payRepo;

	/**
	 * To store the Payment
	 */
	@Override
	public Payment addPayment(Payment payment) {
		return payRepo.save(payment);
	}

	/**
	 * To List all the Payment called from the controller class and send back to the
	 * Controller
	 */
	@Override
	public List<Payment> viewAllPaymentDetails() {
		return payRepo.findAll();
	}

	/**
	 * Get and retrieve a specific Payment based on the given id else throws
	 * PaymentNotFoundException
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public Payment getPaymentDetailsByPaymentId(int paymentId) {
		Optional<Payment> pay = payRepo.findById(paymentId);
		if (!pay.isPresent()) {
			return null;
		}
		return pay.get();
	}

	/**
	 * Delete Payment by given Id else throws PaymentNotFoundException
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public Payment deletePaymentById(int paymentId) {
		Optional<Payment> pay = payRepo.findById(paymentId);
		if (!pay.isPresent()) {
			return null;
		}
		payRepo.deleteById(paymentId);
		return pay.get();
	}

	/**
	 * To update the Payment based on the given id and object
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public Payment updatePaymentDetails(int paymentId, Payment payment) {
		Optional<Payment> pay = payRepo.findById(payment.getPaymentId());
		if (!pay.isPresent()) {
			return null;
		}
		pay.get().setPaymentAmount(payment.getPaymentAmount());
		pay.get().setEmailIdOfStudent(payment.getEmailIdOfStudent());
		pay.get().setPaymentDate(payment.getPaymentDate());
		pay.get().setPaymentDescription(payment.getPaymentDescription());
		pay.get().setPaymentStatus(payment.getPaymentStatus());
		return payRepo.save(pay.get());
	}

	/**
	 * Get and retrieve a specific Payment based on the given Email-id else throws
	 * PaymentNotFoundException
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public List<Payment> findByEmailIdOfStudent(String emailIdOfStudent) {
		List<Payment> pay = payRepo.findByEmailIdOfStudent(emailIdOfStudent);
		if (pay.isEmpty()) {
			return null;
		}
		return payRepo.findByEmailIdOfStudent(emailIdOfStudent);
	}

	/**
	 * Get and retrieve a specific Payment based on the given paymentStatus else
	 * throws PaymentNotFoundException
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public List<Payment> findByPaymentStatus(String paymentStatus) {
		List<Payment> pay = payRepo.findByPaymentStatus(paymentStatus);
		if (pay.isEmpty()) {
			return null;
		}

		return payRepo.findByPaymentStatus(paymentStatus);
	}

	/**
	 * Get and retrieve a specific Payment based on the given applicationId else
	 * throws PaymentNotFoundException
	 * 
	 * @throws PaymentNotFoundException
	 */
	@Override
	public List<Payment> findByApplicationId(int applicationId) {
		List<Payment> pay = payRepo.findByApplicationId(applicationId);
		if (pay.isEmpty()) {
			return null;
		}

		return payRepo.findByApplicationId(applicationId);
	}

}
