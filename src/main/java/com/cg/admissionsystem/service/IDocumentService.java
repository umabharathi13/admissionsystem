package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Document;
@Service
public interface IDocumentService {
	

	Document save(Document document);
	List<Document> viewAll();
	Document deleteDocumentById(int documentId);
	Document getDocumentById(int docId);
	Document getByapplicantid(int applicantid);
	Document getDocumentEmail(String emailid);
	Document updateDocument(Document document);
	Document UpdateById(int id, Document document);
	Document getByDocumentName(String name);
	void deleteDocumentByEmail(String emailid);
	void deleteDocumentByApplicantid(int applicantId);	
	
	
}
