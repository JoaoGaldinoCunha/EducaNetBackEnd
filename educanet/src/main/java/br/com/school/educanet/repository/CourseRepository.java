package br.com.school.educanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbCourse;


@Repository
public interface CourseRepository extends JpaRepository<TbCourse, Long>{

	@Query(value = "SELECT c.* FROM tb_course as c INNER JOIN tb_user_course as uc ON c.courseId = uc.courseId INNER JOIN tb_user as u ON u.userId = uc.userId WHERE u.userId = :id",nativeQuery = true)
	List<TbCourse> searchingCoursesByUserId(long id);

	@Query("select c from TbCourse c where c.courseName= :Name")
	TbCourse findByName(@Param("Name") String courseName);

	List<TbCourse> findAll();


	boolean existsByCourseId (long tbCourse);

	TbCourse findByCourseId(long id);
}
