package com.cg.admissionsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Branch;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 * 
 */
@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer> {

	// get Branch by branchName
	@Query("select b from Branch b where b.branchName=:brname")
	public Branch findByName(@Param("brname") String branchName);

	public Optional<Branch> findByBranchName(String string);

	// delete Branch by branchName
	@Query(value = "delete from Branch where branch_name = :branch_name", nativeQuery = true)
	void deleteBranchByBranchName(@Param("branch_name") String branchName);

}
