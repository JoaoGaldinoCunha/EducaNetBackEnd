package br.com.school.educanet.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbCourse;
import br.com.school.educanet.service.CourseService;

@RestController
public class CourseController {
	
	
	@Autowired
	CourseService courseService;


	
	@PostMapping("/course/coursesave")
	public ResponseEntity<String> saveCourse(@RequestBody TbCourse tbCourse) {
        try {
            courseService.saveCourse(tbCourse);
        	return ResponseEntity
        			.status(HttpStatus.OK)
        			.body("Curso salvo");
        		
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@DeleteMapping("/course/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable long id) {
            return ResponseEntity
            		.status(HttpStatus.OK)
            		.body(courseService.deleteCourse(id));
    }
	

	@PutMapping("/course/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable Long courseId, @RequestBody TbCourse updatedCourse) {
         courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity
        		.ok("Curso Atualizado com sucesso");
    }
	
	
	@GetMapping("/course/AllCourses")
	public ResponseEntity<List<TbCourse>> getCourses() {
        List<TbCourse> courses = courseService.returningCourses();
        return ResponseEntity
        		.ok(courses);
    }
	
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Optional<TbCourse>> FindByIdCourse(@PathVariable Long id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.returningCourseById(id));
	}

	@GetMapping("/CoursesById/{id}")
	public ResponseEntity<String> searchingCoursesById(@PathVariable Long id){

		Gson gson =  new Gson();
		var result = courseService.userCourserById(id);
		var json = gson.toJson(result, ArrayList.class);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(json);
	}
}

