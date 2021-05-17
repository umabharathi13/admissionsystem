package com.cg.admissionsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.repository.IAddressRepository;
@Service
public class AddressServiceImpl implements IAddressService {


	@Autowired
	IAddressRepository addser;
	

	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		return addser.save(address);
	}

	@Override
	public Address deleteAddressById(int addressId) {
		Optional<Address> opt= addser.findById(addressId);
		if(!opt.isPresent()) {
			return null;
		}
		addser.deleteById(addressId);
		return opt.get();
	}
	@Override
	public Address getAddressById(int addressId) {
		Optional<Address> opt= addser.findById(addressId);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
	

	@Override
	public Address updateAddress(Address add) {
		Optional<Address> as = addser.findById(1);
		add.setCity(add.getCountry());
		return addser.save(add);
	}

}