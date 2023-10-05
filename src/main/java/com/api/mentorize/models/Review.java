package com.api.mentorize.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "tb_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private int score;
    private String comment;
    private LocalDateTime reviewDate;
    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Register student;

    public Review(){}

    public Review(Review entity) {
        this.id = entity.id;
        this.score = entity.score;
        this.comment = entity.comment;
        this.reviewDate = entity.reviewDate;
        this.student = entity.student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return reviewDate;
    }

    public void setDate(LocalDateTime date) {
        this.reviewDate = date;
    }

    public Register getStudent() {
        return student;
    }

    public void setStudent(Optional<Register> t) {
        this.student = t.orElse(new Register());;
    }
}
