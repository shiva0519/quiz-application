package com.Quizz.Entity;

import java.util.List;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {
	@Id
	private int questionId;
	private String question;
	private String language;
	private String difficulty;
	
	 @ElementCollection(fetch = FetchType.EAGER)
	    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
	    @Column(name = "option")
	    private List<String> options;
	private String explanation;

	public Questions(int questionId, String question,String language, String difficulty, List<String> options, String explanation) {
		super();
		this.questionId = questionId;
		this.question=question;
		this.language = language;
		this.difficulty = difficulty;
		this.options = options;
		this.explanation = explanation;
	}

	public Questions() {

	}
	
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	

}
