package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.University;

@Service
public interface IUniversityService {
	University save(University University);

	University deleteUniversityById(int universityId);

	University getByUniversityId(int universityId);

	List<University> findAll();

	University updateUniversity(University university);

	List<University> findByCollegeName(String collegeName);

}
