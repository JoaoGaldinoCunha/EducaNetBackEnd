package br.com.school.educanet.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.school.educanet.model.TbVideoCourse;
import br.com.school.educanet.repository.VideoCourseRepository;
import br.com.school.educanet.service.VideoCourseService;
@RestController
public class VideoCourseController {
	
	@Autowired
	private VideoCourseRepository videoCourseRepository;
	
	@Autowired
	private VideoCourseService videoCourseService;
	
	@PostMapping("/videoCourse/videopost")
	public ResponseEntity<String>saveVideoCourse(@RequestBody TbVideoCourse tbVideoCourse){
		TbVideoCourse existingCourseNameCourse = videoCourseRepository.findByName(tbVideoCourse.getVideoCourseName());
		if(existingCourseNameCourse != null) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Nome já cadastado!");
		}
		  videoCourseRepository.save(tbVideoCourse);
		  return ResponseEntity.status(HttpStatus.CREATED).body("Video Curso Criado");	
	}
	
	
	@DeleteMapping("/videoCourse/{id}")
	public ResponseEntity<String>deleteVideoCourse(@PathVariable Integer id){
		Optional<TbVideoCourse> existingVideoCourse = videoCourseRepository.findById(id);
		if(existingVideoCourse != null) {

			videoCourseRepository.deleteById(id);
			return ResponseEntity.ok("Usuário apago com sucesso!");
		}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado!");
	}


	
	
	  @PutMapping("/videoCourse/{courseId}")
	    public ResponseEntity<String> updateVideoCourse(@PathVariable Integer courseId, @RequestBody TbVideoCourse updatedCourse) {
	        videoCourseService.updateVideoCourse(courseId, updatedCourse);
	        return ResponseEntity.ok("savlo com sucesso");
	    }


	@GetMapping("/VideoCoursesById/{id}")
	public ResponseEntity<String> searchingVideoCoursesById(@PathVariable Long id){

		Gson gson =  new Gson();
		var result = videoCourseService.userVideoCourserById(id);
		var json = gson.toJson(result, ArrayList.class);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(json);
	}

	@GetMapping("/allVideoCourses")
	public ResponseEntity<String> allVideoCourses() {
		Gson gson = new Gson();
		var result = videoCourseService.allVideoCourses();
		var json = gson.toJson(result, ArrayList.class);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(json);
	}

	@GetMapping("/VideoCourserById/{id}")
	public ResponseEntity<String> searchingVideoById(@PathVariable Long id){

		Gson gson =  new Gson();
		var result = videoCourseService.searchingVideoCourserById(id);
		var json = gson.toJson(result, ArrayList.class);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(json);
	}

}

