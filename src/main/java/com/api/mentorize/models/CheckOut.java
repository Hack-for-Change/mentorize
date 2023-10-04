package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_checkout")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Register student;
    private Date endDate;
    private Review review;

    private  CheckOut(){}

    public CheckOut(CheckOut entity) {
        this.id = entity.id;
        this.student = entity.student;
        this.endDate = entity.endDate;
        this.review = entity.review;
    }
}
