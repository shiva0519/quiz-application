package com.Quizz.Entity;

public class Answer {
	 private Integer questionId;
	    private String selectedOption;
	    
		public Integer getQuestionId() {
			return questionId;
		}
		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}
		public String getSelectedOption() {
			return selectedOption;
		}
		public void setSelectedOption(String selectedOption) {
			this.selectedOption = selectedOption;
		}
}
