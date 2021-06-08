package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.admissionsystem.module.LoginEntity;
import com.cg.admissionsystem.exception.UserNotFoundException;
import com.cg.admissionsystem.repository.ILoginRepository;
import com.cg.admissionsystem.service.ILoginService;

@SpringBootTest
class LoginServiceTest {

	/**
	 * Logger
	 */
	Logger logger = LogManager.getLogger(LoginServiceTest.class);

	/**
	 * AutoWiring the services class to call down the services
	 */
	@Autowired
	ILoginService loginService;
	@Autowired
	ILoginRepository loginRepo;

	/**
	 * validate login with valid userId and password
	 * 
	 * @throws UserNotFoundException
	 */

	@Test
	void testValidateLoginWithValidUserIdAndPassword() throws UserNotFoundException {
		LoginEntity user = new LoginEntity();
		user.setUserid("admin");
		user.setPassword("admin@1234");
		loginService.login(user);
		LoginEntity dbUsr = loginRepo.findById(user.getUserid()).get();
		logger.info("LoginEntity");
		assertEquals(user.getUserid(), dbUsr.getUserid());
		assertEquals(user.getPassword(), dbUsr.getPassword());
	}

}
