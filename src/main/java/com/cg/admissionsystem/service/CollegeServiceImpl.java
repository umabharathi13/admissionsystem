package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.repository.ICollegeRepository;

@Service
public class CollegeServiceImpl implements ICollegeService {
	
	@Autowired
	ICollegeRepository corep;

	@Override
	public College save(College college) {
		return corep.save(college);
	}

	@Override
	public List<College> findAll() {
		return corep.findAll();
	}

	@Override
	public College getByCoId(int collegeId) {
		Optional<College> co = corep.findById(collegeId);
	    if(!co.isPresent()) {
	    	return null;
	    }
	    return co.get();
	}

	@Override
	public College deleteByCollegeId(int collegeId) {
		Optional<College> co = corep.findById(collegeId);
	    if(!co.isPresent()) {
	    	return null;
	    }
		corep.deleteById(collegeId);
		return co.get();
	}

	@Override
	public College findBycollegeName(String collegeName) {
		College c=corep.findBycollegeName(collegeName);
	     if(c==null) {
	    	 return null;
	     }
	     return corep.findBycollegeName(collegeName);
	}

	@Override
	public void deleteCollegeByCollegeName(String collegeName) {
		College co=corep.findBycollegeName(collegeName);
		int a=co.getCollegeRegId();
		if(a!=0)
		corep.deleteById(a);
	}

	@Override
	public College updateC(int collegeId, College college) {
		Optional<College> c = corep.findById(college.getCollegeRegId());
		if(!c.isPresent()) {
			return null;
		}
		c.get().setCollegeName(college.getCollegeName());
		return corep.save(c.get());
	}
/*
	@Override
	public College findBycouName(String courseName) {
		College c=new College();
		c.getCourse().g
		College c=corep.findBycourseName(courseName);
		if(c==null) {
			return null;
		}
		return corep.findBycourseName(courseName);
	}
	
*/
}
