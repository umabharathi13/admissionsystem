package com.cg.admissionsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Branch;
@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer >  {

	@Query("select b from Branch b where b.branchName=:brname")
	public Branch findByName(@Param("brname") String branchName);
	

	//Branch findByName(String branchName);
	
	//@Modifying      // to mark delete or update query
    @Query(value = "delete from Branch where branch_name = :branch_name",nativeQuery=true)
	void deleteBranchByBranchName(@Param("branch_name") String branchName);


	public Optional<Branch> findByBranchName(String branchName);
	
}
