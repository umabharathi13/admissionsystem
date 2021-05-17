package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Document;
import com.cg.admissionsystem.repository.IDocumentRepository;



@Service
public class DocumentServiceImpl implements IDocumentService {


	@Autowired
	IDocumentRepository docser;

	@Override
	public Document save(Document document) {
		// TODO Auto-generated method stub
		return docser.save(document);
	}

	@Override
	public List<Document> viewAll() {
		// TODO Auto-generated method stub
		return docser.findAll();
	}
	@Override
	public Document deleteDocumentById(int id) {
		Optional<Document> opt= docser.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		docser.deleteById(id);
		return opt.get();
	}
	@Override
	public Document getDocumentById(int id) {
		Optional<Document> opt= docser.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
	

	@Override
	public Document getByapplicantid(int applicantid) {
		Document opt= docser.getDocumentApplicantId(applicantid);
		if(opt==null) {
			return null;
		}
		return docser.getDocumentApplicantId(applicantid);
	}

	@Override
	public Document getDocumentEmail(String emailid) {
		Document opt= docser.getDocumentEmail(emailid);
		if(opt==null) {
			return null;
		}
		return docser.getDocumentEmail(emailid);
	
	}
	
	@Override
	public Document updateDocument(Document document) {
		Document doc = docser.findById(document.getDocumentid()).get();
		doc.setDocumentName(document.getDocumentName());
		doc.setDocumentUrl(document.getDocumentUrl());
		doc.setApplicantid(document.getApplicantid());
		doc.setEmailid(document.getEmailid());
		doc.setDocumentStatus(document.getDocumentStatus());
		return docser.save(doc);
	}
	
	
	@Override
	public Document UpdateById(int id,Document document)
	{
		Document doc=docser.findById(id).get();
		doc.setDocumentName(document.getDocumentName());
		return docser.save(doc);
	}
	@Override
	public Document getByDocumentName(String documentName) {
		Document doc=docser.getByDocumentName(documentName);
		if(doc==null) {
		   return null;
		}
		return docser.getByDocumentName(documentName);
	}


	public  void deleteDocumentByEmail(String emailid) {
		Document co=docser.getDocumentEmail(emailid);
		int a=co.getDocumentid();
		if(a!=0)
		docser.deleteById(a);
	}
			
		

	public void deleteDocumentByApplicantid(int applicantid) {
		Document co= docser.getDocumentApplicantId(applicantid);
		int a=co.getApplicantid();
		if(a!=0) 
		docser.deleteById(a);
	}

	
	

}