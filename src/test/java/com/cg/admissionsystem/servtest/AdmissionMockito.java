package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.repository.IAdmissionRepository;
import com.cg.admissionsystem.service.AdmissionServiesImpl;

@ExtendWith(SpringExtension.class)
class AdmissionMockito {
	@InjectMocks
	AdmissionServiesImpl ass;

	@MockBean
	IAdmissionRepository ar;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@Disabled
	void testAdd() {
		Program pgm = new Program(120, "iit", "7 months", "B.EE", "Intelligence it", "PG", "Onprocess");

		Branch b = new Branch(117, "IT", "Information Technology");
		Branch b1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(6, "MBA", "Master Of Business and Administration", "PG", branch);

		Address a = new Address(4, "salem", "indian", "salem", "opp busstand", "tamilnadu", "635108");

		College c = new College(12, "vit university", a);
		Admission add = new Admission(1, "usa@gmail.com", "pending", "2020", c, course, pgm);
		Mockito.when(ar.save(add)).thenReturn(add);
		Admission admission = ass.save(add);
		assertEquals(1, admission.getAdmissionId());
	}

	@Test
	@Disabled
	void viewAll() {
		Program pgm = new Program(120, "iit", "7 months", "B.EE", "Intelligence it", "PG", "Onprocess");

		Branch b = new Branch(117, "IT", "Information Technology");
		Branch b1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(6, "MBA", "Master Of Business and Administration", "PG", branch);

		Address a = new Address(4, "salem", "indian", "salem", "opp busstand", "tamilnadu", "635108");

		College c = new College(12, "vit university", a);
		Admission add = new Admission(1, "usa@gmail.com", "pending", "2020", c, course, pgm);

		Program pgm1 = new Program(120, "iit", "7 months", "B.EE", "Intelligence it", "PG", "Onprocess");
		Branch b3 = new Branch(118, "IT", "Information Technology");
		Branch b2 = new Branch(119, "HRM", "Human Resource Management");
		List<Branch> branch1 = Stream.of(b, b1).collect(Collectors.toList());
		Course course1 = new Course(9, "MBA", "Master Of Business and Administration", "PG", branch);

		Address a1 = new Address(6, "salem", "indian", "salem", "opp busstand", "tamilnadu", "635108");

		College c1 = new College(15, "vit university", a);
		Admission add1 = new Admission(2, "usa@gmail.com", "pending", "2020", c1, course1, pgm1);
		List<Admission> admission = Stream.of(add, add1).collect(Collectors.toList());
		Mockito.when(ass.viewAll()).thenReturn(admission);
		List<Admission> admissionlist = ass.viewAll();
		assertEquals(2, admissionlist.size());
	}
}
