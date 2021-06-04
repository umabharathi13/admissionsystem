package com.cg.admissionsystem.module;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AddressEntity class
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	/**
	 * creating instance variables for the class AddressEntity
	 */
	@Id
	private int addressId;
	private String city;
	private String district;
	private String state;
	private String country;
	private String zipcode;
	private String landmark;

}
