package com.api.mentorize.dtos;

import com.api.mentorize.models.Login;

import java.util.Optional;

public record RegisterDTO(
        String name,
        String photo,
        String document,
        Boolean teacher,
        String email,
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
    public String email() {return email; }
    @Override
    public String document() {
        return document;
    }
    @Override
    public Boolean teacher() {
        return teacher;
    }
}
