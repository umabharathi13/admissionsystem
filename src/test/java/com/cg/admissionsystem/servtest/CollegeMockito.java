package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
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
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.repository.ICollegeRepository;
import com.cg.admissionsystem.service.CollegeServiceImpl;

@ExtendWith(SpringExtension.class)
public class CollegeMockito {
	@InjectMocks
	CollegeServiceImpl collegeService;
	@MockBean
	ICollegeRepository collegeRepository;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	// @Disabled
	void testCreateCollege() {
		Address address = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address address2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program program1 = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> program2 = new ArrayList<>();
		program2.add(program1);
		Branch branch1 = new Branch(716, "IT", "Information Technology");
		Branch branch2 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(branch1, branch2).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch branch3 = new Branch(130, "IT", "Information Technology");
		Branch branch4 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch5);
		List<Course> course2 = new ArrayList<>();
		course2.add(course1);
		course2.add(course1);
		Address address3 = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College college = new College(655, "IUYT", address2);
		University university = new University(2036, "Anna University", address, college);
		College college1 = new College(12, "OIUHT", address, program2, course2, university);
		Mockito.when(((ICollegeRepository) collegeRepository).save(college)).thenReturn(college);
		College college2 = collegeService.addCollege(college);
		assertEquals(12, college2.getCollegeRegId());

	}

	@Test
	// @Disabled
	void testViewCollegeDetails() {
		Address a = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> p = new ArrayList<>();
		p.add(pgm);
		Branch b = new Branch(716, "IT", "Information Technology");
		Branch b1 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch b2 = new Branch(130, "IT", "Information Technology");
		Branch b3 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b2, b3).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch1);
		List<Course> c = new ArrayList<>();
		c.add(course);
		c.add(course1);
		Address add = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College col = new College(655, "IUYT", a2);
		University u = new University(2036, "Anna University", a, col);
		College college = new College(3654, "OIUHT", a, p, c, u);
		Address a1 = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a22 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm1 = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> pg = new ArrayList<>();
		p.add(pgm);
		Branch b0 = new Branch(716, "IT", "Information Technology");
		Branch b11 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch2 = Stream.of(b0, b11).collect(Collectors.toList());
		Course course2 = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch2);
		Branch b02 = new Branch(130, "IT", "Information Technology");
		Branch b03 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch11 = Stream.of(b02, b03).collect(Collectors.toList());
		Course course01 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch11);
		List<Course> cour = new ArrayList<>();
		c.add(course01);
		c.add(course2);
		Address addr = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College cole = new College(655, "IUYT", a22);
		University un = new University(2036, "Anna University", a1, cole);
		College college1 = new College(2, "OIUHT", addr, p, cour, un);
		List<College> c3 = Stream.of(college, college1).collect(Collectors.toList());
		Mockito.when(collegeRepository.findAll()).thenReturn(c3);
		List<College> c4 = collegeService.findAll();
		assertEquals(2, c4.size());
	}

	@Test
	// @Disabled
	void testGetById() {
		Address a = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> p = new ArrayList<>();
		p.add(pgm);
		Branch b = new Branch(716, "IT", "Information Technology");
		Branch b1 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch b2 = new Branch(130, "IT", "Information Technology");
		Branch b3 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b2, b3).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch1);
		List<Course> c = new ArrayList<>();
		c.add(course);
		c.add(course1);
		Address add = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College col = new College(655, "IUYT", a2);
		University u = new University(2036, "Anna University", a, col);
		College college = new College(12, "OIUHT", a, p, c, u);
		Mockito.when(collegeRepository.findById(1)).thenReturn(Optional.of(college));
		College c1 = collegeService.getByCollegeId(1);
		assertEquals("OIUHT", c1.getCollegeName());
	}

	@Test
	// @Disabled
	void testDeleteById() {
		Address a = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> p = new ArrayList<>();
		p.add(pgm);
		Branch b = new Branch(716, "IT", "Information Technology");
		Branch b1 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch b2 = new Branch(130, "IT", "Information Technology");
		Branch b3 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b2, b3).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch1);
		List<Course> c = new ArrayList<>();
		c.add(course);
		c.add(course1);
		Address add = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College col = new College(655, "IUYT", a2);
		University u = new University(2036, "Anna University", a, col);
		College college = new College(12, "OIUHT", a, p, c, u);
		Mockito.when(collegeRepository.findById(1)).thenReturn(Optional.of(college));
		collegeRepository.deleteById(99);
		assertEquals(12, college.getCollegeRegId());
	}

	@Test
	// @Disabled
	void testUpdateCollege() {
		Address a = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> p = new ArrayList<>();
		p.add(pgm);
		Branch b = new Branch(716, "IT", "Information Technology");
		Branch b1 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch b2 = new Branch(130, "IT", "Information Technology");
		Branch b3 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b2, b3).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch1);
		List<Course> c = new ArrayList<>();
		c.add(course);
		c.add(course1);
		Address add = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College col = new College(655, "IUYT", a2);
		University u = new University(2036, "Anna University", a, col);
		College college = new College(14, "OIUHT", a, p, c, u);
		Mockito.when(collegeRepository.findById(14)).thenReturn(Optional.of(college));
		Mockito.when(collegeRepository.save(college)).thenReturn(college);
		College cr = collegeService.updateCollegeName(14, college);
		assertEquals(14, cr.getCollegeRegId());
		assertEquals("OIUHT", cr.getCollegeName());
	}

	@Test
//@Disabled
	void testGetByCollegeName() {
		Address a = new Address(40, "Madurai", "indian", "chennai", "opp Koil", "tamilnadu", "635109");
		Address a2 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program pgm = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> p = new ArrayList<>();
		p.add(pgm);
		Branch b = new Branch(716, "IT", "Information Technology");
		Branch b1 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch b2 = new Branch(130, "IT", "Information Technology");
		Branch b3 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b2, b3).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch1);
		List<Course> c = new ArrayList<>();
		c.add(course);
		c.add(course1);
		Address add = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College col = new College(655, "IUYT", a2);
		University u = new University(2036, "Anna University", a, col);
		College college = new College(14, "OIUHT", a, p, c, u);
		Mockito.when(collegeRepository.findBycollegeName("OIUHT")).thenReturn(college);
		College cr = collegeService.findByCollegeName("OIUHT");
		assertEquals(14, cr.getCollegeRegId());
	}
}
