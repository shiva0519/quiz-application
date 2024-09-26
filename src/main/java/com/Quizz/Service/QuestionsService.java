package com.Quizz.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.Quizz.Entity.Questions;

public interface QuestionsService {

	public boolean addQuetions(MultipartFile file) throws IOException;
	public boolean updateQuestions(Questions que);
	public boolean deleteQuestions(Questions que);
	public boolean addQuetion(Questions que);
	
}
