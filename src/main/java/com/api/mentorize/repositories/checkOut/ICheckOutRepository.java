package com.api.mentorize.repositories.checkOut;

import com.api.mentorize.models.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICheckOutRepository extends JpaRepository<CheckOut, UUID> {}