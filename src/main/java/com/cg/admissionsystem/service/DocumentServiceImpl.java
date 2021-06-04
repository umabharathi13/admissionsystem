package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.repository.IDocumentRepository;

/**
 * Document Service
 *
 */

@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	IDocumentRepository docser;

	/**
	 * To store the document
	 */

	@Override
	public Document save(Document document) {
		// TODO Auto-generated method stub
		return docser.save(document);
	}

	/**
	 * To List all the document called from the controller class and send back to
	 * the Controller
	 */

	@Override
	public List<Document> viewAll() {
		// TODO Auto-generated method stub
		return docser.findAll();
	}

	/**
	 * used to delete the document based on the given id
	 *
	 */
	@Override
	public Document deleteDocumentById(int id) {
		Optional<Document> opt = docser.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		docser.deleteById(id);
		return opt.get();
	}

	/**
	 * Get and retrieve a specific Document based on the given id else throws
	 * DocumentNotFound Exception
	 */
	@Override
	public Document getDocumentById(int id) {
		Optional<Document> opt = docser.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	/**
	 * Get and retrieve a specific Document based on the given ApplicantId else
	 * throws DocumentNotFound Exception
	 */

	@Override
	public Document getByapplicantid(int applicantid) {
		Document opt = docser.getDocumentApplicantId(applicantid);
		if (opt == null) {
			return null;
		}
		return docser.getDocumentApplicantId(applicantid);
	}

	/**
	 * Get and retrieve a specific Document based on the given email else throws
	 * DocumentNotFound Exception
	 */

	@Override
	public Document getDocumentEmail(String emailid) {
		Document opt = docser.getDocumentEmail(emailid);
		if (opt == null) {
			return null;
		}
		return docser.getDocumentEmail(emailid);

	}

	/**
	 * To update the Document based on the given id and object
	 */

	@Override
	public Document updateDocument(Document document) {
		Optional<Document> doc = docser.findById(document.getDocumentid());
		if (doc == null) {
			return null;
		}
		doc.get().setEmailid(document.getEmailid());
		return docser.save(doc.get());
	}

	/**
	 * To update the Document based on the given id and object
	 */
	@Override
	public Document UpdateById(int id, Document document) {
		Optional<Document> doc = docser.findById(document.getDocumentid());
		if (doc == null) {
			return null;
		}
		doc.get().setDocumentName(document.getDocumentName());
		doc.get().setDocumentUrl(document.getDocumentUrl());
		doc.get().setApplicantid(document.getApplicantid());
		doc.get().setEmailid(document.getEmailid());
		doc.get().setDocumentStatus(document.getDocumentStatus());
		return docser.save(doc.get());
	}

	/**
	 * Get and retrieve a specific Document based on the given id else throws
	 * DocumentNotFound Exception
	 */
	@Override
	public Document getByDocumentName(String documentName) {
		Document doc = docser.getByDocumentName(documentName);
		if (doc == null) {
			return null;
		}
		return docser.getByDocumentName(documentName);
	}

	/**
	 * used to delete the document based on the given email
	 *
	 */

	@Override
	public Document deleteDocumentByEmail(String emailid) {
	 Document opt = docser.deleteDocumentByEmail(emailid);
		if (opt==null) {
			return null;
		}
		return docser.deleteDocumentByEmail(emailid);
		
	}

	/**
	 * used to delete the document based on the given ApplicantId
	 *
	 */

	@Override
	public Document deleteDocumentByApplicantid(int applicantid) {
		Document co = docser.getDocumentApplicantId(applicantid);
		if (co == null)
		{
			return null;
		};
			return docser.deleteDocumentByApplicantid(applicantid);
		
	}

}