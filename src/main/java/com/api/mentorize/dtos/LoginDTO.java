package com.api.mentorize.dtos;

public record LoginDTO(
        String email,
        String password,
        String phone
){
    @Override
    public String email() {
        return email;
    }
    @Override
    public String password() {
        return password;
    }
    @Override
    public String phone() { return phone; }

}
