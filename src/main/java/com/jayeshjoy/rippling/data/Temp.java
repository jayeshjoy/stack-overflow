package com.jayeshjoy.rippling.data;

import java.sql.Date;
import java.util.UUID;

public class Temp {
    private UUID id;
    private String name;
    private Date birthDate;
    private int titles;

    public Temp() {
    }

    public Temp(UUID id, String name, Date birthDate, int titles) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
