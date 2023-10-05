package com.api.mentorize.services;

import com.api.mentorize.models.CheckIn;
import com.api.mentorize.models.Register;
import com.api.mentorize.repositories.checkIn.CkeckInRepository;
import com.api.mentorize.repositories.registers.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckInService {
    @Autowired
    CkeckInRepository ckeckInRepository;
    @Autowired
    RegisterRepository registerRepository;
    public CheckIn save(UUID register_id) {
        Optional<Register> student = Optional.ofNullable(registerRepository.findById(register_id));

        var checkin = new CheckIn();
        checkin.setStudent(student);
        checkin.setStartDate(LocalDateTime.now());

        return ckeckInRepository.save(checkin);
    }
    public Set<CheckIn> findAll(PageRequest pageRequest) {
        return ckeckInRepository.findAll(pageRequest).toSet();
    }

}
