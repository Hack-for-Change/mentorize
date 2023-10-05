package com.api.mentorize.controllers;

import com.api.mentorize.dtos.RegisterDTO;
import com.api.mentorize.models.Register;
import com.api.mentorize.services.LoginService;
import com.api.mentorize.configs.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerServices;
    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody RegisterDTO registerDTO){
        var login = loginService.findByEmail(registerDTO.email());
        if (!login.isEmpty()) {
            var response = registerServices.save(registerDTO, login);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        else{
            return ResponseEntity.badRequest().body("User not found on this system");
        }
    }
    @GetMapping("/register/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<Register> response = registerServices.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found on this system");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/register")
    public ResponseEntity<Set<Register>> getAll(){
        var pagina = 0;
        var tamanho = 10;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var registers = registerServices.findAll(pageRequest);
        return ResponseEntity.ok(registers);

    }
    @PutMapping("/register/{id}")
    public ResponseEntity<Register> update(@PathVariable(value = "id") UUID id, @RequestBody RegisterDTO registerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(registerServices.update(registerDTO, id));
    }

    @DeleteMapping("/register/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        registerServices.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
