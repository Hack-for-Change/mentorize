package com.api.mentorize.repositories.registers;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.mentorize.repositories.exception.RepositoryException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.api.mentorize.models.Register;
import com.api.mentorize.dtos.RegisterDTO;

import java.util.UUID;

@Repository
public class RegisterRepository {
    @Autowired
    private IRegisterRepository repo;

    public Page<Register> findAll(PageRequest pagina) {
        try {
            var registers = repo.findAll(pagina);
            return registers.map(prod -> new Register(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get all registers !", e);
        }
    }

    public Register save(Register register) {
        try {
            repo.save(register);
            return register;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save register !", e);
        }
    }

    public Register findById(UUID id) {
        var electronic = repo.findById(id).orElseThrow(() -> new RepositoryException("Failed to get register by id!", null));
        return new Register(electronic);
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

    public Register update(RegisterDTO RegisterDTO, UUID id) {
        try {
            Register register = repo.getOne(id);
            register.setClassTheme(RegisterDTO.classTheme());
            register.setName(RegisterDTO.name());
            register.setDocument(RegisterDTO.document());
            register.setPhoto(RegisterDTO.photo());

            register = repo.save(register);

            return new Register(register);
        } catch (Exception e) {
            throw new RepositoryException("Failed to save data !", e);
        }
    }
}
