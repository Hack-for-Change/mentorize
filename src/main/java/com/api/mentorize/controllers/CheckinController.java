package com.api.mentorize.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import com.api.mentorize.models.CheckIn;
import com.api.mentorize.services.CheckInService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
public class CheckinController {
    @Autowired
    CheckInService services;

    @PostMapping("/checkin/{register_id}")
    public ResponseEntity create(@PathVariable(value = "register_id") UUID register_id){
        var response = services.save(register_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/checkin")
    public ResponseEntity<Set<CheckIn>> getAll(){
        var pagina = 0;
        var tamanho = 10;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var checkin = services.findAll(pageRequest);
        return ResponseEntity.ok(checkin);
    }
}
