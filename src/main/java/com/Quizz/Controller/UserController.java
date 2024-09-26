package com.Quizz.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quizz.Entity.User;
import com.Quizz.Exceptions.UserAlreadyExistsException;
import com.Quizz.Service.UserService;

@RestController
@RequestMapping("api/users/")
public class UserController {
	
	private UserService userservice;
	
	
	
	
	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}




	@PostMapping("register")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
		
		userservice.register(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("successfully rigister ! Please Login to continue..");
		}
		catch(UserAlreadyExistsException e) {
			
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("user Already exits");
			
		}
		
		
	}
	
	

}
