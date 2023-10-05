package com.api.mentorize.controllers;

import com.api.mentorize.dtos.ReviewDTO;
import com.api.mentorize.models.CheckOut;
import com.api.mentorize.services.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
public class CheckOutController {
    @Autowired
    CheckOutService services;

    @PostMapping("/checkout/{register_id}")
    public ResponseEntity create(@PathVariable(value = "register_id") UUID register_id, @RequestBody ReviewDTO reviewDTO){
        var response = services.save(register_id, reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/checkout")
    public ResponseEntity<Set<CheckOut>> getAll(){
        var pagina = 0;
        var tamanho = 10;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var checkin = services.findAll(pageRequest);
        return ResponseEntity.ok(checkin);
    }
}
