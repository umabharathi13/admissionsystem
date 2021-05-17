package com.cg.admissionsystem.module;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;

@Entity

public class Payment 
{
	@Id
	private int paymentId;
	private String emailIdOfStudent;
	private double paymentAmount;
	private String paymentDescription;
	private LocalDate paymentDate;
	private String paymentStatus;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="app_id")
	private Application application;

	public Payment() {}

	public Payment(int paymentId, String emailIdOfStudent, double paymentAmount, String paymentDescription,
			LocalDate paymentDate, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.emailIdOfStudent = emailIdOfStudent;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getEmailIdOfStudent() {
		return emailIdOfStudent;
	}

	public void setEmailIdOfStudent(String emailIdOfStudent) {
		this.emailIdOfStudent = emailIdOfStudent;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
    
	@JsonManagedReference
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", emailIdOfStudent=" + emailIdOfStudent + ", paymentAmount="
				+ paymentAmount + ", paymentDescription=" + paymentDescription + ", paymentDate=" + paymentDate
				+ ", paymentStatus=" + paymentStatus +"]";
	}

	
	
	
}
