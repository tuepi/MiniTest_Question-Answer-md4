package com.example.questionanswerajax.controller;

import com.example.questionanswerajax.model.Answer;
import com.example.questionanswerajax.service.impl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    AnswerServiceImpl answerService;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> findAll() {
        List<Answer> products = (List<Answer>) answerService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        Optional<Answer> product = answerService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Answer> save(@RequestBody Answer question) {
        return new ResponseEntity<>(answerService.save(question), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> update(@PathVariable Long id, @RequestBody Answer question) {
        Optional<Answer> questionOptional = answerService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        return new ResponseEntity<>(answerService.save(question), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Answer> questionOptional = answerService.findById(id);
        if(!questionOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answerService.remove(id);
        return new ResponseEntity<>(questionOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Iterable<Answer>> findAllByQuestionId(@PathVariable Long id) {
        List<Answer> products = (List<Answer>) answerService.findAllByQuestionId(id);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
