package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineadmissionsyst.module.Document;
import com.cg.onlineadmissionsyst.service.IDocumentService;

@SpringBootTest
class DocumentT {
	@Autowired
	IDocumentService ds;

	@Test
	@Disabled
	void adddocumenttest() {
		Document doc = new Document(14, "sprint2", "www.sprint2.com", 5, "raja@gmail.com", "approved");
		Document d = ds.save(doc);
		assertEquals("sprint2", d.getDocumentName());
	}

	@Test
	@Disabled
	void viewapplicationtest() {
		List<Document> view = ds.viewAll();
		assertEquals(2, view.size());

	}

	@Test
	@Disabled
	void DeleteDocumentByIdTest() {
		Document view = ds.deleteDocumentById(12);
		assertEquals(12, view.getDocumentid());

	}

	@Test
	@Disabled
	void getApplicationByIdtest() {
		Document view = ds.getByapplicantid(5);
		assertEquals(5, view.getApplicantid());

	}

	@Test
	@Disabled
	void getDocumentByIdtest() {
		Document view = ds.getDocumentById(14);
		assertEquals(14, view.getDocumentid());

	}

	@Test
	@Disabled
	void getDocumentByEmailidtest() {
		Document view = ds.getDocumentEmail("raja@gmail.com");
		assertEquals("raja@gmail.com", view.getEmailid());

	}

	@Test
	@Disabled
	void updateDocumenttest() {
		Document d = new Document();
		d.setDocumentid(14);
		d.setDocumentName("bharathi");
		d.setApplicantid(5);
		d.setDocumentStatus("approved");
		d.setDocumentUrl("www.bharathi.com");
		d.setEmailid("bharathi@gmail.com");
		Document view = ds.updateDocument(d);
		assertEquals(14, view.getDocumentid());
	}

	@Test
	@Disabled
	void getDocumentBynametest() {
		Document view = ds.getByDocumentName("poo");
		assertEquals("poo", view.getDocumentName());

	}

	@Test
	@Disabled
	void deleteDocumentByEmailtest() {
		Document view = ds.getDocumentEmail("poo@gmail.com");
		assertEquals("poo@gmail.com", view.getEmailid());

	}

	@Test
	@Disabled
	void deleteDocumentByApplicantIdTest() {
		Document view = ds.getByapplicantid(6);
		assertEquals(6, view.getApplicantid());

	}
}