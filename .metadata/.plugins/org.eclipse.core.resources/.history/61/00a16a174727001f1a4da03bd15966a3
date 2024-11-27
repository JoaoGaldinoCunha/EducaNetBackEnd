package br.com.school.educanet.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_course")
public class TbUserCourse {
	@OneToOne
	@JoinColumn(name = "userId")
	TbUser tbUser;
	@OneToOne
	@JoinColumn(name = "courseId")
	TbCourse tbCourse;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userCourseId;
	
	
}
