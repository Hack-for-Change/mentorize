package com.api.mentorize.services;

import com.api.mentorize.models.Category;
import com.api.mentorize.models.Register;
import com.api.mentorize.models.Schedule;
import com.api.mentorize.dtos.ScheduleDTO;
import com.api.mentorize.repositories.registers.RegisterRepository;
import com.api.mentorize.repositories.schedule.ScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.Set;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule save(ScheduleDTO scheduleDTO, Optional<Register> register, String categoryName) {
        var schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        schedule.setTeacher(register);
        var scheduleSaved =  scheduleRepository.save(schedule);
        var category = new Category();
        category.setSchedule(scheduleSaved);
        category.setName(categoryName);
    //Todo save category
        return scheduleSaved;
    }

    public Schedule update(ScheduleDTO scheduleDTO, UUID id) {
        return scheduleRepository.update(scheduleDTO, id);
    }

    public Set<Schedule> findAll(PageRequest pageRequest) {
        return scheduleRepository.findAll(pageRequest).toSet();
    }

    public Optional<Schedule> findById(UUID id) {
        Optional<Schedule> oneElectronics = Optional.ofNullable(scheduleRepository.findById(id));
        return oneElectronics;
    }

    public void removeById(UUID id) {
        scheduleRepository.removeById(id);
    }


}
