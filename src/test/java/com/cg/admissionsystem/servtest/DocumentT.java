package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.service.IDocumentService;

@SpringBootTest
class DocumentT {
	
	org.apache.logging.log4j.Logger logger=LogManager.getLogger(DocumentT.class);

	@Autowired
	IDocumentService ds;

	@Test
	// @Disabled
	void addDocumentTest() {
		Document doc = new Document(14, "sprint2", "www.sprint2.com", 5, "raja@gmail.com", "approved");
		Document d = ds.save(doc);
		logger.info(d);
		logger.info("added succesfully");
		assertEquals("sprint2", d.getDocumentName());
	}

	@Test
	// @Disabled
	void viewApplicationTest() {
		List<Document> view = ds.viewAll();
		logger.info(view);
		logger.info("getting all details");
		assertEquals(2, view.size());

	}

	@Test
	@Disabled
	void deleteDocumentByIdTest() {
		Document view = ds.deleteDocumentById(12);
		logger.info(view);
		logger.info("deleted succesfully");
		assertEquals(12, view.getDocumentid());

	}

	@Test
	@Disabled
	void getApplicationByIdTest() {
		Document view = ds.getByapplicantid(5);
		logger.info(view);
		logger.info("getting values by applicantid");
		assertEquals(5, view.getApplicantid());

	}

	@Test
	@Disabled
	void getDocumentByIdTest() {
		Document view = ds.getDocumentById(14);
		logger.info(view);
		logger.info("getting values by documentid");
		assertEquals(14, view.getDocumentid());

	}

	@Test
	@Disabled
	void getDocumentByEmailIdTest() {
		Document view = ds.getDocumentEmail("raja@gmail.com");
		logger.info(view);
		logger.info("getting values by emailid");
		assertEquals("raja@gmail.com", view.getEmailid());

	}

	@Test
	@Disabled
	void updateDocumentTest() {
		Document d = new Document();
		d.setDocumentid(14);
		d.setDocumentName("bharathi");
		d.setApplicantid(5);
		d.setDocumentStatus("approved");
		d.setDocumentUrl("www.bharathi.com");
		d.setEmailid("bharathi@gmail.com");
		Document view = ds.updateDocument(d);
		logger.info(view);
		logger.info("updating values");
		assertEquals(14, view.getDocumentid());
	}

	@Test
	@Disabled
	void getDocumentByNameTest() {
		Document view = ds.getByDocumentName("poo");
		logger.info(view);
		logger.info("getting values by documnetname");
		assertEquals("poo", view.getDocumentName());

	}

	@Test
	@Disabled
	void deleteDocumentByEmailTest() {
		Document view = ds.getDocumentEmail("poo@gmail.com");
		logger.info(view);
		logger.info("delete values by emailid");
		assertEquals("poo@gmail.com", view.getEmailid());

	}

	@Test
	@Disabled
	void deleteDocumentByApplicantIdTest() {
		Document view = ds.getByapplicantid(6);
		logger.info(view);
		logger.info("delete values by applicantid");
		assertEquals(6, view.getApplicantid());

	}
}