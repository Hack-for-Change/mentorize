package com.api.mentorize.controllers;

import com.api.mentorize.dtos.LoginDTO;
import com.api.mentorize.models.Login;
import com.api.mentorize.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    LoginService services;

    @PostMapping("/login")
    public ResponseEntity<Login> create(@RequestBody LoginDTO loginDTO){
        var response = services.save(loginDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/login")
    public ResponseEntity get(@RequestBody LoginDTO loginDTO){
        Optional<Login> response;
        if(!loginDTO.email().isEmpty() )
            response = services.findByEmail(loginDTO.email());
            else
                response = services.findByPhone(loginDTO.phone());

        if (response.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found on this system");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/login/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        var response =  services.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found on this system");
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        services.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
