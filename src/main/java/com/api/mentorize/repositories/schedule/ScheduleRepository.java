package com.api.mentorize.repositories.schedule;

import com.api.mentorize.models.Schedule;
import com.api.mentorize.dtos.ScheduleDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import com.api.mentorize.repositories.exception.RepositoryException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class ScheduleRepository {
    @Autowired
    private IScheduleRepository repo;

    public Page<Schedule> findAll(PageRequest pagina) {
        try {
            var schedule = repo.findAll(pagina);
            return schedule.map(prod -> new Schedule(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get all schedule !", e);
        }
    }

    public Schedule save(Schedule electronicsModel) {
        try {
            repo.save(electronicsModel);
            return electronicsModel;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save schedule !", e);
        }
    }

    public Schedule findById(UUID id) {
        var electronic = repo.findById(id).orElseThrow(() -> new RepositoryException("Failed to get schedule by id!", null));
        return new Schedule(electronic);
    }

    public void removeById(UUID id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Entity not found with ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Base integrity violation");
        }
    }

    public Schedule update(ScheduleDTO scheduleDTO, UUID id) {
        try {
            Schedule schedule = repo.getOne(id);
            schedule.setAvailableDays(scheduleDTO.availableDays());
            schedule.setAvailableHours(scheduleDTO.availableHours());
            schedule.setClassNumber(scheduleDTO.classNumber());
            schedule.setLocalType(scheduleDTO.localType());
            schedule.setDetailsLocal(scheduleDTO.localDetails());
            schedule = repo.save(schedule);

            return new Schedule(schedule);
        } catch (Exception e) {
            throw new RepositoryException("Failed to save schedule !", e);
        }
    }
}
