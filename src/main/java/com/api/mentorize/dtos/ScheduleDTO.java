package com.api.mentorize.dtos;

import java.util.Date;
import com.api.mentorize.models.Register;

public record ScheduleDTO(
        Date availableDays,
        Date availableHours,
        Number classNumber,
        String localType,
        String localDetails,
        Register teacher
){
    @Override
    public Date availableDays() {
        return availableDays;
    }
    @Override
    public Date availableHours() {
        return availableHours;
    }
    @Override
    public Number classNumber() {
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
    public Register teacher() {
        return teacher;
    }
}
