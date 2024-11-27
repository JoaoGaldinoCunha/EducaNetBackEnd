package br.com.school.educanet.repository;


import java.util.List;

import br.com.school.educanet.model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.model.TbUserCourse;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserCourseRepository extends JpaRepository<TbUserCourse, Long> {
	
	@Query(value = "SELECT userCourseId FROM tb_user_course WHERE userId = :id",nativeQuery = true)
	Long searchingById(long id);

	boolean existsByTbCourse(TbCourse tbCourse);

	@Modifying
	@Transactional
	@Query(value = "INSERT into tb_user_course (userId, courseId) VALUES (:tbUser , :tbCourse)", nativeQuery = true)
	void saveUserInCourse(long tbUser, long tbCourse);

	boolean existsByTbCourseAndTbUser(TbCourse tbCourse, TbUser tbUser);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tb_user_course WHERE userId = :tbUser AND courseId = :tbCourse", nativeQuery = true)
	void deleteUserFromCourse(long tbCourse, long tbUser);
	@Query(value = "SELECT u.userName, u.userLastName, c.courseName,uc.userCourseId,c.courseId,u.userId " +
			"FROM tb_user u " +
			"JOIN tb_user_course uc ON u.userId = uc.userId " +
			"JOIN tb_course c ON uc.courseId = c.courseId " +
			"WHERE c.courseId = :id", nativeQuery = true)
	List<TbUserCourse> searchingUserRegisteredInCourses (@Param("id") long id);
}
