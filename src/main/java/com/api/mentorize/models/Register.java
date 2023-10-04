package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "tb_register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String photo;
    private String document;
    private Boolean teacher;
    private String classTheme;
    @ManyToOne
    @JoinColumn(name = "login_id", nullable = false)
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

}
