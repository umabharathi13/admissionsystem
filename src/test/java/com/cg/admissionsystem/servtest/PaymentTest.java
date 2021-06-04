package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.module.Payment;
import com.cg.admissionsystem.service.IPaymentService;

@SpringBootTest
class PaymentTest {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(PaymentTest.class);

	@Autowired
	IPaymentService payser;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * TestCase for the method adding the payment to the database
	 */
	@Test
//	@Disabled
	void testAddPayment() {
		LocalDate app1 = LocalDate.of(1999, 04, 25);
		LocalDate app2 = LocalDate.of(2021, 10, 29);
		LocalDate app3 = LocalDate.of(2021, 05, 18);
		Application app = new Application(8, "Caroline", app1, "B.E", 66, "Engineer", "caroline@gmail.com", "Rejected",
				app2, "Bad");
		Payment paym = new Payment(117, "caroline@gmail.com", 2000.00, "Paid", app3, "Received");
		paym.setApplication(app);
		app.setPayment(paym);
		Payment p = payser.addPayment(paym);
		System.out.println(p);
		logger.info(p);
		logger.info("PaymentDetails Added successfully");
		assertEquals(117, p.getPaymentId());

	}

	/**
	 * TestCase for the method getting all the paymentDetails in the form of list
	 */
	@Test
	@Disabled
	void testViewAllPaymentDetails() {
		List<Payment> view = payser.viewAllPaymentDetails();
		for (Payment a : view) {
			logger.info(a);
		}

	}

	/**
	 * TestCase for the method getting the paymentDetails by using PaymentId
	 */
	@Test
	@Disabled
	void testGetPaymentDetailsByPaymentId() {
		Payment view = payser.getPaymentDetailsByPaymentId(105);
		logger.info(view);
		logger.info("PaymentDetails viewed successfully by PaymentId");
		assertEquals(105, view.getPaymentId());

	}

	/**
	 * TestCase for the method getting the paymentDetails by using EmailIdOfStudent
	 */
	@Test
	@Disabled
	void testGetPaymentDetailsByEmail() {
		List<Payment> view = payser.findByEmailIdOfStudent("eve@gmail.com");
		for (Payment p : view) {
			logger.info(p);
			logger.info("PaymentDetails viewed successfully by EmailIdOfStudent");
		}
	}

	/**
	 * TestCase for the method getting the paymentDetails by using paymentStatus
	 */
	@Test
	@Disabled
	void testGetPaymentDetailsByStatus() {
		List<Payment> view = payser.findByPaymentStatus("Received");
		logger.info(view);
		logger.info("PaymentDetails viewed successfully by PaymentStatus");
		assertEquals(2, view.size());

	}

	/**
	 * TestCase for the method updating paymentDetails
	 */
	@Test
	@Disabled
	void testUpdatePaymentDetails() {
		Payment pay = new Payment();
		pay.setPaymentId(106);
		pay.setPaymentAmount(3000.00);
		pay.setEmailIdOfStudent("luke@gmail.com");
		pay.setPaymentDescription("Paid");
		pay.setPaymentStatus("Received");
		LocalDate pay1 = LocalDate.of(2020, 05, 10);
		pay.setPaymentDate(pay1);
		Payment view = payser.updatePaymentDetails(106, pay);
		logger.info(view);
		logger.info("PaymentDetails is Updated Successfully");
		assertEquals(106, view.getPaymentId());
	}

	/**
	 * TestCase for the method deleting the paymentDetails by using paymentId
	 */
	@Test
	@Disabled
	void testDeletePaymentById() {
		Payment view = payser.deletePaymentById(106);
		logger.info("PaymentDetails is Deleted Successfully");
		assertEquals(106, view.getPaymentId());
	}

	/**
	 * TestCase for the method getting the paymentDetails by using applicationId
	 */
	@Test
	@Disabled
	void testGetPaymentDetailsByApplicationId() {
		List<Payment> view = payser.findByApplicationId(6);
		logger.info(view);
		logger.info("PaymentDetails is viewed By ApplicationId");
		assertEquals(1, view.size());
	}

}