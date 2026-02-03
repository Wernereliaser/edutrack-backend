package com.education.track.mappers;

import com.education.track.dtos.LearnerDTO;
import com.education.track.entities.Learner;

public class LearnerMapper {

    private LearnerMapper() {
        // Utility class
    }

    /* ===================== Entity → DTO ===================== */

    public static LearnerDTO toDTO(Learner learner) {
        if (learner == null) {
            return null;
        }

        LearnerDTO dto = new LearnerDTO();

        /* ========= Identity ========= */
        dto.setId(learner.getId());
        dto.setEmail(learner.getEmail());
        dto.setUsername(learner.getUsername());
        dto.setFirstName(learner.getFirstName());
        dto.setLastName(learner.getLastName());
        dto.setDateOfBirth(learner.getDateOfBirth());
        dto.setGender(learner.getGender());

        /* ========= Academic ========= */
        dto.setGrade(learner.getGrade());
        dto.setClassName(learner.getClassName());
        dto.setStudentNumber(learner.getStudentNumber());
        dto.setSchoolName(learner.getSchoolName());
        dto.setEnrollmentDate(learner.getEnrollmentDate());

        /* ========= Authorization ========= */
        dto.setRole(learner.getRole());

        /* ========= Status ========= */
        dto.setActive(learner.isActive());
        dto.setEmailVerified(learner.isEmailVerified());

        /* ========= Contact ========= */
        dto.setPhoneNumber(learner.getPhoneNumber());
        dto.setAddress(learner.getAddress());

        /* ========= Audit ========= */
        dto.setCreatedAt(learner.getCreatedAt());
        dto.setUpdatedAt(learner.getUpdatedAt());
        dto.setLastLoginAt(learner.getLastLoginAt());

        return dto;
    }

    /* ===================== DTO → Entity ===================== */

    public static Learner toEntity(LearnerDTO dto) {
        if (dto == null) {
            return null;
        }

        Learner learner = new Learner();

        /* ========= Identity ========= */
        learner.setId(dto.getId());
        learner.setEmail(dto.getEmail());
        learner.setUsername(dto.getUsername());
        learner.setFirstName(dto.getFirstName());
        learner.setLastName(dto.getLastName());
        learner.setDateOfBirth(dto.getDateOfBirth());
        learner.setGender(dto.getGender());

        /* ========= Academic ========= */
        learner.setGrade(dto.getGrade());
        learner.setClassName(dto.getClassName());
        learner.setStudentNumber(dto.getStudentNumber());
        learner.setSchoolName(dto.getSchoolName());
        learner.setEnrollmentDate(dto.getEnrollmentDate());

        /* ========= Authorization ========= */
        learner.setRole(dto.getRole());

        /* ========= Status ========= */
        learner.setActive(dto.isActive());
        learner.setEmailVerified(dto.isEmailVerified());

        /* ========= Contact ========= */
        learner.setPhoneNumber(dto.getPhoneNumber());
        learner.setAddress(dto.getAddress());

        /* ========= Audit ========= */
        learner.setCreatedAt(dto.getCreatedAt());
        learner.setUpdatedAt(dto.getUpdatedAt());
        learner.setLastLoginAt(dto.getLastLoginAt());

        return learner;
    }
}
