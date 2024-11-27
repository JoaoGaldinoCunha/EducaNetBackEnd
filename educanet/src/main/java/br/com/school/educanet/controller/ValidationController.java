package br.com.school.educanet.controller;



import br.com.school.educanet.model.response.UserResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.repository.UserRepository;
import br.com.school.educanet.service.ValidationService;

@RestController
public class ValidationController {
	
	
	@Autowired
    private  ValidationService validationService;
	
	@Autowired UserRepository userRepository;
	


    @PostMapping("/validateUser")
    public ResponseEntity<UserResponse> validateUser(@RequestBody TbUser user) {
          boolean validateUser =  validationService.ValditionUser(user.getEmail(), user.getPassword());
          if (validateUser) {
        	  var tbUser = userRepository.findByEmail(user.getEmail());

              UserResponse userResponse = new UserResponse();
              userResponse.setUserCpf(tbUser.getUserCpf());
              userResponse.setUserId(tbUser.getUserId());
              userResponse.setUserVerification(tbUser.getUserVerification());
              userResponse.setUserName(tbUser.getUserName());
              userResponse.setUserLastName(tbUser.getUserLastName());
              userResponse.setEmail(tbUser.getEmail());
              userResponse.setUserRegistation(tbUser.getUserRegistation());


              return ResponseEntity.status(HttpStatus.OK).body(userResponse);
          }

          return null;


    }
}


