package com.api.mentorize.dtos;

import com.api.mentorize.models.Register;

public record ScheduleDTO(
        String availableDays,
        String availableHours,
        int classNumber,
        String localType,
        String localDetails,
        String classTheme,

        String email,
        Register teacher
){
    @Override
    public String availableDays() {
        return availableDays;
    }
    @Override
    public String availableHours() {
        return availableHours;
    }
    @Override
    public int classNumber() {
        return classNumber;
    }
    @Override
    public String localType() {
        return localType;
    }
    @Override
    public String localDetails() {
        return localDetails;
    }
    @Override
    public String email() {
        return email;
    }
    @Override
    public Register teacher() {
        return teacher;
    }
    @Override
    public String classTheme() {
        return classTheme;
    }
}
