package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Document;

@Service
public interface IDocumentService {
	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document save(Document document);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	List<Document> viewAll();

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document deleteDocumentById(int documentId);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document getDocumentById(int docId);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document getByapplicantid(int applicantid);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document getDocumentEmail(String emailid);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document updateDocument(Document document);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document UpdateById(int id, Document document);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document getByDocumentName(String name);

	/**
	 * Method to be override by the implementing class
	 * @return 
	 * 
	 */
	Document deleteDocumentByEmail(String emailid);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Document deleteDocumentByApplicantid(int applicantId);

}
