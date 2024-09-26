package com.Quizz.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quizz.Entity.Login;
import com.Quizz.Repo.LoginRepo;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepo loginrepo;

	@Override
	public boolean Aunthentication(Login login) {
		
		 Optional<Login> optionalUser = Optional.ofNullable(loginrepo.findByEmail(login.getEmail()));

		
		if(optionalUser.isEmpty()) {
			return false;
		}
		  Login user = optionalUser.get();
		  
		 if(user.getPassword().equals(login.getPassword())) {
			 return true;
		 }
		
		return false;
	}

}
