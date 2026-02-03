package com.education.track.repositories;

import com.education.track.entities.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> { }
