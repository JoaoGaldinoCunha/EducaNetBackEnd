package br.com.school.educanet.service;

import java.util.List;
import java.util.Optional;

import br.com.school.educanet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.repository.CourseRepository;
import br.com.school.educanet.repository.UserCourseRepository;
import br.com.school.educanet.repository.VideoCourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	VideoCourseRepository videoCourseRepository;
	
	@Autowired
	UserCourseRepository userCourseRepository;

	@Autowired
	UserRepository userRepository;

	public TbCourse saveCourse(TbCourse tbCourse) {
		if (courseRepository.findByName(tbCourse.getCourseName()) != null) {
			throw new RuntimeException("Já existe curso com este nome!");
		}
		return courseRepository.save(tbCourse);
	}

	
	public String deleteCourse(long id ) {

		if(courseRepository.existsByCourseId(id)){
			var tbCourse = courseRepository.findByCourseId(id);
				if(userCourseRepository.existsByTbCourse(tbCourse)) {
					return ("Há usuários ativos no curso!");
				}
				if (videoCourseRepository.existsByTbCourse(tbCourse)){
					videoCourseRepository.deleteAllByTbCourse(tbCourse);
	    		}
				courseRepository.deleteById(tbCourse.getCourseId());
				return ("Curso excluído com sucesso!Todos registros de videos foram apagados");
			}
		return ("Curso não encontrado!");
	}
	
	
	public TbCourse updateCourse(Long courseId, TbCourse updatedCourse) {
        TbCourse existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        if (updatedCourse.getCourseName() != null) {
            existingCourse.setCourseName(updatedCourse.getCourseName());;
        }
        if (updatedCourse.getWorkload() != null) {
            existingCourse.setWorkload(updatedCourse.getWorkload());
        }
        if (updatedCourse.getCourseName() != null) {
            existingCourse.setDescription(updatedCourse.getDescription());
        }
        if (updatedCourse.getCourseClass() != null) {
            existingCourse.setCourseClass(updatedCourse.getCourseClass());
        }
        return courseRepository.save(existingCourse);
        
	}
	
	
	public Optional<TbCourse> returningCourseById(Long id){
		return courseRepository.findById(id);
	}
	
	
	public List<TbCourse> returningCourses() {
		return courseRepository.findAll();
	}

	public List<TbCourse> userCourserById(Long id){
		if (userRepository.existsByUserId(id)){
			return courseRepository.searchingCoursesByUserId(id);
		}
		return null;
	} }