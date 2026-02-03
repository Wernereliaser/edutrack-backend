package com.education.track.controllers;

import com.education.track.dtos.LearnerDTO;
import com.education.track.entities.Learner;
import com.education.track.mappers.LearnerMapper;
import com.education.track.services.LearnerService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learners")
public class LearnerController {

    private final LearnerService learnerService;

    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }

    /**
     * Get all learners
     */
    @GetMapping
    public ResponseEntity<List<LearnerDTO>> getAll() {
        var learners = learnerService.getAll();

        if (learners == null || learners.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<LearnerDTO> dtoList = learners.stream()
                .map(LearnerMapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    /**
     * Get learner by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<LearnerDTO> getById(
            @PathVariable
            @Parameter(description = "Learner id")
            Long id)
    {
        var learner = learnerService.getById(id);
        if (learner == null) {
            return ResponseEntity.notFound().build();
        }
        LearnerDTO dto = LearnerMapper.toDTO(learner);
        return ResponseEntity.ok(dto);
    }

    /**
     * Create a new learner
     */
    @PostMapping
    public ResponseEntity<LearnerDTO> create(@RequestBody LearnerDTO learnerDTO) {
        Learner learner = LearnerMapper.toEntity(learnerDTO);
        Learner savedLearner = learnerService.save(learner);

        LearnerDTO responseDTO = LearnerMapper.toDTO(savedLearner);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    /**
     * Update an existing learner
     */
    @PutMapping("/{id}")
    public ResponseEntity<LearnerDTO> update(
            @PathVariable Long id,
            @RequestBody LearnerDTO learnerDTO
    ) {
        Learner learner = LearnerMapper.toEntity(learnerDTO);
        learner.setId(id);

        Learner savedLearner = learnerService.save(learner);
        LearnerDTO responseDTO = LearnerMapper.toDTO(savedLearner);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /**
     * Delete learner by id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        learnerService.delete(id);
    }
}
