package com.education.track.services;

import com.education.track.entities.Learner;
import com.education.track.repositories.LearnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService {

    private final LearnerRepository repository;

    public LearnerService(LearnerRepository repository) {
        this.repository = repository;
    }

    public List<Learner> getAll() {
        return repository.findAll();
    }

    public Learner getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Learner not found with id: " + id));
    }

    public Learner save(Learner learner) {
        return repository.save(learner);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}


