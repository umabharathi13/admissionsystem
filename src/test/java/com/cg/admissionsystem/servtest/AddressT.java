package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.service.AddressServiceImpl;
import com.cg.admissionsystem.service.IAddressService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@SpringBootTest
class AddressT {
	  
	@Autowired
	IAddressService as;
	
	@Test
	@Disabled
	void addAddress()
	{
		Address addr=new Address(3,"salem","indian","salem","opp busstand","tamilnadu","635108" );
		 Address a= as.save(addr);
		 assertEquals("indian",a.getCountry());
		
	}
	@Test
	@Disabled
    void DeleteApplicationByIdTest() {
		Address view=as.deleteAddressById(2);
	    assertEquals(2,view.getAddressId());
    }
	
	@Test
	@Disabled
    void updateAddress() {
		Address app= new Address();
		app.setAddressId(2);
		app.setCountry("USA");
		Address view=as.updateAddress(app);
     assertEquals(2,view.getAddressId());
    }
	
	@Test
	@Disabled
	void getAddressById() {
		Address view=as.getAddressById(3);
	    assertEquals(1,view.getAddressId());
	
	}
    
}


