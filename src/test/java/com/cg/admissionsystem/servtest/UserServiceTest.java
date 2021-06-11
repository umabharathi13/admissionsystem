package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.admissionsystem.module.User;
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
	static User getMockUser() {
		User user = new User();
		user.setUserid("userid");
		user.setFirstname("firstname");
		user.setLastname("Lastname");
		user.setEmail("abc353@gmail.com");
		user.setPassword("M0n1sha04");
		user.setMobileNumber("9840128654");
		user.setAadharnumber("123456789876");
		return user;
	}

	/**
	 * Test Case for the method to get the User using userid
	 * 
	 */
	@Test
	void findUserByUserId() throws UserNotFoundException {
		User user = getMockUser();
		regservice.createUser(user);
		User temp = regservice.findUserByUserId("userid");
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());

	}

	/**
	 * Test case for the method to list all users
	 * 
	 */
	@Test
	void findAllUsers() throws UserNotFoundException {
		List<User> userlist = regservice.getAllUsers();
		User user = getMockUser();
		regservice.createUser(user);
		List<User> userlist1 = regservice.getAllUsers();
		assertEquals(userlist1.size(), userlist.size());
	}

	/**
	 * Test case for the method to Update all the values
	 */
	@Test
	void updateUser() throws UserNotFoundException {
		User user = new User();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yaho0.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		user.setAadharnumber("123456789876");
		regservice.createUser(user);
		User temp = regservice.updateUser(user);
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());
	}

	/**
	 * Test case to delete the user using userid
	 * 
	 */
	@Test
	void deleteUserByUserId() throws UserNotFoundException {
		User user = new User();
		user.setUserid("Monisha");
		user.setFirstname("Monisha");
		user.setLastname("sekar");
		user.setEmail("monishasekar25@yahoo.com");
		user.setPassword("M0n1sha07");
		user.setMobileNumber("9962440531");
		user.setAadharnumber("123456789876");
		regservice.createUser(user);
		User temp = regservice.deleteUserByUserId("Monisha");
		logger.info("UserEntity");
		assertEquals(user.toString(), temp.toString());
	}

}
