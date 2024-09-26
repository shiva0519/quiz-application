package com.Quizz.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Quizz.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);
	

}
