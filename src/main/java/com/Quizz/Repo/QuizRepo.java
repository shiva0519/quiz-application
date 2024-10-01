package com.Quizz.Repo;

import com.Quizz.Entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quizz, Integer> {
    // You can define custom query methods if needed
}
