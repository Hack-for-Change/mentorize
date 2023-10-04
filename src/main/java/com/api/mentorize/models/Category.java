package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Register teacher;

    private Category(){}

    public Category(Category entity) {
        this.id = entity.id;
        this.name = entity.name;
        this.teacher = entity.teacher;
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

    public Register getTeacher() {
        return teacher;
    }

    public void setTeacher(Register teacher) {
        this.teacher = teacher;
    }
}
