package com.api.mentorize.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String availableDays;
    private String availableHours;
    private int classNumber;
    private String localType;
    private String classTheme;
    private String detailsLocal;
    private String email;
    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Register teacher;

    public Schedule(){}

    public Schedule(Schedule entity) {
        this.id = entity.id;
        this.availableDays = entity.availableDays;
        this.availableHours = entity.availableHours;
        this.classNumber = entity.classNumber;
        this.localType = entity.localType;
        this.detailsLocal = entity.detailsLocal;
        this.email = entity.email;
        this.classTheme = entity.classTheme;
        this.teacher = entity.teacher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(String availableHours) {
        this.availableHours = availableHours;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getLocalType() {
        return localType;
    }

    public void setLocalType(String localType) {
        this.localType = localType;
    }

    public String getDetailsLocal() {
        return detailsLocal;
    }

    public void setDetailsLocal(String detailsLocal) {
        this.detailsLocal = detailsLocal;
    }

    public Register getTeacher() {
        return teacher;
    }
    public String getClassTheme() {
        return classTheme;
    }
    public void setClassTheme(String classTheme) {
        this.classTheme = classTheme;
    }

    public void setTeacher(Optional<Register> t) {
       teacher = t.orElse(new Register());
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
