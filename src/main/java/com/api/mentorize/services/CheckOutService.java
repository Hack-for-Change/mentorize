package com.api.mentorize.services;

import com.api.mentorize.models.CheckOut;
import com.api.mentorize.models.Register;
import com.api.mentorize.models.Review;
import com.api.mentorize.dtos.ReviewDTO;
import com.api.mentorize.repositories.checkOut.CheckOutRepository;
import com.api.mentorize.repositories.registers.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckOutService {
    @Autowired
    CheckOutRepository checkOutRepository;
    @Autowired
    RegisterRepository registerRepository;
    public CheckOut save(UUID student_id, ReviewDTO reviewDTO) {
        Optional<Register> student = Optional.ofNullable(registerRepository.findById(student_id));

        var review = new Review();
        review.setStudent(student);
        review.setScore(reviewDTO.score());
        review.setComment(reviewDTO.comment());
        review.setStudent(student);
        review.setDate(LocalDateTime.now());
        var reviewSaved =  checkOutRepository.save(review);

        var checkOut = new CheckOut();
        checkOut.setStudent(student);
        checkOut.setEndDate(LocalDateTime.now());
        checkOut.setReview(reviewSaved);

        return checkOutRepository.save(checkOut);
    }
    public Set<CheckOut> findAll(PageRequest pageRequest) {
        return checkOutRepository.findAll(pageRequest).toSet();
    }

}
