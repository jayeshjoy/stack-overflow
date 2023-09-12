package com.jayeshjoy.rippling.data;

import java.util.UUID;

public class Answer {
    UUID id;
    UUID question;
    UUID author;
    String content;

    public Answer(UUID id, UUID question, UUID author, String content) {
        this.id = id;
        this.question = question;
        this.author = author;
        this.content = content;
    }

    public Answer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getQuestion() {
        return question;
    }

    public void setQuestion(UUID question) {
        this.question = question;
    }

    public UUID getAuthor() {
        return author;
    }

    public void setAuthor(UUID author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
