package com.api.mentorize.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "tb_checkout")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Register student;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    public CheckOut(){}

    public CheckOut(CheckOut entity) {
        this.id = entity.id;
        this.student = entity.student;
        this.endDate = entity.endDate;
        this.review = entity.review;
    }

    public Register getStudent() {
        return student;
    }

    public void setStudent(Optional<Register> t) {
        this.student = t.orElse(new Register());;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
