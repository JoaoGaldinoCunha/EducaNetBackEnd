package br.com.school.educanet.controller;

import br.com.school.educanet.model.request.UserCourseRequest;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import br.com.school.educanet.service.UserCourseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;


@RestController
public class UserCouserController {
	
	@Autowired
	UserCourseService userCourseService;

	@PostMapping("/JoinUserInCourse")
	public ResponseEntity<String> insertUserAndCourse(@RequestBody UserCourseRequest userCourseRequest){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userCourseService.saveUserInCourse(userCourseRequest.getUserId(), userCourseRequest.getCourseId()));
	}

	@DeleteMapping("/RemoveUserFromCourse")
	public ResponseEntity<String> removeUserFromCourse(@RequestBody UserCourseRequest userCourseRequest){
		return ResponseEntity
				.ok()
				.body(userCourseService.removeUserFromCourse(userCourseRequest.getUserId(), userCourseRequest.getCourseId()));
	}

	@GetMapping("/courseUser/{id}")
	public ResponseEntity<String> searchUsersByCourseId(@PathVariable Long id){

		Gson gson =  new Gson();
		var result = userCourseService.searchUserInCourse(id);
		var json = gson.toJson(result, ArrayList.class);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(json);
	}


}
