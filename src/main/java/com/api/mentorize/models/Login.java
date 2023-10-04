package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String password;
    private String phone;

    public Login(){}

    public Login(Login entity) {
        this.id = entity.id;
        this.email = entity.email;
        this.password = entity.password;
        this.phone = entity.phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
