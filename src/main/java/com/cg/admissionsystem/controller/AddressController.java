package com.cg.admissionsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.AddressNotFoundException;
import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.service.IAddressService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AddressController {
	/**
	 * Logger
	 */
	
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(AddressController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IAddressService addService;

	/**
	 * This below function is used to create a new address and redirects to the
	 * address service
	 */

	@PostMapping("/address")
	public ResponseEntity<Address>addAddress(@RequestBody Address address) {
		logger.info("adding");
		addService.save(address);
		return ResponseEntity.ok(address);
	}

	/**
	 * This below function is used to get all the address and redirects to the
	 * address service
	 */

	@GetMapping("/address")
	public ResponseEntity <List<Address>> viewAllAddress() {
		logger.info("getting all values");
		List<Address> address=addService.retrive();
		return ResponseEntity.ok().body(address);
	}

	/**
	 * This below function is used to delete a specific address based on the give Id
	 * and redirects to the address service
	 */

	@DeleteMapping("/address/{Id}")
	public Address deleteAddress(@PathVariable("Id") int addressId) {
		if (addService.getAddressById(addressId) == null) {
			throw new AddressNotFoundException("Address not found with given id: " + addressId);
		}
		logger.info("deleting address by id"+addressId);
		return addService.deleteAddressById(addressId);
	}

	/**
	 * This below function is used to get a specific address and id as parameter and
	 * redirects to the address service
	 */
	@GetMapping("/address/{id}")
	public ResponseEntity <Address> getAddressById(@PathVariable("id") int addressId) {
		if (addService.getAddressById(addressId) == null) {
			throw new AddressNotFoundException("Address not found with given id: " + addressId);
		}
		logger.info("getting address by id"+addressId);
		Address address=addService.getAddressById(addressId);
		return ResponseEntity.ok().body(address);
	}

	/**
	 * This below function is used to update a specific address based on the give Id
	 * and redirects to the address service
	 */
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") int addressId, @RequestBody Address address) {
		if (addService.getAddressById(addressId)==null) {
			throw new AddressNotFoundException("Address not found with given name: " + addressId);
		}
		logger.info("updating address by id"+addressId);
		Address a=addService.updateAddress(address);
		return ResponseEntity.ok(address);

	}
}
