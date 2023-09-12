package com.jayeshjoy.rippling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Stack overflow.
Create users.
Users can post/edit/delete questions.
Users can post/edit/delete answers.
Users can upvote answers.
Users get a score based on their up-votes.
View endpoints for question by id. Returns question and list of answers.
View answer by id.
* */
@SpringBootApplication
public class RipplingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RipplingApplication.class, args);
	}

}
