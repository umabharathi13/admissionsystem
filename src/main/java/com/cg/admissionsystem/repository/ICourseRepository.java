package com.cg.admissionsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Course;

/**
 * Course Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 */
@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

	// find by courseName
	@Query("select c from Course c where c.courseName=:crname")
	public Course findByName(@Param("crname") String courseName);

	// find by eligibility
	@Query("select c1 from Course c1 where c1.eligibility=:eligibility")
	public List<Course> findByEligibility(@Param("eligibility") String eligibility);

	// delete by courseName
	@Query(value = "delete from course where course_name = :course_name", nativeQuery = true)
	public void deleteCourseByCourseName(@Param("course_name") String courseName);

	// find by courseName
	public Optional<Course> findByCourseName(String courseName);

	// find all courses by collegeName
	@Query(value = "select * from course inner join college on course.college_id=college.college_reg_id where college.college_name =:n", nativeQuery = true)
	public List<Course> findBycollegeName(@Param("n") String collegeName);

}
