package com.api.mentorize.dtos;

import com.api.mentorize.models.Login;

public record RegisterDTO(
        String name,
        String photo,
        String document,
        Boolean teacher,
        String classTheme,
        Login login
) {
    @Override
    public String name() {
        return name;
    }
    @Override
    public String photo() {
        return photo;
    }
    @Override
    public String document() {
        return document;
    }
    @Override
    public Boolean teacher() {
        return teacher;
    }
    @Override
    public String classTheme() {
        return classTheme;
    }
    @Override
    public Login login() {
        return login;
    }
}
