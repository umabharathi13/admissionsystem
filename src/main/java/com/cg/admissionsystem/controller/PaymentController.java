package com.cg.admissionsystem.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * @author Sherein.J
 *
 */
@CrossOrigin
@RestController
public class PaymentController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IPaymentService payService;

	/**
	 * This below function is used to create a new payment and redirects to the
	 * payment service
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/payment")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {
		logger.info("PaymentDetails is added");
		return ResponseEntity.ok(payService.addPayment(payment));
	}

	/**
	 * This below function is used to get all the payment and redirects to the
	 * payment service
	 *
	 */
	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> viewAllDetails() {
		logger.info("PaymentDetails is viewed");
		return ResponseEntity.ok(payService.viewAllPaymentDetails());
	}

	/**
	 * This below function is used to get a specific payment by id and redirects to
	 * the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@GetMapping("/payment/id/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int paymentId) {
		logger.info("PaymentDetails is viewed by PaymentId");
		if (payService.getPaymentDetailsByPaymentId(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		return ResponseEntity.ok(payService.getPaymentDetailsByPaymentId(paymentId));
	}

	/**
	 * This below function is used to delete a specific payment based on the given
	 * Id and redirects to the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Payment> deletePaymentById(@PathVariable("id") int paymentId) {
		logger.info("PaymentDetails is deleted by PaymentId");
		if (payService.deletePaymentById(paymentId) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + paymentId);
		}
		return ResponseEntity.ok(payService.deletePaymentById(paymentId));
	}

	/**
	 * This below function is used to update a specific payment based on the give Id
	 * and redirects to the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatePaymentDetails(@PathVariable("id") int id, @RequestBody Payment payment) {
		logger.info("PaymentDetails is Updated");
		if (payService.updatePaymentDetails(id, payment) == null) {
			throw new PaymentNotFoundException("Payment not found with given id: " + payment);
		}
		return ResponseEntity.ok(payService.updatePaymentDetails(id, payment));
	}

	/**
	 * This below function is used to get a specific payment by Email-id and
	 * redirects to the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@GetMapping("/payment/emailid/{emailid}")
	public ResponseEntity<List<Payment>> findByEmailIdOfStudent(@PathVariable("emailid") String emailIdOfStudent) {
		logger.info("PaymentDetails is viewed by EmailIdOfStudent");
		if (payService.findByEmailIdOfStudent(emailIdOfStudent) == null) {
			throw new ApplicationNotFoundException("Payment not found with given emailid:" + emailIdOfStudent);
		}
		return ResponseEntity.ok(payService.findByEmailIdOfStudent(emailIdOfStudent));
	}

	/**
	 * This below function is used to get a specific payment by paymentStatus and
	 * redirects to the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@GetMapping("/payment/paymentStatus/{paymentStatus}")
	public ResponseEntity<List<Payment>> findByPaymentStatus(@PathVariable("paymentStatus") String paymentStatus) {
		logger.info("PaymentDetails is viewed by PaymentStatus");
		if (payService.findByPaymentStatus(paymentStatus) == null) {
			throw new ApplicationNotFoundException("Payment not found with given paymentStatus:" + paymentStatus);
		}
		return ResponseEntity.ok(payService.findByPaymentStatus(paymentStatus));
	}

	/**
	 * This below function is used to get a specific payment by applicationId and
	 * redirects to the payment service
	 * 
	 * @param
	 * @return
	 * @exception PaymentNotFoundException
	 */
	@GetMapping("/payment/applicationId/{applicationId}")
	public ResponseEntity<List<Payment>> findByApplicationId(@PathVariable("applicationId") int applicationId) {
		logger.info("PaymentDetails is viewed by ApplicationId");
		if (payService.findByApplicationId(applicationId) == null) {
			throw new ApplicationNotFoundException("Payment not found with given applicationId:" + applicationId);
		}
		return ResponseEntity.ok(payService.findByApplicationId(applicationId));
	}

}
