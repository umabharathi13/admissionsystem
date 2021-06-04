package com.cg.admissionsystem.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.repository.IAddressRepository;

/**
 * Address Service
 *
 */
@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addser;

	/**
	 * To store the address
	 */
	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addser.save(address);
	}

	/**
	 * used to delete the address based on the given ID
	 *
	 */

	@Override
	public Address deleteAddressById(int addressId) {
		Optional<Address> opt = addser.findById(addressId);
		if (!opt.isPresent()) {
			return null;
		}
		addser.deleteById(addressId);
		return opt.get();
	}

	/**
	 * Get and retrieve a specific Address based on the given id else throws
	 * AddressNotFound Exception
	 */
	@Override
	public Address getAddressById(int addressId) {
		Optional<Address> opt = addser.findById(addressId);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	/**
	 * To update the Address based on the given id and object
	 */

	@Override
	public Address updateAddress(Address add) {
		Optional<Address> as = addser.findById(add.getAddressId());
		if (!as.isPresent()) {
			return null;
		}
		as.get().setAddressId(add.getAddressId());
		as.get().setCity(add.getCity());
		as.get().setCountry(add.getCountry());
		as.get().setDistrict(add.getDistrict());
		as.get().setLandmark(add.getLandmark());
		as.get().setState(add.getState());
		as.get().setZipcode(add.getZipcode());
		return addser.save(as.get());
	}

	/**
	 * To List all the address called from the controller class and send back to the
	 * Controller
	 */

	@Override
	public List<Address> retrive() {
		// TODO Auto-generated method stub
		return addser.findAll();
	}

}