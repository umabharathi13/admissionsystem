package com.cg.admissionsystem.repository;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 * @author Sherein.J
 * 
 */

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.admissionsystem.module.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

	/**
	 * Implementing the method getting the paymentDetails based on emailId
	 */
	List<Payment> findByEmailIdOfStudent(String emailIdOfStudent);

	/**
	 * Implementing the method getting the paymentDetails based on paymentStatus
	 */
	List<Payment> findByPaymentStatus(String paymentStatus);

	/**
	 * Implementing the method getting the paymentDetails based on applicationId
	 */
	@Query(value = "select * from payment inner join application on payment.app_id=application.application_id where application.application_id=:a", nativeQuery = true)
	public List<Payment> findByApplicationId(@Param("a") int applicationId);

}
