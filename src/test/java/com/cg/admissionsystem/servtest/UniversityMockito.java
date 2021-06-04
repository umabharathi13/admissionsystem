package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.repository.IUniversityRepository;
import com.cg.admissionsystem.service.UniversityService;

@ExtendWith(SpringExtension.class)
public class UniversityMockito {
	@InjectMocks
	UniversityService universityService;
	@MockBean
	IUniversityRepository universityRepository;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void createTest() {
		Branch branch1 = new Branch(117, "IT", "Information Technology");
		Branch branch2 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(branch1, branch2).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch branch3 = new Branch(119, "IT", "Information Technology");
		Branch branch4 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch5);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		Mockito.when(universityService.save(university)).thenReturn(university);
		University university1 = universityService.save(university);
		assertEquals(101, university1.getUniversityId());

	}

	@Test
	void viewTest() {
		Branch branch1 = new Branch(117, "IT", "Information Technology");
		Branch branch2 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(branch1, branch2).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch branch3 = new Branch(119, "IT", "Information Technology");
		Branch branch4 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch5);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		University university1 = new University("jntua", 105);
		List<University> university2 = new ArrayList<>();
		university2.add(university);
		university2.add(university1);
		Mockito.when(universityRepository.findAll()).thenReturn(university2);
		List<University> university3 = universityRepository.findAll();
		assertEquals(2, university3.size());
	}

	@Test
	void getByIdTest() {
		Branch branch1 = new Branch(117, "IT", "Information Technology");
		Branch branch2 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(branch1, branch2).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch branch3 = new Branch(119, "IT", "Information Technology");
		Branch branch4 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch5);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		Mockito.when(universityRepository.findById(101)).thenReturn(Optional.of(university));
		University university1 = universityService.getByUniversityId(101);

	}

	@Test
	void deleteTest() {
		Branch branch = new Branch(117, "IT", "Information Technology");
		Branch branch1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch2 = Stream.of(branch, branch1).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch2);
		Branch branch3 = new Branch(119, "IT", "Information Technology");
		Branch branch4 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch5);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		Mockito.when(universityRepository.findById(101)).thenReturn(Optional.of(university));
		universityRepository.deleteById(101);

		University university1 = universityService.deleteUniversityById(101);
	}

	@Test
	void updateTest() {
		Branch branch = new Branch(117, "IT", "Information Technology");
		Branch branch1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch3 = Stream.of(branch, branch1).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch3);
		Branch branch4 = new Branch(119, "IT", "Information Technology");
		Branch branch5 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch6 = Stream.of(branch, branch1).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch6);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		Mockito.when(universityRepository.findById(101)).thenReturn(Optional.of(university));
		Mockito.when(universityRepository.save(university)).thenReturn(university);
		University university1 = universityService.updateUniversity(university);
		assertEquals(101, university1.getUniversityId());
		assertEquals("Anna University", university1.getName());
	}

}
