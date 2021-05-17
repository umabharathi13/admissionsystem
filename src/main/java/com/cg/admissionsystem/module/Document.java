package com.cg.admissionsystem.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Document {
	@Id
	private int documentid;
	private String documentName;
	private String documentUrl;
	private int applicantid;
	private String emailid;
	private String documentStatus;
	public Document(int documentid,String documentName, String documentUrl, int applicantid, String emailid,
			String documentStatus) {
		super();
		this.documentid = documentid;
		this.documentName = documentName;
		this.documentUrl = documentUrl;
		this.applicantid = applicantid;
		this.emailid = emailid;
		this.documentStatus = documentStatus;
	}
	public Document() {
		super();
	}//Uploaded/NotUploaded
	public int getDocumentid() {
		return documentid;
	}
	public void setDocumentid(int documentid) {
		this.documentid = documentid;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	public int getApplicantid() {
		return applicantid;
	}
	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}
	@Override
	public String toString() {
		return "Document [documentid=" + documentid + ", documentName=" + documentName + ", documentUrl=" + documentUrl
				+ ", applicantid=" + applicantid + ", emailid=" + emailid + ", documentStatus=" + documentStatus + "]";
	}


}