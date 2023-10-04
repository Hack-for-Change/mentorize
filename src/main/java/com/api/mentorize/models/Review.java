package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Number score;
    private String comment;
    private Date reviewDate;
    private Register student;

    private Review(){}

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

    public Number getScore() {
        return score;
    }

    public void setScore(Number score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return reviewDate;
    }

    public void setDate(Date date) {
        this.reviewDate = date;
    }

    public Register getStudent() {
        return student;
    }

    public void setStudent(Register student) {
        this.student = student;
    }
}
