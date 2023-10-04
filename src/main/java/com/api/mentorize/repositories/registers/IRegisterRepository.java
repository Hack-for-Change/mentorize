package com.api.mentorize.repositories.registers;

import com.api.mentorize.models.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRegisterRepository extends JpaRepository<Register, UUID> {}