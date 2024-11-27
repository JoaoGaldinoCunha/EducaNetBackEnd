package br.com.school.educanet.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.educanet.model.TbUser;
import br.com.school.educanet.service.UserService;

@RestController
public class UserController {
	
    @Autowired
    private UserService userService;    
    
    @PostMapping("/users")
    public ResponseEntity<String> saveUser(@RequestBody TbUser tbUser) {
        try {
            userService.saveUser(tbUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    	try {
            return ResponseEntity.ok(userService.deleteUserById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
