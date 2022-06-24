package com.example.questionanswerajax.service.impl;

import com.example.questionanswerajax.model.Question;
import com.example.questionanswerajax.repository.IQuestionRepository;
import com.example.questionanswerajax.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}
