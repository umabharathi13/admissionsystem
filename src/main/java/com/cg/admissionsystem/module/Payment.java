package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * Payment Entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	/**
	 * Creating instance variables for the class ApplicationEntity
	 */
	@Id
	private int paymentId;

	@NotEmpty
	@Email(message = "EmailIdOfStudent is not valid")
	private String emailIdOfStudent;

	@Min(value = 1500, message = "must be equal or greater than 1500")
	private double paymentAmount;

	private String paymentDescription;

	private LocalDate paymentDate;

	private String paymentStatus;

	/**
	 * OneToOne mapping with application
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "app_id")
	private Application application;

	/**
	 * Creating Parameterized Constructor
	 */
	public Payment(int paymentId, @NotEmpty @Email(message = "EmailIdOfStudent is not valid") String emailIdOfStudent,
			double paymentAmount, String paymentDescription, LocalDate paymentDate, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.emailIdOfStudent = emailIdOfStudent;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	/**
	 * JsonBackReferences are used to display objects with parent child
	 * relationship.
	 * 
	 * @return
	 */
	@JsonBackReference
	public Application getApplication() {
		return application;
	}

}
