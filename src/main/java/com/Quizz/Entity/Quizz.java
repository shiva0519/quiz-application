package com.Quizz.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Quizz {
	
	@Id
	private int quizId;
	private int userId;
	private List<Questions> questions;
	private int score;
	private int totalQuestions;
	private int correctAnswers;
	private double timeTaken;
	private Date createdAt;
	public Quizz(int quizId, int userId, List<Questions> questions, int score, int totalQuestions, int correctAnswers,
			double timeTaken, Date createdAt) {
		super();
		this.quizId = quizId;
		this.userId = userId;
		this.questions = questions;
		this.score = score;
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.timeTaken = timeTaken;
		this.createdAt = createdAt;
	}
	public Quizz() {
		
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public double getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	

}
