package com.example.questionanswerajax.controller;

import com.example.questionanswerajax.model.Question;
import com.example.questionanswerajax.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAll() {
        List<Question> products = (List<Question>) questionService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        Optional<Question> product = questionService.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Question> questionOptional = questionService.findById(id);
        if(!questionOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        questionService.remove(id);
        return new ResponseEntity<>(questionOptional.get(),HttpStatus.OK);
    }

}
