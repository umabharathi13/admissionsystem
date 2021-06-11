package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;

@Service
public interface ICollegeService {

	College save(College college);

	List<College> findAll();

	College getCollegeByCollegeRegId(int collegeRegId);

	College deleteCollegeByCollegeRegId(int collegeRegId);

	College findByCollegeName(String collegeName);

	void deleteCollegeByCollegeName(String collegeName);

	College updateCollegeName(int collegeRegId, College college);

}
