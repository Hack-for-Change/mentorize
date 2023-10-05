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
    @JoinColumn(name = "tb_schedule", nullable = false)
    private Schedule schedule;

    public Category(){}

    public Category(Category entity) {
        this.id = entity.id;
        this.name = entity.name;
        this.schedule = entity.schedule;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
