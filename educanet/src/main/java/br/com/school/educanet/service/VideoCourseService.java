package br.com.school.educanet.service;

import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.school.educanet.model.TbVideoCourse;
import br.com.school.educanet.repository.VideoCourseRepository;

import java.util.List;

@Service
public class VideoCourseService {
		
	@Autowired
		VideoCourseRepository videoCourseRepository;
	@Autowired
	UserRepository userRepository;


	public TbVideoCourse saveVideoCourse(TbVideoCourse tbVideoCourse ) {
			if (videoCourseRepository.findByName(tbVideoCourse.getVideoCourseName()) != null) {
	            throw new RuntimeException("nome do vide existente !!");

			}
			return videoCourseRepository.save(tbVideoCourse);

		}
		
		
		
		public void deleteVideoCourse(Integer id ) {
			if (videoCourseRepository.findById(id) != null) {
			 videoCourseRepository.deleteById(id);
			}
            throw new RuntimeException("video não encontrado!");
		}
		
		
		public TbVideoCourse updateVideoCourse(Integer courseId, TbVideoCourse updatedCourse) {
	        TbVideoCourse existingCourse = videoCourseRepository.findById(courseId)
	                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

	        if (updatedCourse.getVideoCourseDescription() != null) {
	            existingCourse.setVideoCourseDescription(updatedCourse.getVideoCourseDescription());
	        }
	        if (updatedCourse.getTbCourse() != null) {
	            existingCourse.setTbCourse(updatedCourse.getTbCourse());
	        }
	        if (updatedCourse.getVideoCourseUrlId() != null) {
	            existingCourse.setVideoCourseUrlId(updatedCourse.getVideoCourseUrlId());
	        }
	        if (updatedCourse.getVideoCourseName() != null) {
	            existingCourse.setVideoCourseName(updatedCourse.getVideoCourseName());
	        }
	        return videoCourseRepository.save(existingCourse);
		}


		public List<TbVideoCourse> userVideoCourserById(Long id){
		if (userRepository.existsByUserId(id)){
			return videoCourseRepository.searchingVideoCoursesByUserId(id);
		}
		return null;
		}

		public List<TbVideoCourse> allVideoCourses(){
			return videoCourseRepository.searchingAllVideoCourses();
		}

	public List<TbVideoCourse> searchingVideoCourserById(Long id){
		return videoCourseRepository.searchingVideoCourserById(id);
	}
}



		

