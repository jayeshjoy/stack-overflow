package com.jayeshjoy.rippling.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {
    final static private String CREATE_USER = "INSERT INTO User (ID, Name, " +
            "Email) VALUES (? ? ?)";
    final static private String GET_USER = "SELECT * FROM User WHERE ID = ?";
    final static private String GET_UPVOTES = "SELECT COUNT(*) FROM Upvotes " +
            "where AnswerAuthor = ?";
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createUser(User user) {
        return jdbcTemplate.update(
                CREATE_USER,
                user.getId(),
                user.getName(),
                user.getEmail());
    }

    public User fetchUser(UUID id) {
        User user = jdbcTemplate.queryForObject(GET_USER,
                new BeanPropertyRowMapper<>(User.class),
                id);
        Integer upvotes = jdbcTemplate.queryForObject(GET_UPVOTES,
                new BeanPropertyRowMapper<>(Integer.class));
        if (user == null || upvotes == null) {
            throw new IllegalArgumentException("User not found");
        }
        user.setUpvotes(upvotes);
        return user;
    }
}
