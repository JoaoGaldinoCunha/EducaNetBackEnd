package br.com.school.educanet.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.school.educanet.model.TbVideoCourse;
import br.com.school.educanet.repository.UserCourseRepository;
@Service
public class UserCourseService {
	@Autowired
	UserCourseRepository userCourseRepository;
	
	
	public List<TbVideoCourse> userCourserById(Integer id){
	return userCourseRepository.searchingCoursesByUserId(id);
	} 

}
