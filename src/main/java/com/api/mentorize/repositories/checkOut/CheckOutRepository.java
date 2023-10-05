package com.api.mentorize.repositories.checkOut;

import com.api.mentorize.models.CheckOut;
import com.api.mentorize.models.Review;
import com.api.mentorize.repositories.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class CheckOutRepository {
    @Autowired
    private ICheckOutRepository repo;
    @Autowired
    private IReviewRepository repoReview;

    public Page<CheckOut> findAll(PageRequest pagina) {
        try {
            var checkOut = repo.findAll(pagina);
            return checkOut.map(prod -> new CheckOut(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get checkOut !", e);
        }
    }

    public CheckOut save(CheckOut checkOut) {
        try {
            repo.save(checkOut);
            return checkOut;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save checkOut !", e);
        }
    }
    public Review save(Review review) {
        try {
            repoReview.save(review);
            return review;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save Review !", e);
        }
    }
}
