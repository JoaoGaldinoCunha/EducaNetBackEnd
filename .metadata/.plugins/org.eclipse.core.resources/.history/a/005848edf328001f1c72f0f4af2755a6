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
	private TbUser tbUser;
	@OneToOne
	@JoinColumn(name = "courseId")
	private TbCourse tbCourse;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userCourseId;
	
	
	public TbUser getTbUser() {
		return tbUser;
	}
	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
	public TbCourse getTbCourse() {
		return tbCourse;
	}
	public void setTbCourse(TbCourse tbCourse) {
		this.tbCourse = tbCourse;
	}
	public long getUserCourseId() {
		return userCourseId;
	}
	public void setUserCourseId(long userCourseId) {
		this.userCourseId = userCourseId;
	}
	
	
}
