package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.service.IAddressService;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;

@SpringBootTest
class AddressT {
	org.apache.logging.log4j.Logger logger=LogManager.getLogger(AddressT.class);

	@Autowired
	IAddressService as;

	@Test
	// @Disabled
	void addAddress() {
		Address addr = new Address(3, "salem", "salem", "tamilnadu", "indian", "635108", "opp bustand");
		Address a = as.save(addr);
		logger.info(a);
		logger.info("added succesfully");
		assertEquals("indian", a.getCountry());

	}

	@Test
	@Disabled
	void viewAddressTest() {
		List<Address> view = as.retrive();
		logger.info(view);
		logger.info("getting all details");
		assertEquals(3, view.size());

	}

	@Test
	@Disabled
	void deleteApplicationByIdTest() {
		Address view = as.deleteAddressById(2);
		logger.info(view);
		logger.info("deleted succesfully");
		assertEquals(2, view.getAddressId());
	}

	@Test
	@Disabled
	void updateAddress() {
		Address app = new Address();
		app.setAddressId(13);
		app.setCity("madurai");
		app.setCountry("india");
		app.setDistrict("madurai");
		app.setLandmark("temple street");
		app.setState("TN");
		app.setZipcode("625001");
		Address view = as.updateAddress(app);
		logger.info(view);
		logger.info("updating values");
		assertEquals(2, view.getAddressId());
	}

	@Test
	@Disabled
	void getAddressById() {
		Address view = as.getAddressById(3);
		logger.info(view);
		logger.info("getting address by id");
		assertEquals(1, view.getAddressId());

	}

}
