package com.cg.admissionsystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.admissionsystem.module.ProgramScheduled;

/**
 * ProgramScheduled Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 * @author Brindha
 * 
 */

@Repository
public interface IProgramScheduledRepositoy extends JpaRepository<ProgramScheduled, Integer> {

	List<ProgramScheduled> findByStartDate(String startDate);
/**
 * 
 * Custom query
 *  
 */
	@Query(value = "select * from program_scheduled inner join college on program_scheduled.college_id=college.college_reg_id where college.college_name =:n", nativeQuery = true)
	public List<ProgramScheduled> findBycollegeName(@Param("n") String collegeName);

}
