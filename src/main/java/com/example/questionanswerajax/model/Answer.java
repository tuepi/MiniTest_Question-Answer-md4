package com.example.questionanswerajax.model;

import javax.persistence.*;

@Entity
public class Answer {

    //Viết API + Ajax cho bài toán làm Quizz
    //- 1 câu hỏi có thể có 1 hoặc nhiều câu trả lời
    //=> Question: id, content, type
    //Answer: id, name, question_id, isTrue
    //Cơ bản:
    //- API CRUD Answer, CRUD Question
    //- AJAX: CRUD answer
    //Nâng cao:
    //- AJAX: CRUD Question

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Question question;
    private int isTrue;

    public Answer() {
    }

    public Answer(Long id, String name, Question question, int isTrue) {
        this.id = id;
        this.name = name;
        this.question = question;
        this.isTrue = isTrue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }
}
