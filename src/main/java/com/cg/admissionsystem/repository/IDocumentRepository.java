package com.cg.admissionsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Document;


	// Spring Data JPA
@Repository
	public interface IDocumentRepository extends JpaRepository<Document, Integer > {
		
	@Query("select b from Document b where b.applicantid=:applicantid")
	public Document getDocumentApplicantId(@Param("applicantid")int applicantid);
	
		
		@Query("select b from Document b where b.emailid=:emailid")
		public Document getDocumentEmail(@Param("emailid")String emailid);
		
		@Query("select b from Document b where b.documentName=:drname")
		public Document getByDocumentName(@Param("drname")String documentName);
		
		@Query(value = "delete from document where emailid=:emailid",nativeQuery=true)
		Document deleteDocumentByEmail(@Param("emailid")String emailid);
		

		@Query(value = "delete from document where applicantid=:applicantid",nativeQuery=true)
		Document deleteDocumentByApplicantid(@Param("applicantid")int applicantid);


	}




