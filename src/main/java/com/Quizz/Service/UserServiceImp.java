package com.Quizz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quizz.Entity.Login;
import com.Quizz.Entity.User;
import com.Quizz.Exceptions.UserAlreadyExistsException;
import com.Quizz.Repo.LoginRepo;
import com.Quizz.Repo.UserRepo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private LoginRepo loginrepo;
	//@Autowired
	//private Login login;
	

	@Override
	public void register(User user) {

		if (userExits(user)) {
			throw new UserAlreadyExistsException("User with the given email already exists.");
		}

		userRepo.save(user);
		Login login=new Login();
		login.setPassword(user.getPassword());
		login.setEmail(user.getEmail());
		
		loginrepo.save(login);
		

	}

	private boolean userExits(User user) {

		if (userRepo.existsByEmail(user.getEmail())) {
			return true;
		}

		return false;
	}

}
