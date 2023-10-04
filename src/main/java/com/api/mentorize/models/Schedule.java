package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private Date availableDays;
    private Date availableHours;
    private Number classNumber;
    private String localType;
    private String detailsLocal;
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
        this.teacher = entity.teacher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Date availableDays) {
        this.availableDays = availableDays;
    }

    public Date getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(Date availableHours) {
        this.availableHours = availableHours;
    }

    public Number getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Number classNumber) {
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

    public void setTeacher(Register teacher) {
        this.teacher = teacher;
    }
}
