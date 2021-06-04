package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.module.Payment;
import com.cg.admissionsystem.repository.IPaymentRepository;
import com.cg.admissionsystem.service.PaymentServiceImpl;

@ExtendWith(SpringExtension.class)
class PaymentMockitoTest {

	@InjectMocks
	PaymentServiceImpl payService;

	@MockBean
	IPaymentRepository payRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * MockitoTestCase for the method adding the payment to the database
	 */
	@Test
//	@Disabled
	void testAddPayment() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Mockito.when(payRepo.save(paym)).thenReturn(paym);
		Payment pay = payService.addPayment(paym);
		assertEquals(106, pay.getPaymentId());

	}

	/**
	 * MockitoTestCase for the method getting all the paymentDetails in the form of
	 * list
	 */
	@Test
//	@Disabled
	void testViewAllPaymentDetails() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Payment paym1 = new Payment(107, "mark@gmail.com", 3000.00, "NotPaid", app, "NotReceived");

		List<Payment> payList = new ArrayList<>();
		payList.add(paym);
		payList.add(paym1);

		Mockito.when(payRepo.findAll()).thenReturn(payList);

		List<Payment> pay = payService.viewAllPaymentDetails();

		assertEquals(2, pay.size());

	}

	/**
	 * MockitoTestCase for the method getting the paymentDetails by using PaymentId
	 */
	@Test
//	@Disabled
	void testGetPaymentById() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(110, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Mockito.when(payRepo.findById(110)).thenReturn(Optional.of(paym));

		Payment pay = payService.getPaymentDetailsByPaymentId(110);

		assertEquals(110, pay.getPaymentId());

	}

	/**
	 * MockitoTestCase for the method getting the paymentDetails by using
	 * EmailIdOfStudent
	 */
	@Test
//	@Disabled
	void testGetPaymentDetailsByEmail() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		List<Payment> pay1 = new ArrayList<>();
		pay1.add(paym);
		Mockito.when(payRepo.findByEmailIdOfStudent("matthew@gmail.com")).thenReturn((pay1));

		List<Payment> pay = payService.findByEmailIdOfStudent("matthew@gmail.com");
		assertEquals(1, pay.size());

	}

	/**
	 * MockitoTestCase for the method getting the paymentDetails by using
	 * paymentStatus
	 */
	@Test
//	@Disabled
	void testFindByPaymentStatus() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		List<Payment> paymentList = new ArrayList<>();
		paymentList.add(paym);
		Mockito.when(payRepo.findByPaymentStatus("Received")).thenReturn(paymentList);
		List<Payment> pay = payService.findByPaymentStatus("Received");
		assertEquals(1, pay.size());

	}

	/**
	 * MockitoTestCase for the method updating paymentDetails
	 */
	@Test
//	@Disabled
	void testUpdatePaymentDetails() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Mockito.when(payRepo.findById(106)).thenReturn(Optional.of(paym));
		Mockito.when(payRepo.save(paym)).thenReturn(paym);
		Payment view = payService.updatePaymentDetails(106, paym);
		assertEquals(106, view.getPaymentId());

	}

	/**
	 * MockitoTestCase for the method deleting the paymentDetails by using paymentId
	 */
	@Test
//	@Disabled
	void testDeletePaymentById() {
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Mockito.when(payRepo.findById(106)).thenReturn(Optional.of(paym));
		payRepo.deleteById(106);
		Payment view = payService.deletePaymentById(106);
		assertEquals(106, view.getPaymentId());

	}

	/**
	 * MockitoTestCase for the method getting the paymentDetails by using
	 * applicationId
	 */
	@Test
//	@Disabled
	void testGetPaymentDetailsByApplicationId() {
		LocalDate app1 = LocalDate.of(1999, 10, 25);
		LocalDate app2 = LocalDate.of(2020, 10, 26);
		LocalDate app = LocalDate.of(2021, 05, 10);
		Payment paym = new Payment(106, "matthew@gmail.com", 4000.00, "Paid", app, "Received");
		Application application = new Application(31, "Decker", app1, "B.E", 86, "Engineer", "decker@gmail.com",
				"Accepted", app2, "Good");
		paym.setApplication(application);
		List<Payment> pay1 = new ArrayList<>();
		pay1.add(paym);
		Mockito.when(payRepo.findByApplicationId(31)).thenReturn((pay1));
		List<Payment> view = payService.findByApplicationId(31);
		assertEquals(1, view.size());
	}

}
