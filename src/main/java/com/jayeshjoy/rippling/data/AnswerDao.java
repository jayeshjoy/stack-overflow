package com.jayeshjoy.rippling.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AnswerDao {
    final static private String CREATE_ANSWER =
            "INSERT INTO Answers (ID, Question, Author, Content) VALUES (? ? " +
                    "? ?)";
    final static private String GET_ANSWER =
            "SELECT * FROM Answers WHERE ID = ?";
    final static private String DELETE_ANSWER =
            "DELETE FROM Answers WHERE ID = ?";

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createAnswer(Answer answer) {
        return jdbcTemplate.update(
                CREATE_ANSWER,
                answer.getId(),
                answer.getQuestion(),
                answer.getAuthor(),
                answer.getContent());
    }

    public Answer fetchAnswer(UUID id) {
        Answer answer = jdbcTemplate.queryForObject(GET_ANSWER,
                new BeanPropertyRowMapper<>(Answer.class),
                id);
        return answer;
    }

    public int deleteAnswer(UUID id) {
        return jdbcTemplate.update(DELETE_ANSWER, id);
    }
}
