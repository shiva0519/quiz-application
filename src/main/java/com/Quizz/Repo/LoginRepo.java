package com.Quizz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quizz.Entity.Login;
import com.Quizz.Entity.User;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {

	void save(User user);

	

	Login findByEmail(String email);
	
	

}
