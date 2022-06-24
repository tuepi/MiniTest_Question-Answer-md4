package com.example.questionanswerajax.service.impl;

import com.example.questionanswerajax.model.Answer;
import com.example.questionanswerajax.repository.IAnswerRepository;
import com.example.questionanswerajax.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    IAnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }

    public Iterable<Answer> findAllByQuestionId(Long id){
        return answerRepository.findAllByQuestionId(id);
    }

    public Iterable<Answer> findAllByIsTrue(Long id){
        return answerRepository.findAllByIsTrue(id);
    }
}
