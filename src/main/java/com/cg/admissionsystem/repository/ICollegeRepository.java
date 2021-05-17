package com.cg.admissionsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;

@Repository
public interface ICollegeRepository extends JpaRepository<College,Integer> {

	@Query("select c from College c where c.collegeName=:clname")
	College findBycollegeName(@Param("clname") String collegeName);

	/*@Query(value = "select * from college inner join course on college.college_id=college.college_reg_id where college.college_name =:n",nativeQuery=true)
	College findBycourseName(@Param("coname") String courseName);
	*/

}
