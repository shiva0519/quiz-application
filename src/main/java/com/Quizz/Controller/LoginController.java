package com.Quizz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Quizz.Entity.Login;
import com.Quizz.Service.LoginService;

@Controller
@RequestMapping("api/login/")
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
	
	
	
	@PostMapping("Authenticate")
	public ResponseEntity<String> Authenticate(@RequestBody Login login){
		
		if(loginservice.Aunthentication(login)) {
			
			return ResponseEntity.status(HttpStatus.OK).body("Login successful");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Credentials");
	}
	
	
	
	

}
