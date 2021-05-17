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
		UniversityService urser;
		@MockBean
		IUniversityRepository urrep;
		
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		void createTest() {
			Branch b=new Branch(117,"IT","Information Technology");
			Branch b1=new Branch(118,"HRM","Human Resource Management");
			List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
			Course course=new Course(10,"MBA","Master Of Business and Administration","PG",branch);
			Branch b2=new Branch(119,"IT","Information Technology");
			Branch b3=new Branch(120,"HRM","Human Resource Management");
			List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
			Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
			List<Course> c1=Stream.of(course,course1).collect(Collectors.toList());
			Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
			College c=new College(99,"GCET",c1);
		    University u= new University(101,"Anna University",a,c);
			Mockito.when(urrep.save(u)).thenReturn(u);
			University u1=urser.save(u);
			assertEquals(101,u1.getUniversityId());
			
		}
		@Test
		void viewTest() {
			Branch b=new Branch(117,"IT","Information Technology");
			Branch b1=new Branch(118,"HRM","Human Resource Management");
			List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
			Course course=new Course(10,"MBA","Master Of Business and Administration","PG",branch);
			Branch b2=new Branch(119,"IT","Information Technology");
			Branch b3=new Branch(120,"HRM","Human Resource Management");
			List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
			Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
			List<Course> c1=Stream.of(course,course1).collect(Collectors.toList());
			Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
			College c=new College(99,"GCET",c1);
		    University u= new University(101,"Anna University",a,c);
			University u1 = new University("jntua",105);
			List<University> urlist = new ArrayList<>();
			urlist.add(u);
			urlist.add(u1);
			Mockito.when(urrep.findAll()).thenReturn(urlist);
			List<University> university = urser.findAll();
			assertEquals(2, university.size());
		}
		@Test
		void getByIdTest() {
			Branch b=new Branch(117,"IT","Information Technology");
			Branch b1=new Branch(118,"HRM","Human Resource Management");
			List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
			Course course=new Course(10,"MBA","Master Of Business and Administration","PG",branch);
			Branch b2=new Branch(119,"IT","Information Technology");
			Branch b3=new Branch(120,"HRM","Human Resource Management");
			List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
			Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
			List<Course> c1=Stream.of(course,course1).collect(Collectors.toList());
			Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
			College c=new College(99,"GCET",c1);
		    University u= new University(101,"Anna University",a,c);
			Mockito.when(urrep.findById(101)).thenReturn(Optional.of(u));
			University u1=urser.getByUniversityId(101);
			
			
		}
		@Test
		void deleteTest() {
			Branch b=new Branch(117,"IT","Information Technology");
			Branch b1=new Branch(118,"HRM","Human Resource Management");
			List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
			Course course=new Course(10,"MBA","Master Of Business and Administration","PG",branch);
			Branch b2=new Branch(119,"IT","Information Technology");
			Branch b3=new Branch(120,"HRM","Human Resource Management");
			List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
			Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
			List<Course> c1=Stream.of(course,course1).collect(Collectors.toList());
			Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
			College c=new College(99,"GCET",c1);
		    University u= new University(101,"Anna University",a,c);
			Mockito.when(urrep.findById(101)).thenReturn(Optional.of(u));
			urrep.deleteById(101);;
			University u1=urser.deleteUniversityById(101);
		}
		@Test
		void updateTest() {
			Branch b=new Branch(117,"IT","Information Technology");
			Branch b1=new Branch(118,"HRM","Human Resource Management");
			List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
			Course course=new Course(10,"MBA","Master Of Business and Administration","PG",branch);
			Branch b2=new Branch(119,"IT","Information Technology");
			Branch b3=new Branch(120,"HRM","Human Resource Management");
			List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
			Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
			List<Course> c1=Stream.of(course,course1).collect(Collectors.toList());
			Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
			College c=new College(99,"GCET",c1);
		    University u= new University(101,"Anna University",a,c);
			Mockito.when(urrep.findById(101)).thenReturn(Optional.of(u));
			Mockito.when(urrep.save(u)).thenReturn(u);
			University u1=urser.update(u);
			assertEquals(101,u1.getUniversityId());
			assertEquals("Anna University", u1.getName());
		}
	
		
}	
		




