package com.api.mentorize.services.configs;

import com.api.mentorize.models.Login;
import com.api.mentorize.repositories.registers.RegisterRepository;
import com.api.mentorize.models.Register;
import com.api.mentorize.dtos.RegisterDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;

    public Register save(RegisterDTO registerDTO, Optional<Login> loginDTO) {
        var register = new Register();
        BeanUtils.copyProperties(registerDTO, register);
        register.setLogin(loginDTO);
        return registerRepository.save(register);
    }

    public Register update(RegisterDTO registerDTO, UUID id) {
        return registerRepository.update(registerDTO, id);
    }

    public Set<Register> findAll(PageRequest pageRequest) {
        return registerRepository.findAll(pageRequest).toSet();
    }

    public Optional<Register> findById(UUID id) {
        Optional<Register> register = Optional.ofNullable(registerRepository.findById(id));
        return register;
    }
    public Optional<Register> findByEmail(String email) {
        Optional<Register> register = Optional.ofNullable(registerRepository.findByEmail(email));
        return register;
    }
    public void removeById(UUID id) {
        registerRepository.removeById(id);
    }

}
