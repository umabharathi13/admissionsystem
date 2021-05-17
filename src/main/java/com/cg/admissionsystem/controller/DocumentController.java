package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.AddressNotFoundException;
import com.cg.admissionsystem.exception.DocumentNotFoundException;
import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.service.IDocumentService;

@RestController
public class DocumentController {

	@Autowired
	IDocumentService docService;

	// WRITE
	@PostMapping("/document")
	public Document addDocument(@RequestBody Document document) {
		return docService.save(document);
	}

	@GetMapping("/document")
	public List<Document> viewAllDocumentDetails() {
		return docService.viewAll();
	}

	// DELETE
	@DeleteMapping("/document/{id}")
	public Document deleteDocumentById(@PathVariable("id") int docId) {
		if (docService.getDocumentById(docId) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + docId);
		}
		return docService.deleteDocumentById(docId);
	}

	@GetMapping("/document/{id}")
	public Document getDocumentById(@PathVariable("id") int documentid) {
		if (docService.getDocumentById(documentid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + documentid);
		}
		return docService.getDocumentById(documentid);
	}

	@GetMapping("/document/id/{id}")
	public Document getDocumentByapplicantId(@PathVariable("id") int applicantid) {
		if (docService.getByapplicantid(applicantid) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + applicantid);
		}
		return docService.getByapplicantid(applicantid);
	}

	@GetMapping("/document/emailid/{emailid}")
	public Document getDocumentEmail(@PathVariable("emailid") String emailid) {
		if (docService.getDocumentEmail(emailid) == null) {
			throw new DocumentNotFoundException("Document not found with given name: " + emailid);
		}
		return docService.getDocumentEmail(emailid);
	}

	// UPDATE
	// Updating specific property
	@PatchMapping("/document/{id}")
	public Document updateDocument(@PathVariable("id") int id, @RequestBody Document document) {
		if (docService.getDocumentById(id) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + id);
		}
		return docService.updateDocument(document);
	}

	@PutMapping("/document/{id}")
	public Document updateDocumentById(@PathVariable("id") int id, @RequestBody Document document) {
		if (docService.getDocumentById(id) == null) {
			throw new DocumentNotFoundException("Document not found with given id: " + id);
		}
		return docService.UpdateById(id, document);
	}

	@GetMapping("/document/name/{Name}")
	public Document getByDocumentName(@PathVariable("Name") String Name) {
		if (docService.getByDocumentName(Name) == null) {
			throw new DocumentNotFoundException("Document not found with given name: " + Name);
		}
		return docService.getByDocumentName(Name);
	}

	@DeleteMapping("/document/e/{emailid}")
	public void deleteDocumentByEmail(@PathVariable("emailid") String emailid) {

		docService.deleteDocumentByEmail(emailid);
	}

	@DeleteMapping("/document/a/{applicantid}")
	public void deleteDocumentByApplicantid(@PathVariable("applicantid") int applicantid) {

		docService.deleteDocumentByApplicantid(applicantid);
	}
}