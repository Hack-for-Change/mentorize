package com.api.mentorize.repositories.schedule;


import com.api.mentorize.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, UUID> {}