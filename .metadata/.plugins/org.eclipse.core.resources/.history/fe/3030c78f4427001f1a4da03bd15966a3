package br.com.school.educanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbCourse;


@Repository
public interface CourseRepository extends JpaRepository<TbCourse, Integer>{	
	
	@Query(value = "select c from TbCourse c where c.couserName= :courseName")
	TbCourse findByName(@Param("courseName") String couserName);
		
}
