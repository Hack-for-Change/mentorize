package com.api.mentorize.models;

import jakarta.persistence.*;

import java.util.Date;
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
    private Date startDate;

    private  CheckIn(){}

    public CheckIn(CheckIn entity) {
        this.id = entity.id;
        this.student = entity.student;
        this.startDate = entity.startDate;
    }

}
