package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.onlineadmissionsyst.module.Document;
import com.cg.onlineadmissionsyst.repository.IDocumentRepository;
import com.cg.onlineadmissionsyst.service.DocumentServiceImpl;

@ExtendWith(SpringExtension.class)
class DocumentMockito {
	@InjectMocks
	DocumentServiceImpl ds;
	
	@MockBean
	IDocumentRepository are;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addDocument(){
		Document d=new Document(2,"sprint2","www.sprint2.com",15,"raja@gmail.com","approved");
		Mockito.when(are.save(d)).thenReturn(d);
		Document document=ds.save(d);
		assertEquals(2,document.getDocumentid());
	}
    
	@Test
	void viewAll() {
		Document d1=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","pending");
		Document d2=new Document(2,"sprint2","www.sprint2.com",15,"raja@gmail.com","approved");
		List<Document>l=new ArrayList<>();
		l.add(d1);
		l.add(d2);
		Mockito.when(ds.viewAll()).thenReturn(l);
		List<Document>documentlist=ds.viewAll();
		assertEquals(2,documentlist.size());
	}
	

	@Test
	
	void DeleteDocumentByIdTest() {
		Document d=new Document(2,"sprint2","www.sprint2.com",15,"raja@gmail.com","approved");
		Mockito.when(are.findById(2)).thenReturn(Optional.of(d));
		ds.deleteDocumentById(2);
		assertEquals(2,d.getDocumentid());
	}
	
	@Test
	void getDocumentById() {
		Document d=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","pending");
		Mockito.when(are.findById(1)).thenReturn(Optional.of(d));
		assertEquals(1,d.getDocumentid());
	}
	
	
	@Test
	void getDocumentByapplicantId() {
		Document d=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","pending");
		Mockito.when(are.getDocumentApplicantId(13)).thenReturn(d);
		assertEquals(13,d.getApplicantid());
	}
	
	@Test
	void getDocumentByEmailId() {
		Document d=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","pending");
		Mockito.when(are.getDocumentEmail("raj@gmail.com")).thenReturn(d);
		assertEquals("raj@gmail.com",d.getEmailid());
	}
	
	@Test
	void getDocumentBynameId() {
		Document d=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","pending");
		Mockito.when(are.getByDocumentName("sprint")).thenReturn(d);
		assertEquals("sprint",d.getDocumentName());
	}
	
	@Test 
	void updateDocument() {
		Document d=new Document(1,"sprint","www.sprint.com",13,"raj@gmail.com","approved");
		Mockito.when(are.findById(1)).thenReturn(Optional.of(d));
		Mockito.when(are.save(d)).thenReturn(d);
		Document document=ds.updateDocument(d);
		assertEquals("approved",document.getDocumentStatus());
	}
	@Test
	void DeleteDocumentByapplicantidTest() {
		Document d=new Document(1,"spring2","www.spring2.com",13,"raj@gmail.com","approved");
		Mockito.when(are.getDocumentApplicantId(13)).thenReturn(d);
		ds.deleteDocumentByApplicantid(13);
		assertEquals(13,d.getApplicantid());
	}
	@Test
	void DeleteDocumentByemailIdTest() {
		Document d=new Document(2,"sprint2","www.sprint2.com",15,"raja@gmail.com","approved");
		Mockito.when(are.getDocumentEmail("raja@gmail.com")).thenReturn(d);
		ds.deleteDocumentByEmail("raja@gmail.com");
		assertEquals("raja@gmail.com",d.getEmailid());
	}
}
