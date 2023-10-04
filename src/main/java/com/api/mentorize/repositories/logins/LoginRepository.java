package com.api.mentorize.repositories.logins;

import com.api.mentorize.models.Login;
import com.api.mentorize.repositories.exception.RepositoryException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.api.mentorize.dtos.LoginDTO;


import java.util.UUID;

@Repository
public class LoginRepository {
    @Autowired
    private ILoginRepository repo;

    public Page<Login> findAll(PageRequest pagina) {
        try {
            var login = repo.findAll(pagina);
            return login.map(prod -> new Login(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get login !", e);
        }
    }

    public Login save(Login login) {
        try {
            repo.save(login);
            return login;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save login !", e);
        }
    }

    public Login findByEmail(String email) {
        var login = repo.findByEmail(email).orElseThrow(() -> new RepositoryException("Failed to get login by email!", null));
        return new Login(login);
    }
    public Login findByPhone(String email) {
        var login = repo.findByPhone(email).orElseThrow(() -> new RepositoryException("Failed to get login by email!", null));
        return new Login(login);
    }
    public Login findById(UUID id) {
        var login = repo.findById(id).orElseThrow(() -> new RepositoryException("Failed to get login by id!", null));
        return new Login(login);
    }

    public void removeById(UUID id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Base integrity violation");
        }
    }

    public Login update(LoginDTO loginDTO, UUID id) {
        try {
            Login login = repo.getOne(id);
            login.setEmail(loginDTO.email());
            login.setPassword(loginDTO.password());
            login.setPhone(loginDTO.phone());
            login = repo.save(login);

            return new Login(login);
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }
}
