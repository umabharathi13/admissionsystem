package com.cg.admissionsystem.service;

import com.cg.admissionsystem.module.LoginEntity;

public interface ILoginService {
	/*
	 * Login User
	 */
	String login(LoginEntity user);

	/*
	 * Logout User
	 */
	String logout(String userId);

}
