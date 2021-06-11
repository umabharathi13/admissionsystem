package com.cg.admissionsystem.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.admissionsystem.module.User;

@Service
public interface IUserService {
	/**
	 * Retrieves user records with userid
	 * 
	 * @param userid
	 * @return UserEntity
	 */
	public User findUserByUserId(String userid);

	/**
	 * Retrieves user
	 * 
	 * @return
	 */
	public List<User> getAllUsers();

	/**
	 * Creates user record in the entity table
	 * 
	 * @param User
	 * @return UserEntity
	 */
	public User createUser(User user);

	public User updateUser(User user);

	public User deleteUserByUserId(String userid);

}
