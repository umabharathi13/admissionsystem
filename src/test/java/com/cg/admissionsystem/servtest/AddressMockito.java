package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.repository.IAddressRepository;
import com.cg.admissionsystem.service.AddressServiceImpl;



	@ExtendWith(SpringExtension.class)
	class AddressMockito {
		@InjectMocks
		AddressServiceImpl as;
		
		@MockBean
		IAddressRepository are;
		
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
		@Test
		@Disabled
	    void testAdd(){
			Address a=new Address(4,"chennai","chennai","tamilnadu","indian","603004","opp busstand");
			Mockito.when(are.save(a)).thenReturn(a);
			Address address=as.save(a);
			assertEquals(4,address.getAddressId());
		}
		

		@Test
		@Disabled
		void DeleteApplicationByIdTest() {
			Address a=new Address(4,"chennai","chennai","tamilnadu","indian","603004","opp busstand");
			Mockito.when(are.findById(4)).thenReturn(Optional.of(a));
			are.deleteById(4);
			assertEquals(4,a.getAddressId());
		}
		
		@Test
		@Disabled
		void updateAddress() {
			Address a=new Address(4,"chennai","chennai","tamilnadu","usa","603004","opp busstand");
			Mockito.when(are.findById(4)).thenReturn(Optional.of(a));
			Mockito.when(are.save(a)).thenReturn(a);
			Address address=as.updateAddress(a);
			assertEquals("usa",address.getCountry());
		}
		
		@Test
		@Disabled
		void getAddressById() {
			Address a=new Address(4,"chennai","chennai","tamilnadu","indian","603004","opp busstand");
			Mockito.when(are.findById(104)).thenReturn(Optional.of(a));
			assertEquals(4,a.getAddressId());
		}
		
		
	}


