package com.api.mentorize.services;

import com.api.mentorize.repositories.logins.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.api.mentorize.models.Login;
import com.api.mentorize.dtos.LoginDTO;


import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PasswordEncryptDecrypt passwordEncryptDecrypt;

    public Login save(LoginDTO loginDTO)  {
        var login = new Login();
        BeanUtils.copyProperties(loginDTO, login);
        String pass = null;
        try {
            pass = passwordEncryptDecrypt.encrypt(loginDTO.password(),"mentorizese");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        login.setPassword(pass);
        return loginRepository.save(login);
    }

    public Login update(LoginDTO loginDTO, UUID id) {
        return loginRepository.update(loginDTO, id);
    }

    public Set<Login> findAll(PageRequest pageRequest) {
        return loginRepository.findAll(pageRequest).toSet();
    }

    public Optional<Login> findById(UUID id) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findById(id));
        return login;
    }
    public Optional<Login> findByEmail(String email) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findByEmail(email));
        return login;
    }
    public Optional<Login> findByPhone(String phone) {
        Optional<Login> login = Optional.ofNullable(loginRepository.findByPhone(phone));
        return login;
    }

    public void removeById(UUID id) {
        loginRepository.removeById(id);
    }

}
