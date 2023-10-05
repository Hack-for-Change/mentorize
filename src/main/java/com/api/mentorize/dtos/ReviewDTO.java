package com.api.mentorize.dtos;

import java.time.LocalDateTime;

public record ReviewDTO(
        int score,
        String comment
){
    @Override
    public int score() {
        return score;
    }
    @Override
    public String comment() {
        return comment;
    }

}
