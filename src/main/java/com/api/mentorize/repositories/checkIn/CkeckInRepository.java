package com.api.mentorize.repositories.checkIn;

import com.api.mentorize.models.CheckIn;
import com.api.mentorize.repositories.exception.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class CkeckInRepository {
    @Autowired
    private ICheckInRepository repo;

    public Page<CheckIn> findAll(PageRequest pagina) {
        try {
            var checkIn = repo.findAll(pagina);
            return checkIn.map(prod -> new CheckIn(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get checkIn !", e);
        }
    }

    public CheckIn save(CheckIn checkIn) {
        try {
            repo.save(checkIn);
            return checkIn;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save checkIn !", e);
        }
    }
}
