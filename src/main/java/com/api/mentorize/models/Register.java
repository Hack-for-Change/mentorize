package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String photo;
    private String document;
    private Boolean teacher;
    private String classTheme;
    private Login login;
    public Register(){};
    public Register(Register entity) {
        this.id = entity.id;
        this.name = entity.name;
        this.photo = entity.photo;
        this.document = entity.document;
        this.teacher = entity.teacher;
        this.classTheme = entity.classTheme;
        this.login = entity.login;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public String getClassTheme() {
        return classTheme;
    }

    public void setClassTheme(String classTheme) {
        this.classTheme = classTheme;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(String pass, String email, String phone) {
        login = new Login();
        //login.save(pass, email, phone);
        this.login = login;
    }
}
