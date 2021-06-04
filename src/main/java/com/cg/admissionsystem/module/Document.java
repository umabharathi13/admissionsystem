package com.cg.admissionsystem.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DocumentEntity class
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {

	/**
	 * creating instance variables for the class DocumentEntity
	 */
	@Id
	private int documentid;
	private String documentName;
	private String documentUrl;
	private int applicantid;
	@NotEmpty
	@Email(message = "please enter emailid")
	private String emailid;
	private String documentStatus;
}