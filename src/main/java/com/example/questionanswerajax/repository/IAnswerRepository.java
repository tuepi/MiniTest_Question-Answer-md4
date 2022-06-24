package com.example.questionanswerajax.repository;

import com.example.questionanswerajax.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAnswerRepository extends JpaRepository<Answer, Long> {
    Iterable<Answer> findAllByQuestionId(Long id);

    @Query(value = "select * from answer where question_id = ? and is_true = 0" , nativeQuery = true)
    Iterable<Answer> findAllByIsTrue(Long id);

}
