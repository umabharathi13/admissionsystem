package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Address;

@Service
public interface IAddressService {
	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Address save(Address address);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Address deleteAddressById(int addressId);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Address getAddressById(int addressId);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Address updateAddress(Address add);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	public List<Address> retrive();

}
