package com.Quizz.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Quizz.Entity.Questions;
import com.Quizz.Repo.QuestionsRepo;
import com.Quizz.Service.QuestionsServiceImp;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("api/questions/")
public class QuestionController {
	@Autowired
	private QuestionsServiceImp QuesServImp;
	@Autowired
	private QuestionsRepo quesRepo;
	
	
	
	@PostMapping("addQuestions/throughFile")
	public ResponseEntity <String> addQuestions(@RequestParam MultipartFile file) throws IOException {
		if(QuesServImp.addQuetions(file)) {
		return ResponseEntity.status(HttpStatus.CREATED).body("added successfully");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
	} 
	@PostMapping("addQuestions")
	public ResponseEntity <String> addQuestions(@RequestBody Questions que) throws IOException {
		if(QuesServImp.addQuetion(que)) {
		return ResponseEntity.status(HttpStatus.CREATED).body("added successfully");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
	} 
	
	@PutMapping("updateQuestion")
	public ResponseEntity<String> updateQuestion(@RequestBody Questions que){
		if(QuesServImp.updateQuestions(que)) {
			return ResponseEntity.status(HttpStatus.OK).body("updated successfully");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("upadted un-successfully");
		
	}
	@DeleteMapping("queId/{questionId}")
	 @Transactional
	public ResponseEntity<String> deleteQuestion(@PathVariable int questionId){
		 boolean isDeleted = QuesServImp.deleteQuestions(questionId);
		 if (quesRepo.existsById(questionId)) { // Check if the entity exists
		        quesRepo.deleteById(questionId); // Delete the entity by ID
	            return ResponseEntity.ok("Question deleted successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found.");
	        }
	}
	 @GetMapping("getQue")
	    public ResponseEntity<List<Questions>> getQuestions(
	            @RequestParam String language,
	            @RequestParam String difficulty) {
	        
	        // Assuming you have methods in your repository to handle filtering by language and difficulty
	        List<Questions> questions = quesRepo.findByLanguageAndDifficulty(language, difficulty);
	        
	        if (questions.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No questions found
	        }
	        return new ResponseEntity<>(questions, HttpStatus.OK);
	    }
}
