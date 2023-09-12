package com.jayeshjoy.rippling.controllers;

import com.jayeshjoy.rippling.data.Answer;
import com.jayeshjoy.rippling.data.AnswerDao;
import com.jayeshjoy.rippling.data.Question;
import com.jayeshjoy.rippling.data.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class QuestionAnswerController {
    QuestionDao questionDao;
    AnswerDao answerDao;

    @Autowired
    public QuestionAnswerController(QuestionDao questionDao,
                                    AnswerDao answerDao) {
        this.questionDao = questionDao;
        this.answerDao = answerDao;
    }

    @GetMapping("/v1/question/{id}")
    public Question getQuestion(@PathVariable("id") UUID id) {
        return questionDao.fetchQuestion(id);
    }

    @DeleteMapping("/v1/question/{id}")
    public String deleteQuestion(@PathVariable("id") UUID id) {
        return "Successfully deleted " + questionDao.deleteQuestion(id) + " " +
                "question.";
    }

    @PostMapping("/v1/question")
    public String createQuestion(@RequestBody Question question) {
        return "Successfully created " + questionDao.createQuestion(question) + " " +
                "questions.";
    }

    @GetMapping("/v1/answer/{id}")
    public Answer getAnswer(@PathVariable("id") UUID id) {
        return answerDao.fetchAnswer(id);
    }

    @PostMapping("/v1/answer")
    public String createAnswer(@RequestBody Answer answer) {
        return "Successfully created " + answerDao.createAnswer(answer) + " " +
                "answers.";
    }

    @DeleteMapping("/v1/answer/{id}")
    public String deleteAnswer(@PathVariable("id") UUID id) {
        return "Successfully deleted " + answerDao.deleteAnswer(id) + " " +
                "answer.";
    }
}
