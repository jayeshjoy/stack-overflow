package com.jayeshjoy.rippling.data;

import java.util.UUID;

public class Question {
    UUID id;
    UUID author;
    String content;

    public Question() {
    }

    public Question(UUID id, UUID author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
