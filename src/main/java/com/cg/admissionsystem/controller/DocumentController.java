package com.cg.admissionsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.DocumentNotFoundException;
import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.service.IDocumentService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DocumentController {
	/**
	 * Logger
	 */
	
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(DocumentController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IDocumentService docService;

	/**
	 * This below function is used to create a new document and redirects to the
	 * document service
	 */
	@PostMapping("/document")
	public ResponseEntity<Document> addDocument(@Valid @RequestBody Document document) {
		docService.save(document);
		logger.info("adding values");
		return ResponseEntity.ok(document);
		
	}

	/**
	 * This below function is used to get all the document and redirects to the
	 * document service
	 */

	@GetMapping("/document")
	public ResponseEntity<List<Document>> viewAllDocumentDetails() {
		logger.info("getting all document values");
		List<Document> document=docService.viewAll();
		return ResponseEntity.ok().body(document);
	}

	/**
	 * This below function is used to delete a specific document based on the give
	 * Id and redirects to the document service
	 */
	@DeleteMapping("/document/{id}")
	public Document deleteDocumentById(@PathVariable("id") int docId) {
		if (docService.getDocumentById(docId) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + docId);
		}
		logger.info("deleting document by id"+docId);
		return docService.deleteDocumentById(docId);
	}

	/**
	 * This below function is used to get a specific document and id as parameter
	 * and redirects to the document service
	 */

	@GetMapping("/document/{id}")
	public ResponseEntity<Document> getDocumentById(@PathVariable("id") int documentid) {
		if (docService.getDocumentById(documentid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + documentid);
		}
		logger.info("getting document by id"+documentid);
		Document document=docService.getDocumentById(documentid);
		return ResponseEntity.ok(document);
	}

	/**
	 * This below function is used to get a specific document and applicantId as
	 * parameter and redirects to the document service
	 */
	@GetMapping("/document/id/{id}")
	public ResponseEntity<Document>getDocumentByApplicantId(@PathVariable("id") int applicantid) {
		if (docService.getByapplicantid(applicantid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + applicantid);
		}
		logger.info("getting document by applicantid"+applicantid);
		Document document=docService.getByapplicantid(applicantid);
		return ResponseEntity.ok(document);
	}

	/**
	 * This below function is used to get a specific document and emailId as
	 * parameter and redirects to the document service
	 */
	@GetMapping("/document/emailid/{emailid}")
	public ResponseEntity<Document> getDocumentEmail(@PathVariable("emailid") String emailid) {
		if (docService.getDocumentEmail(emailid) == null) {
			throw new DocumentNotFoundException("Document not found with given name: " + emailid);
		}
		logger.info("getting document by emailid"+emailid);
		Document document=docService.getDocumentEmail(emailid);
		return ResponseEntity.ok(document);
	}

	/**
	 * This below function is used to update a specific document based on the give
	 * Id and redirects to the document service
	 */
	@PatchMapping("/document/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable("id") int documentid, @RequestBody Document document) {
		if (docService.getDocumentById(documentid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + documentid);
		}
		logger.info("updating doument"+documentid);
		Document d=docService.updateDocument(document);
		return ResponseEntity.ok(d);
	}

	/**
	 * This below function is used to update a specific document based on the give
	 * Id and redirects to the document service
	 */
	@PutMapping("/document/i/{id}")
	public ResponseEntity<Document> updateDocumentById(@PathVariable("id") int documentid, @RequestBody Document document) {
		if (docService.getDocumentById(documentid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + documentid);
		}
		logger.info("updating document by id"+documentid);
		Document dd=docService.UpdateById(documentid,document);
		return ResponseEntity.ok(dd);
	}

	/**
	 * This below function is used to get a specific document and name as parameter
	 * and redirects to the document service
	 */

	@GetMapping("/document/name/{Name}")
	public ResponseEntity< Document >getByDocumentName(@PathVariable("Name") String Name) {
		if (docService.getByDocumentName(Name) == null) {
			throw new DocumentNotFoundException("Document not found with given name: " + Name);
		}
		logger.info("getting document by name"+Name);
		Document document=docService.getByDocumentName(Name);
		return ResponseEntity.ok(document);
	}

	/**
	 * This below function is used to delete a specific document based on the give
	 * emailId and redirects to the document service
	 */
	@DeleteMapping("/document/e/{emailid}")
	public Document deleteDocumentByEmail(@PathVariable("emailid") String emailid) {
		if (docService.getDocumentEmail(emailid) == null) {
			throw new DocumentNotFoundException("Document not found with given emailid: " + emailid);
		}
		logger.info("deleting document by emailid"+emailid);
		return docService.deleteDocumentByEmail(emailid);
	}

	/**
	 * This below function is used to delete a specific document based on the give
	 * applicantId and redirects to the document service
	 * @return 
	 */

	@DeleteMapping("/document/a/{applicantid}")
	public Document deleteDocumentByApplicantId(@PathVariable("applicantid") int applicantid) {
		if (docService.getByapplicantid(applicantid) == null) {
			throw new DocumentNotFoundException("Document not found with given emailid: " + applicantid);
		}
		logger.info("deleting document by applicantid"+applicantid);
		return docService.deleteDocumentByApplicantid(applicantid);
	}
}