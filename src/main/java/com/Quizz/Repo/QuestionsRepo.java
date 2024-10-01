package com.Quizz.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Quizz.Entity.Questions;

public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

	Questions getByQuestionId(int questionId);

  

	List<Questions> findByLanguageAndDifficulty(String language, String difficulty);

	void deleteByQuestionId(int questionId);
	

}
