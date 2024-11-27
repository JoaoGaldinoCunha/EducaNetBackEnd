package br.com.school.educanet.repository;

import br.com.school.educanet.model.TbCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.school.educanet.model.TbVideoCourse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VideoCourseRepository extends JpaRepository<TbVideoCourse, Integer> {
	
	@Query("select c from TbVideoCourse c where c.videoCourseName= :Name")
	TbVideoCourse findByName(@Param("Name") String videoCourseName);
	
	@Query(value = "SELECT videoCourseId FROM tb_videoCourse WHERE courseId = :id",nativeQuery = true)
	Integer searchingById(Long id);

	@Transactional
	void deleteAllByTbCourse(TbCourse tbCourse);

	boolean existsByTbCourse(TbCourse tbCourse);

	@Query(value = "SELECT c.courseId,c.courseName,v.videoCourseId,v.videoCourseName,v.videoCourseDescription,v.videoCourseUrlId FROM tb_user_course uc JOIN tb_course c ON uc.courseId = c.courseId JOIN tb_videoCourse v ON v.courseId = c.courseId WHERE uc.userId= :id ;",nativeQuery = true)
	List<TbVideoCourse> searchingVideoCoursesByUserId(long id);

	@Query(value = "select * from tb_videoCourse ;",nativeQuery = true)
	List<TbVideoCourse> searchingAllVideoCourses();

	@Query(value = "SELECT * FROM tb_videoCourse WHERE videoCourseId = :id", nativeQuery = true)
	List<TbVideoCourse> searchingVideoCourserById(@Param("id") long id);


}

