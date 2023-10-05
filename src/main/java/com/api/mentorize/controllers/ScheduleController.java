package com.api.mentorize.controllers;


import com.api.mentorize.services.configs.RegisterService;
import com.api.mentorize.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.mentorize.models.Schedule;
import com.api.mentorize.dtos.ScheduleDTO;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
public class ScheduleController {
    @Autowired
    ScheduleService services;
    @Autowired
    RegisterService registerServices;

    @PostMapping("/schedule")
    public ResponseEntity create(@RequestBody ScheduleDTO sheduleDTO){
        var register = registerServices.findByEmail(sheduleDTO.email());
        var category_name = "educacao";
        if (!register.isEmpty()) {
            var response = services.save(sheduleDTO, register, category_name);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        else{
            return ResponseEntity.badRequest().body("User not found on this system");
        }
    }
    @GetMapping("/schedule/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") UUID id){
        Optional<Schedule> response = services.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.badRequest().body("Schedule not found on this system");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/schedule")
    public ResponseEntity<Set<Schedule>> getAll(){
        var pagina = 0;
        var tamanho = 10;
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var registers = services.findAll(pageRequest);
        return ResponseEntity.ok(registers);
    }
    @PutMapping("/schedule/{id}")
    public ResponseEntity<Schedule> update(@PathVariable(value = "id") UUID id, @RequestBody ScheduleDTO sheduleDTO){
        return ResponseEntity.status(HttpStatus.OK).body(services.update(sheduleDTO, id));
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") UUID id){
        services.removeById(id);
        return ResponseEntity.noContent().build();
    }

}
