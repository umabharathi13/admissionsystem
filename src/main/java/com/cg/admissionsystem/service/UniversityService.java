package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.repository.IUniversityRepository;

@Service
public class UniversityService implements IUniversityService {
	@Autowired
	IUniversityRepository universityRepository;

	@Override
	public University save(University university) {
		return universityRepository.save(university);
	}

	@Override
	public University deleteUniversityById(int universityId) {
		Optional<University> university = universityRepository.findById(universityId);
		if (!university.isPresent()) {
			return null;
		}
		universityRepository.deleteById(universityId);
		return university.get();
	}

	@Override
	public University getByUniversityId(int universityId) {
		Optional<University> university = universityRepository.findById(universityId);
		if (!university.isPresent()) {
			return null;
		}
		return university.get();
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

	@Override
	public University updateUniversity(University university) {
		Optional<University> university1 = universityRepository.findById(university.getUniversityId());
		if (!university1.isPresent()) {
			return null;
		}
		university.setName(university.getName());
		return universityRepository.save(university);
	}

	@Override
	public List<University> findByCollegeName(String collegeName) {
		List<University> university2 = universityRepository.findBycollegeName(collegeName);
		if (university2.isEmpty()) {
			return null;
		}
		return universityRepository.findBycollegeName(collegeName);
	}
}
