package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.exception.UserNotFoundException;
import com.cg.admissionsystem.module.User;
import com.cg.admissionsystem.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository regRepo;

	/**
	 * creating a user in database
	 * 
	 */
	@Override
	public User createUser(User user) {
		Optional<User> optional =regRepo.findById(user.getUserid());
		if(optional.isPresent()) {
			throw new UserNotFoundException("UserId already exists");
		}
		return regRepo.save(user);
	}

	@Override
	public User findUserByUserId(String userid) {
		Optional<User> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<User> getAllUsers() {
		return regRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		User dbUser = getUser(user);
		if (isNullOrEmpty(dbUser.getFirstname())) {
			dbUser.setFirstname(user.getFirstname());
		}
		if (isNullOrEmpty(dbUser.getLastname())) {
			dbUser.setLastname(user.getLastname());
		}
		if (isNullOrEmpty(dbUser.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (isNullOrEmpty(dbUser.getPassword())) {
			dbUser.setPassword(user.getPassword());
		}
		if (isNullOrEmpty(dbUser.getMobileNumber())) {
			dbUser.setMobileNumber(user.getMobileNumber());
		}
		if (isNullOrEmpty(dbUser.getAadharnumber())) {
			dbUser.setAadharnumber(user.getAadharnumber());
		}
		
		return regRepo.save(dbUser);
	}

	private boolean isNullOrEmpty(String value) {
		return value != null && !value.equals("");
	}

	private User getUser(User user) {
		Optional<User> userfield = regRepo.findById(user.getUserid());
		User dbUser = null;
		if (userfield.isPresent()) {
			dbUser = userfield.get();
		}
		return dbUser;
	}

	@Override
	public User deleteUserByUserId(String userid) {
		Optional<User> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}
		regRepo.deleteById(userid);
		return optional.get();
	}
}
