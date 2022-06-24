package com.example.questionanswerajax.repository;

import com.example.questionanswerajax.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
