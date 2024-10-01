package com.Quizz.Service;

import com.Quizz.Entity.Quizz;
import com.Quizz.Exceptions.ResourceNotFoundException;
import com.Quizz.Entity.Answer;
import com.Quizz.Entity.Questions;
import com.Quizz.Repo.QuestionsRepo;
import com.Quizz.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuestionsRepo questionsRepo;

    @Autowired
    private QuizRepo quizRepository;

    public Quizz startQuiz(Integer userId, String language, String difficulty) {
        // Fetch questions based on language and difficulty
        List<Questions> questions = questionsRepo.findByLanguageAndDifficulty(language, difficulty);

        if (questions.isEmpty()) {
            throw new ResourceNotFoundException("No questions found for the given criteria");
        }

        // Create a new Quiz instance
        Quizz quiz = new Quizz();
        quiz.setUserId(userId);
        quiz.setQuestions(questions);
        quiz.setTotalQuestions(questions.size());
        quiz.setCreatedAt(new Date());

        // Save the quiz
        return quizRepository.save(quiz);
    }

    public Quizz submitQuiz(Integer quizId, List<Answer> answers) {
        // Logic to evaluate answers and calculate scores
        Quizz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        int correctCount = 0;
        // Logic to count correct answers based on provided answers
        for (Answer answer : answers) {
            // Compare with quiz questions and increase correctCount accordingly
        }

        quiz.setCorrectAnswers(correctCount);
        quiz.setScore(calculateScore(correctCount, quiz.getTotalQuestions()));
        quiz.setTimeTaken(calculateTimeTaken()); // Implement this logic to get time taken

        return quizRepository.save(quiz); // Save results
    }

    private int calculateScore(int correctAnswers, int totalQuestions) {
        return (int) ((correctAnswers / (double) totalQuestions) * 100);
    }

    private double calculateTimeTaken() {
        // Implement logic to calculate time taken
        return 0; // Placeholder
    }
}
