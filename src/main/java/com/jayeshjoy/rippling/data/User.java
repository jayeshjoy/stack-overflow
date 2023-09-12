package com.jayeshjoy.rippling.data;

import java.util.UUID;

public class User {
    UUID id;
    String name;
    String email;
    int upvotes;

    public User() {
    }

    public User(UUID id, String name, String email, int upvotes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.upvotes = upvotes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
