package com.api.mentorize.repositories.schedule;

import com.api.mentorize.models.Category;
import com.api.mentorize.models.Register;
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
    @Autowired
    private ICategoryRepository repoCat;

    public Page<Schedule> findAll(PageRequest pagina) {
        try {
            var schedule = repo.findAll(pagina);
            return schedule.map(prod -> new Schedule(prod));
        } catch (Exception e) {
            throw new RepositoryException("Failed to get all schedule !", e);
        }
    }

    public Schedule save(Schedule schedule) {
        try {
            repo.save(schedule);
            return schedule;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save schedule !", e);
        }
    }
    public Category saveCat(Category category) {
        try {
            repoCat.save(category);
            return category;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save category !", e);
        }
    }

    public Schedule findById(UUID id) {
        var schedule = repo.findById(id).orElseThrow(() -> new RepositoryException("Failed to get schedule by id!", null));
        return new Schedule(schedule);
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
            schedule.setClassTheme(scheduleDTO.classTheme());
            schedule.setAvailableHours(scheduleDTO.availableHours());
            schedule.setClassNumber(scheduleDTO.classNumber());
            schedule.setLocalType(scheduleDTO.localType());
            schedule.setDetailsLocal(scheduleDTO.detailsLocal());
            schedule.setEmail(scheduleDTO.email());
            schedule = repo.save(schedule);

            return schedule;
        } catch (Exception e) {
            throw new RepositoryException("Failed to save schedule !", e);
        }
    }
}
