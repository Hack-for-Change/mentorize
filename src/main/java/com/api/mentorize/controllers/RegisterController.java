package com.api.mentorize.controllers;

import com.api.mentorize.dtos.RegisterDTO;
import com.api.mentorize.models.Register;
import com.api.mentorize.services.RegisterService;

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
    RegisterService services;

    @PostMapping("/register")
    public ResponseEntity<Register> create(@RequestBody RegisterDTO registerDTO){
        var response = services.save(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/register/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<Register> response = services.findById(id);
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
        var registers = services.findAll(pageRequest);
        return ResponseEntity.ok(registers);

    }
    @PutMapping("/register/{id}")
    public ResponseEntity<Register> update(@PathVariable(value = "id") UUID id, @RequestBody RegisterDTO registerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(services.update(registerDTO, id));
    }

    @DeleteMapping("/register/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        services.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
