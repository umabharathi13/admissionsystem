package com.cg.admissionsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByEmailIdOfStudent(String emailIdOfStudent);
	
	List<Payment> findByPaymentStatus(String paymentStatus);

	
	@Query(value="select * from payment inner join application on payment.app_id=application.application_id where application.application_id=:a",nativeQuery=true)
	public List<Payment> findByApplicationId(@Param("a")int applicationId);
	
	


}

