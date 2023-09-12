package com.jayeshjoy.rippling.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class QuestionDao {
    final static private String CREATE_QUESTION =
            "INSERT INTO Questions (ID, Author, Content) VALUES (? ? ?)";
    final static private String GET_QUESTION =
            "SELECT * FROM Questions WHERE ID = ?";
    final static private String DELETE_QUESTION =
            "DELETE FROM Questions WHERE ID = ?";

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createQuestion(Question question) {
        return jdbcTemplate.update(
                CREATE_QUESTION,
                question.getId(),
                question.getAuthor(),
                question.getContent());
    }

    public Question fetchQuestion(UUID id) {
        Question question = jdbcTemplate.queryForObject(GET_QUESTION,
                new BeanPropertyRowMapper<>(Question.class),
                id);
        return question;
    }

    public int deleteQuestion(UUID id) {
        return jdbcTemplate.update(DELETE_QUESTION, id);
    }
}
