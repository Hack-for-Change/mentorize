package com.api.mentorize.repositories.logins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.mentorize.models.Login;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ILoginRepository extends JpaRepository<Login, UUID> {

    Optional<Login> findByEmail(String email);
    Optional<Login> findByPhone(String phone);

}