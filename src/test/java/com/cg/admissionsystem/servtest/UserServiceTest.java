package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.admissionsystem.module.UserEntity;
import com.cg.admissionsystem.exception.UserNotFoundException;
import com.cg.admissionsystem.repository.IUserRepository;
import com.cg.admissionsystem.service.IUserService;

@SpringBootTest
public class UserServiceTest {

	/**
	 * Logger
	 */
	Logger logger = LogManager.getLogger(UserServiceTest.class);

	/**
	 * AutoWiring the services class to call down the services
	 */
	@Autowired
	IUserService regservice;
	@Autowired
	IUserRepository regRepo;

	/**
	 * Default method
	 * 
	 * @return user
	 */
	static UserEntity getMockUser() {
		UserEntity user = new UserEntity();
		user.setUserid("userid");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("abc353@gmail.com");
		user.setPassword("M0n1sha04");
		user.setMobileNumber("9840128654");
		return user;
	}

	/**
	 * Test Case for the method to get the User using userid
	 * 
	 */
	@Test
	void findUserByUserId() throws UserNotFoundException {
		UserEntity user = getMockUser();
		regservice.createUser(user);
		UserEntity temp = regservice.findUserByUserId("userid");
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());

	}

	/**
	 * Test case for the method to list all users
	 * 
	 */
	@Test
	void findAllUsers() throws UserNotFoundException {
		List<UserEntity> userlist = regservice.getAllUsers();
		UserEntity user = getMockUser();
		regservice.createUser(user);
		List<UserEntity> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());
	}

	/**
	 * Test case for the method to Update all the values
	 */
	@Test
	void updateUser() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yaho0.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		regservice.createUser(user);
		UserEntity temp = regservice.updateUser(user);
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());
	}

	/**
	 * Test case to delete the user using userid
	 * 
	 */
	@Test
	void deleteUserByUserId() throws UserNotFoundException {
		UserEntity user = new UserEntity();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yahoo.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		regservice.createUser(user);
		UserEntity temp = regservice.deleteUserByUserId("Monisha");
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());
	}

}
