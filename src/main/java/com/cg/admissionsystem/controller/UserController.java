package com.cg.admissionsystem.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.module.UserEntity;

import com.cg.admissionsystem.exception.UserNotFoundException;
import com.cg.admissionsystem.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

	/**
	 * Logger
	 */
	Logger logger = LogManager.getLogger(UserController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IUserService regservice;

	/**
	 * This below function is used to get a specific user using userId and redirects
	 * to the user service
	 */
	@GetMapping("/users/{userid}")
	public UserEntity findUserByUserId(@PathVariable String userid) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this userid ");
		}
		logger.info("Getting User by UserId:" + userid);
		return regservice.findUserByUserId(userid);

	}

	/**
	 * This below function is used to get all the user and redirects to the user
	 * service
	 */
	@GetMapping("/users")
	public List<UserEntity> findAllusers() {
		logger.info("Printing all the Users");
		return regservice.getAllUsers();

	}

	/**
	 * This below function is used to create a new user and redirects to the user
	 * service
	 */
	@PostMapping("/users")
	public UserEntity save(@Valid @RequestBody UserEntity user) {
		logger.info("Creating a User");
		return regservice.createUser(user);
	}

	/**
	 * This below function is used to update a specific user based on the give
	 * userId and redirects to the user service
	 */
	@PutMapping("/users/{userid}/update")
	public UserEntity updateUser(@PathVariable String userid, @Valid @RequestBody UserEntity user) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with this Userid");
		}
		logger.info("Updating the User" + userid);
		return regservice.updateUser(user);

	}

	/**
	 * This below function is used to delete a specific user based on the give
	 * userId and redirects to the user service
	 */
	@DeleteMapping("/users/{userid}")
	public UserEntity deleteUserByUserId(@PathVariable String userid) {
		if (regservice.findUserByUserId(userid) == null) {
			throw new UserNotFoundException("User not found with Userid");
		}
		logger.info("Deleting the User by Userid" + userid);
		return regservice.deleteUserByUserId(userid);
	}
}
