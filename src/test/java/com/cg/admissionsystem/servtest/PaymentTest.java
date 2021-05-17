package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
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
	
	@Test
	@Disabled
	void testaddPayment() {
		LocalDate app1=LocalDate.of(1999,11,26);
		LocalDate app2=LocalDate.of(2021,10,25);		
		LocalDate app3=LocalDate.of(2021,05,30);
		
		Application app=new Application(6,"Eve",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad");
		Payment paym=new Payment(105,"eve@gmail.com", 2500.00,"Paid",app3, "Received");
		paym.setApplication(app);
		app.setPayment(paym);
	
		Payment p = payser.addPayment(paym);
		System.out.println(p);
	    assertEquals(105, p.getPaymentId());
 }
	
	@Test
	@Disabled
	void testviewAllPaymentDetails() {
		List<Payment>view=payser.viewAllPaymentDetails();
		for(Payment a : view) {
			System.out.println(a);
			}

 }
	
	@Test
	@Disabled
	void testgetPaymentDetailsByPaymentId() {
		Payment view = payser.getPaymentDetailsByPaymentId(100);
		System.out.println(view);
		assertEquals(100, view.getPaymentId());

	}
	
	@Test
	@Disabled
	void testgetPaymentDetailsByEmail() {
		List<Payment> view = payser.findByEmailIdOfStudent("matthew@gmail.com");
		for (Payment p : view) {
			System.out.println(p);
		}
	}
	
	@Test
	@Disabled
	void testgetPaymentDetailsByStatus() {
		List<Payment> view = payser.findByPaymentStatus("Received");
		System.out.println(view);
		assertEquals(2, view.size());

	}
	
	@Test
	@Disabled
	void testupdatePaymentDetails() {
		Payment pay = new Payment();
		pay.setPaymentId(112);
		pay.setPaymentAmount(3000.00);
		pay.setEmailIdOfStudent("mark@gmail.com");
		pay.setPaymentDescription("NotPaid");
		pay.setPaymentStatus("NotReceived");

		LocalDate pay1 = LocalDate.of(2020, 05, 10);
		pay.setPaymentDate(pay1);
       
		Payment view = payser.updatePaymentDetails(110, pay);
		System.out.println(pay);
		System.out.println("PAYMENTDETAILS UPDATED");
		assertEquals(110, view.getPaymentId());
	}
	
	@Test
	@Disabled
	void testdeletePaymentById() {
		Payment view = payser.deletePaymentById(105);
		System.out.println("REMOVED BY ID");
		assertEquals(105, view.getPaymentId());
	}
	
	
	@Test
	@Disabled
	void getPaymentDetailsByApplicationIdtest() {
		List<Payment> view=payser.findByApplicationId(1);
 	    System.out.println(view);
 	    assertEquals(1,view.size());	
 	}

}