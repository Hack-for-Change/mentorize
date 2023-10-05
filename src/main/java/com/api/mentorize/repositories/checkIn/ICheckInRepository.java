package com.api.mentorize.repositories.checkIn;

import com.api.mentorize.models.CheckIn;
import com.api.mentorize.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICheckInRepository extends JpaRepository<CheckIn, UUID> {}