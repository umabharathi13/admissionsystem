package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.repository.ICollegeRepository;

@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	ICollegeRepository collegerepository;

	@Override
	public College addCollege(College college) {
		return collegerepository.save(college);
	}

	@Override
	public List<College> findAll() {
		return collegerepository.findAll();
	}

	@Override
	public College getByCollegeId(int collegeId) {
		Optional<College> college = collegerepository.findById(collegeId);
		if (!college.isPresent()) {
			return null;
		}
		return college.get();
	}

	@Override
	public College deleteByCollegeId(int collegeId) {
		Optional<College> college = collegerepository.findById(collegeId);
		if (!college.isPresent()) {
			return null;
		}
		collegerepository.deleteById(collegeId);
		return college.get();
	}

	@Override
	public College findByCollegeName(String collegeName) {
		College college1 = collegerepository.findBycollegeName(collegeName);
		if (college1 == null) {
			return null;
		}
		return collegerepository.findBycollegeName(collegeName);
	}

	@Override
	public void deleteCollegeByCollegeName(String collegeName) {
		College college = collegerepository.findBycollegeName(collegeName);
		int a = college.getCollegeRegId();
		if (a != 0)
			collegerepository.deleteById(a);
	}

	@Override
	public College updateCollegeName(int collegeId, College college) {
		Optional<College> college1 = collegerepository.findById(college.getCollegeRegId());
		if (!college1.isPresent()) {
			return null;
		}
		college1.get().setCollegeName(college.getCollegeName());
		return collegerepository.save(college1.get());
	}

}
