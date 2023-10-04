package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.Date;
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
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    private  CheckOut(){}

    public CheckOut(CheckOut entity) {
        this.id = entity.id;
        this.student = entity.student;
        this.endDate = entity.endDate;
        this.review = entity.review;
    }
}
