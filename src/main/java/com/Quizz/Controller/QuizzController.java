package com.Quizz.Controller;

import com.Quizz.Entity.Answer;
import com.Quizz.Entity.QuizRequest;
import com.Quizz.Entity.Quizz;
import com.Quizz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizzController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<Quizz> startQuiz(@RequestBody QuizRequest quizRequest) {
        Quizz quiz = quizService.startQuiz(quizRequest.getUserId(), quizRequest.getLanguage(), quizRequest.getDifficulty());
        return ResponseEntity.ok(quiz);
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<Quizz> submitQuiz(@PathVariable Integer quizId, @RequestBody List<Answer> answers) {
        Quizz result = quizService.submitQuiz(quizId, answers);
        return ResponseEntity.ok(result);
    }
}
