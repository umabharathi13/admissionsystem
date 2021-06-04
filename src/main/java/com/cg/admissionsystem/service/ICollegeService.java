package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;

@Service
public interface ICollegeService {

	College addCollege(College college);

	List<College> findAll();

	College getByCollegeId(int collegeId);

	College deleteByCollegeId(int collegeId);

	College findByCollegeName(String collegeName);

	void deleteCollegeByCollegeName(String collegeName);

	College updateCollegeName(int collegeId, College college);

}
