package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

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

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.repository.ICourseRepository;
import com.cg.admissionsystem.service.CourseServiceImpl;

@ExtendWith(SpringExtension.class)
class CourseMockito {
	@InjectMocks
	CourseServiceImpl crser;
	@MockBean
	ICourseRepository crrep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void createTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Mockito.when(crrep.save(course)).thenReturn(course);
		Course c1=crser.save(course);
		assertEquals(1,c1.getCourseId());
		}
	@Test
	void viewTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Branch b2=new Branch(119,"IT","Information Technology");
		Branch b3=new Branch(120,"HRM","Human Resource Management");
		List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
		Course course1=new Course(1,"M-TECH","Master Of Technology","PG",branch1);
		List<Course> c=new ArrayList<>();
		c.add(course);
		c.add(course1);
		Mockito.when(crrep.findAll()).thenReturn(c);
		List<Course> c1=crser.findAll();
		assertEquals(2,c1.size());
		}
	@Test
	void getbyidTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Mockito.when(crrep.findById(1)).thenReturn(Optional.of(course));
		Course c1=crser.getByCId(1);
		assertEquals("MBA", c1.getCourseName());
		}
	@Test
	void deletebyid() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Mockito.when(crrep.findById(1)).thenReturn(Optional.of(course));
		crrep.deleteById(1);
		Course c=crser.deleteByCourseId(1);
		assertEquals("MBA", c.getCourseName());
	}
	@Test
	void updateTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business And Administration","PG",branch);
		Mockito.when(crrep.findById(1)).thenReturn(Optional.of(course));
		Mockito.when(crrep.save(course)).thenReturn(course);
		Course c=crser.save(course);
		assertEquals("MBA", c.getCourseName());
		assertEquals("Master Of Business And Administration", c.getDescription());
		}
	@Test
	void getbyeligiTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Branch b2=new Branch(119,"IT","Information Technology");
		Branch b3=new Branch(120,"HRM","Human Resource Management");
		List<Branch> branch1=Stream.of(b2,b3).collect(Collectors.toList());
		Course course1=new Course(1,"M-TECH","Master Of Technology","UG",branch1);
		List<Course> c=new ArrayList<>();
		c.add(course);
		c.add(course1);
		Mockito.when(crrep.findByEligibility("PG")).thenReturn(c);
		List<Course> c1=crser.findByEligibility("PG");
		assertEquals(2,c1.size());
	   }
	@Test
	void getbynameTest() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Mockito.when(crrep.findByName("MBA")).thenReturn(course);
		Course c1=crser.findByName("MBA");
		assertEquals("MBA", c1.getCourseName());
	}
	@Test
	void detbyname() {
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		Course course=new Course(1,"MBA","Master Of Business and Administration","PG",branch);
		Mockito.when(crrep.findByName("MBA")).thenReturn(course);
		crrep.deleteCourseByCourseName(null);
		}
	

}
