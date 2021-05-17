package com.cg.admissionsystem.servtest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.IUniversityService;

@SpringBootTest
public class UniversityTest {
		
		@Autowired
		IUniversityService uniser;

		@Test	
		@Disabled
		void testfindAll() {
			List<University> u= uniser.findAll();
			for(University u1:u) {
				System.out.println(u1);
			}
			assertEquals(1,u.size());
		}
		@Test
		@Disabled
		void testFindUniversityById() {
			University u=uniser.getByUniversityId(105);
			assertEquals(105,u.getUniversityId());
		}
		@Test
		@Disabled
		void testCreateUniversity() {
            //Program pgm = new Program(120,"iit","7 months","B.EE","Intelligence it","PG","Onprocess");
			//Address a=new Address(6,"salem","indian","salem","opp busstand","tamilnadu","635108");
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
			University u1 = uniser.save(u);
			assertEquals(101,u1.getUniversityId());
		}
		@Test
		@Disabled
		void updateUniversityTest() {
			University u=new University();
			u.setUniversityId(105);
			u.setName("KLU");
			
			University u1=uniser.update(u);
			assertEquals(105,u1.getUniversityId());
		}
		@Test
		@Disabled
		void deleteUniversityTest() {
			uniser.deleteUniversityById(105);
			System.out.println("deleted");
		}
		@Test
		@Disabled
		void findbycolnametest() {
			List<University> u=uniser.findBycollegeName("GCET");
			System.out.println(u);
		}
		

}
