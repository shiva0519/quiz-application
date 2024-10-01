package com.Quizz.Entity;

public class QuizRequest {
	 private Integer userId;
	    private String language;
	    private String difficulty;
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
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

}
