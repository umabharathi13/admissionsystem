package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.ApplicationNotFoundException;
import com.cg.admissionsystem.exception.PaymentNotFoundException;
import com.cg.admissionsystem.module.Payment;
import com.cg.admissionsystem.service.IPaymentService;


@RestController
public class PaymentController {
	
	@Autowired
	IPaymentService payService;

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		return payService.addPayment(payment);
	}
	
	@GetMapping("/payment")
	public List<Payment>viewAllDetails(){
		return payService.viewAllPaymentDetails();
		}
	
	@GetMapping("/payment/id/{id}")
	public Payment GetPaymentById(@PathVariable("id") int paymentId) {
		if(payService.getPaymentDetailsByPaymentId(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: "+paymentId);
		}
		return payService.getPaymentDetailsByPaymentId(paymentId);
	}

	@DeleteMapping("/payment/id/{id}")
	public Payment deletePaymentById(@PathVariable("id")int paymentId) {
		if(payService.deletePaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: "+paymentId);
		}
		return payService.deletePaymentById(paymentId);
	}
			
	
	@PutMapping("/payment/{id}") 
	public Payment updatePaymentDetails(@PathVariable("id") int id, @RequestBody Payment payment) {
		if(payService.updatePaymentDetails(id,payment) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: "+payment);
		}
		return payService.updatePaymentDetails(id,payment);
	}
	
	@GetMapping("/payment/emailid/{emailid}")
	public List<Payment> findByEmailIdOfStudent(@PathVariable("emailid")String emailIdOfStudent) {
		if(payService.findByEmailIdOfStudent(emailIdOfStudent)==null) {
			throw new ApplicationNotFoundException("Payment not found with given emailid:" + emailIdOfStudent);
		}
		return payService.findByEmailIdOfStudent(emailIdOfStudent);
	}
	
	@GetMapping("/payment/paymentStatus/{paymentStatus}")
	public List<Payment> findByPaymentStatus(@PathVariable("paymentStatus")String paymentStatus){
		if(payService.findByPaymentStatus(paymentStatus)==null) {
			throw new ApplicationNotFoundException("Payment not found with given paymentStatus:" + paymentStatus);
		}
		
		return payService.findByPaymentStatus(paymentStatus);
	}
	
	@GetMapping("/payment/applicationId/{applicationId}")
	public List<Payment>findByApplicationId(@PathVariable("applicationId")int applicationId){
		if(payService.findByApplicationId(applicationId)==null) {
			throw new ApplicationNotFoundException("Payment not found with given applicationId:" + applicationId);
		}
		
		return payService.findByApplicationId(applicationId);
	}
		
}
