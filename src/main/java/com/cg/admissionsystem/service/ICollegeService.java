package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;

@Service
public interface ICollegeService {

	College save(College college);

	List<College> findAll();

	College getByCoId(int collegeId);

	College deleteByCollegeId(int collegeId);

	College findBycollegeName(String collegeName);

	void deleteCollegeByCollegeName(String collegeName);

	College updateC(int collegeId, College college);

	//College findBycouName(String courseName);

}
