package com.api.mentorize.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
@Entity
@Table(name = "tb_checkin")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Register student;
    private LocalDateTime startDate;

    public CheckIn(){}

    public CheckIn(CheckIn entity) {
        this.id = entity.id;
        this.student = entity.student;
        this.startDate = entity.startDate;
    }

    public Register getStudent() {
        return student;
    }

    public void setStudent(Optional<Register> t) {
        this.student = t.orElse(new Register());;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
